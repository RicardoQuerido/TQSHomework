package ua.pt.restapi.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.pt.restapi.dao.WeatherDAO;
import ua.pt.restapi.models.District;
import ua.pt.restapi.models.DistrictData;
import ua.pt.restapi.models.WeatherData;
import ua.pt.restapi.models.WeatherForecast;
import ua.pt.restapi.models.WeatherForecastData;
import ua.pt.restapi.models.WindSpeedData;
/**
 *
 * @author Ricardo Querido
 */
@WebServlet("/weather/*")
public class WeatherServlet extends HttpServlet {

    private static final long serialVersionUID = -5832176047021911038L;

    @EJB
    private WeatherDAO weatherDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        District district = weatherDAO.getDistricts();
        List<DistrictData> districtData = new ArrayList<>();

        for (DistrictData w : district.getData()) {
            districtData.add(w);
        }

        request.setAttribute("districtData", districtData);
        try {
            request.getRequestDispatcher("WEB-INF/weather.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(WeatherServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");

        WeatherForecast w = weatherDAO.getWeatherForecastByDistrict(weatherDAO.translateDistrict(name));
        List<String> wType = new ArrayList<>();
        List<String> windSpeedList = new ArrayList<>();
        for(WeatherForecastData data : w.getData()){
          WeatherData weatherType = weatherDAO.findWeatherById(data.getIdWeatherType());
          wType.add(weatherType.getDescIdWeatherTypeEN());
          WindSpeedData windSpeedC = weatherDAO.findWindSpeedById(data.getClassWindSpeed()+"");
          windSpeedList.add(windSpeedC.getDescClassWindSpeedDailyEN());
        }
        request.setAttribute("districtData", w.getData());
        request.setAttribute("name", name);
        request.setAttribute("weatherTypes", wType);
        request.setAttribute("windSpeedList", windSpeedList);
        try {
            request.getRequestDispatcher("WEB-INF/weatherDistrict.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(WeatherServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
