package ua.pt.restapi.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.pt.restapi.models.CacheStats;
import ua.pt.restapi.models.District;
import ua.pt.restapi.models.DistrictData;
import ua.pt.restapi.models.Weather;
import ua.pt.restapi.models.WeatherData;
import ua.pt.restapi.models.WeatherForecast;
import ua.pt.restapi.models.WindSpeed;
import ua.pt.restapi.models.WindSpeedData;
import ua.pt.restapi.service.WeatherService;

@Stateless
public class WeatherDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    @Inject
    WeatherService service;

    //Weathers
    public Weather getWeather() {
        List<Weather> weather = em.createNamedQuery("Weather.findAll", Weather.class).getResultList();
        CacheStats cacheStats = this.getCacheStats();
        cacheStats.setNumberOfRequests(cacheStats.getNumberOfRequests() + 1);
        if (weather.isEmpty()) {
            cacheStats.setNumberOfMisses(cacheStats.getNumberOfMisses() + 1);
            Weather w = service.consumeWeather();
            this.createWeather(w);
            weather.add(w);
        } else {
            cacheStats.setNumberOfHits(cacheStats.getNumberOfHits() + 1);
        }
        this.updateCacheStats(cacheStats);

        return weather.get(0);
    }

    public WeatherData findWeatherById(int idWeatherType) {
        for (WeatherData w : this.getWeather().getData()) {
            if (w.getIdWeatherType() == idWeatherType) {
                return w;
            }
        }
        return null;
    }

    public void createWeather(Weather weather) {
        em.persist(weather);
    }

    public void deleteWeather(Weather weather) {
        if (!em.contains(weather)) {
            weather = em.merge(weather);
        }

        em.remove(weather);
    }

    //WindSpeed
    public WindSpeed getWindSpeed() {
        List<WindSpeed> windSpeed = em.createNamedQuery("WindSpeed.findAll", WindSpeed.class).getResultList();
        CacheStats cacheStats = this.getCacheStats();
        cacheStats.setNumberOfRequests(cacheStats.getNumberOfRequests() + 1);
        if (windSpeed.isEmpty()) {
            cacheStats.setNumberOfMisses(cacheStats.getNumberOfMisses() + 1);
            WindSpeed ws = service.consumeWindSpeed();
            this.createWindSpeed(ws);
            windSpeed.add(ws);
        } else {
            cacheStats.setNumberOfHits(cacheStats.getNumberOfHits() + 1);
        }
        this.updateCacheStats(cacheStats);

        return windSpeed.get(0);
    }

    public WindSpeedData findWindSpeedById(String classWindSpeed) {
        for (WindSpeedData ws : this.getWindSpeed().getData()) {
            if (ws.getClassWindSpeed().equals(classWindSpeed)) {
                return ws;
            }
        }
        return null;
    }

    public void createWindSpeed(WindSpeed windSpeed) {
        em.persist(windSpeed);
    }

    public void deleteWindSpeed(WindSpeed windSpeed) {
        if (!em.contains(windSpeed)) {
            windSpeed = em.merge(windSpeed);
        }

        em.remove(windSpeed);
    }

    //WeatherForecast
    public List getAllWeatherForecast() {
        return em.createNamedQuery("WeatherForecast.findAll", WeatherForecast.class).getResultList();
    }

    public void updateWeatherForecast(WeatherForecast weatherForecast) {
        em.merge(weatherForecast);
    }

    public void createWeatherForecast(WeatherForecast weatherForecast) {
        em.persist(weatherForecast);
    }

    public void deleteWeatherForecast(WeatherForecast weatherForecast) {
        if (!em.contains(weatherForecast)) {
            weatherForecast = em.merge(weatherForecast);
        }

        em.remove(weatherForecast);
    }

    public WeatherForecast getWeatherForecastByDistrict(String globalId) {
        List<WeatherForecast> wf = this.getAllWeatherForecast();
        List<WeatherForecast> newwf = new ArrayList<>();
        CacheStats cacheStats = this.getCacheStats();
        cacheStats.setNumberOfRequests(cacheStats.getNumberOfRequests() + 1);
        if (wf.isEmpty()) {
            cacheStats.setNumberOfMisses(cacheStats.getNumberOfMisses() + 1);

            WeatherForecast w = service.consumeWeatherForecast(globalId);
            w.setLastRefresh(new Date());
            this.updateWeatherForecast(w);
            newwf.add(w);
        } else {
            for (WeatherForecast x : wf) {
                if (Integer.toString(x.getGlobalIdLocal()).equals(globalId)) {
                    newwf.add(x);
                }
            }

            if (newwf.isEmpty()) {
                cacheStats.setNumberOfMisses(cacheStats.getNumberOfMisses() + 1);

                WeatherForecast w = service.consumeWeatherForecast(globalId);
                w.setLastRefresh(new Date());
                this.createWeatherForecast(w);
                newwf.add(w);
            } else {
                cacheStats.setNumberOfHits(cacheStats.getNumberOfHits() + 1);
            }
        }
        this.updateCacheStats(cacheStats);

        if (newwf.size() > 1) {
            Collections.sort(newwf, (WeatherForecast wf1, WeatherForecast wf2) -> wf2.getLastRefresh().compareTo(wf1.getLastRefresh()));
        }

        return newwf.get(0);
    }

    //District
    public District getDistricts() {
        List<District> districts = em.createNamedQuery("District.findAll", District.class).getResultList();
        CacheStats cacheStats = this.getCacheStats();
        cacheStats.setNumberOfRequests(cacheStats.getNumberOfRequests() + 1);
        if (districts.isEmpty()) {
            cacheStats.setNumberOfMisses(cacheStats.getNumberOfMisses() + 1);

            District ws = service.consumeDistrict();
            this.createDistrict(ws);
            districts.add(ws);
        } else {
            cacheStats.setNumberOfHits(cacheStats.getNumberOfHits() + 1);
        }
        this.updateCacheStats(cacheStats);
        return districts.get(0);
    }

    public String translateDistrict(String local) {
        District d = this.getDistricts();
        String id = null;
        for (DistrictData cd : d.getData()) {
            if (local.equalsIgnoreCase(cd.getLocal())) {
                id = Integer.toString(cd.getGlobalIdLocal());
                break;
            }
        }
        return id;
    }

    public DistrictData findDistrictById(Long id) {

        List<District> district = em.createNamedQuery("District.findAll", District.class).getResultList();
        for (DistrictData ws : district.get(0).getData()) {
            if (ws.getIdDistrito() == id) {
                return ws;
            }
        }
        return null;
    }

    public void createDistrict(District district) {
        em.persist(district);
    }

    public void deleteDistrict(District district) {
        if (!em.contains(district)) {
            district = em.merge(district);
        }

        em.remove(district);
    }

    //CacheStats
    public CacheStats getCacheStats() {
        List<CacheStats> list = em.createNamedQuery("CacheStats.find", CacheStats.class).getResultList();
        if (list.isEmpty()) {
            CacheStats cache = new CacheStats(0, 0, 0);
            this.createCacheStats(cache);
            list.add(cache);
        }

        return list.get(0);
    }

    public CacheStats findCacheStats(Long id) {
        List<CacheStats> cache = em.createNamedQuery("CacheStats.find", CacheStats.class).getResultList();
        if (cache.get(0).getId() == id) {
            return cache.get(0);
        }
        return null;
    }

    public void createCacheStats(CacheStats cacheStats) {
        em.persist(cacheStats);
    }

    public void updateCacheStats(CacheStats cacheStats) {
        em.merge(cacheStats);
    }

    public void deleteCacheStats(CacheStats cacheStats) {
        if (!em.contains(cacheStats)) {
            cacheStats = em.merge(cacheStats);
        }

        em.remove(cacheStats);
    }

}
