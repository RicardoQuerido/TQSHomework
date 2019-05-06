package ua.pt.restapi.service;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import ua.pt.restapi.models.District;
import ua.pt.restapi.models.Weather;
import ua.pt.restapi.models.WeatherForecast;
import ua.pt.restapi.models.WindSpeed;

/**
 *
 * @author Ricardo Querido
 */
@Stateless
public class WeatherService {

    public WeatherForecast consumeWeatherForecast(String globalIdLocal) {
        //previsão de tempo 5 dias
        String targetUrl = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/"+globalIdLocal+".json";
        Client client = ClientBuilder.newClient();

        Response response = client.target(targetUrl).request().get();
        WeatherForecast wf = response.readEntity(WeatherForecast.class);

        response.close();
        client.close();

        return wf;
    }

    public WindSpeed consumeWindSpeed() {
        //Lista de classes relativa à intensidade vento
        String targetUrl= "http://api.ipma.pt/open-data/wind-speed-daily-classe.json";
        
        //previsão de vento
        Client client = ClientBuilder.newClient();

        Response response = client.target(targetUrl).request().get();
        WindSpeed wf = response.readEntity(WindSpeed.class);

        response.close();
        client.close();

        return wf;
    }

    public District consumeDistrict() {
        //Lista de identificadores para as capitais distrito e ilhas
        String targetUrl = "http://api.ipma.pt/open-data/distrits-islands.json";
        Client client = ClientBuilder.newClient();

        Response response = client.target(targetUrl).request().get();
        District wf = response.readEntity(District.class);

        response.close();
        client.close();

        return wf;
    }

    public Weather consumeWeather() {
        //Lista de identificadores do tempo significativo 
        String targetUrl = "http://api.ipma.pt/open-data/weather-type-classe.json";
        Client client = ClientBuilder.newClient();

        Response response = client.target(targetUrl).request().get();
        Weather wf = response.readEntity(Weather.class);

        response.close();
        client.close();

        return wf;
    }

}
