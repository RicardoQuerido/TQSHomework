<%--
    Document   : weatherDistrict
    Created on : 2/mai/2019, 17:12:28
    Author     : Ricardo Querido
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="ua.pt.restapi.models.WeatherForecastData"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-11">
                    <h1>Weather in ${name}</h1>
                </div>
                <div class="col-1">
                     <a href="./weather"><button type="button" id="back" class="btn btn-primary" style="margin-top: 10px">Go back</button></a>
                </div>
               
            </div>

            <c:forEach items="${districtData}" var="district" varStatus="status" >

                <table class="table table-bordered">
                    <h2>${district.forecastDate}</h2>
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col" id="name">Name</th>
                            <th scope="col" id="info">Info</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row" id="precProb">Precipitation Probability</th>
                            <td>${district.precipitaProb}</td>
                        </tr>
                        <tr>
                            <th scope="row" id="minTemp">Min Temperature</th>
                            <td>${district.tMin}</td>
                        </tr>
                        <tr>
                            <th scope="row" id="maxTemp">Max Temperature</th>
                            <td>${district.tMax}</td>
                        </tr>
                        <tr>
                            <th scope="row" id="windDirection">Wind Direction</th>
                            <td>${district.predWindDir}</td>
                        </tr>
                        <tr>
                            <th scope="row" id="weatherType">Weather Type</th>
                            <td>${weatherTypes.get(status.index)}</td>

                        </tr>
                        <tr>
                            <th scope="row" id="classWindSpeed">Class Wind Speed</th>
                            <td>${windSpeedList.get(status.index)}</td>
                        </tr>
                        <tr>
                            <th scope="row" id="longitude">Longitude</th>
                            <td>${district.longitude}</td>
                        </tr>
                        <tr>
                            <th scope="row" id="latitude">Latitude</th>
                            <td>${district.latitude}</td>
                        </tr>
                    </tbody>
                </table>
                <hr>

            </c:forEach>
        </div>
    </body>
</html>
