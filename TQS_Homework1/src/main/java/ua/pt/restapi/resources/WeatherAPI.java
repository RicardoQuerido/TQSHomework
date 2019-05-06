package ua.pt.restapi.resources;

import ua.pt.restapi.dao.WeatherDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ua.pt.restapi.models.CacheStats;
import ua.pt.restapi.models.District;
import ua.pt.restapi.models.Weather;
import ua.pt.restapi.models.WeatherForecast;
import ua.pt.restapi.models.WindSpeed;
import ua.pt.restapi.service.WeatherService;

@RequestScoped
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WeatherAPI {

    @Inject
    WeatherDAO weatherDAO;
    
    @Inject
    WeatherService service;

    @GET
    @Path("windspeeds")
    public Response getWindSpeed() {
        WindSpeed ws = weatherDAO.getWindSpeed();
        return Response.ok(ws).build();
    }
    
    @GET
    @Path("districts")
    public Response getAllDistrict() {
        District district = weatherDAO.getDistricts();
        return Response.ok(district).build();
    }
    
    @GET
    @Path("getweather/{cidade}")
    public Response getWeatherForecast(@PathParam("cidade") String cidade) {
        WeatherForecast wf = weatherDAO.getWeatherForecastByDistrict(weatherDAO.translateDistrict(cidade));
        return Response.ok(wf).build();
    }
    
    @GET
    @Path("allweather")
    public Response getAllWeather() {
        Weather weather = weatherDAO.getWeather();
        return Response.ok(weather).build();
    }
    
    @GET
    @Path("cachestats")
    public Response getCacheStats() {
        CacheStats cacheStats = weatherDAO.getCacheStats();
        return Response.ok(cacheStats).build();
    }
}
