package ua.pt.hwapitests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class TestAPI {

    @Test
    public void getWeatherForecastTest() {
        String uriBase = "http://localhost:8080/tqs/api/getweather/aveiro";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) // O status http retornado foi 200
                .contentType(ContentType.JSON) // O response foi retornado no formato JSON
                .body("owner", is("IPMA"))
                .body("country", is("PT"))
                .body("globalIdLocal", is(1010500))
                .body("data[0].id", is(0))
                .body("data[0].precipitaProb", isA(String.class))
                .body("data[0].latitude", is("40.6413"))
                .body("data[0].idWeatherType", isA(int.class))
                .body("data[0].predWindDir", isA(String.class))
                .body("data[0].classWindSpeed", isA(int.class))
                .body("data[0].longitude", is("-8.6535"))
                .body("data[0].forecastDate", isA(String.class));

    }

    @Test
    public void getDistrictTest() {
        String uriBase = "http://localhost:8080/tqs/api/districts";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) // O status http retornado foi 200
                .contentType(ContentType.JSON) // O response foi retornado no formato JSON
                .body("owner", is("IPMA"))
                .body("country", is("PT"))
                .body("data[0].globalIdLocal", is(1010500))
                .body("data[0].id", is(0))
                .body("data[0].idAreaAviso", is("AVR"))
                .body("data[0].latitude", is("40.6413"))
                .body("data[0].idRegiao", is(1))
                .body("data[0].idDistrito", is(1))
                .body("data[0].idConcelho", is(5))
                .body("data[0].longitude", is("-8.6535"))
                .body("data[0].local", is("Aveiro"));

    }

    @Test
    public void getWeatherTest() {
        String uriBase = "http://localhost:8080/tqs/api/allweather";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("owner", is("IPMA"))
                .body("country", is("PT"))
                .body("data[0].descIdWeatherTypePT", is("---"))
                .body("data[0].descIdWeatherTypeEN", is("--"))
                .body("data[0].idWeatherType", is(-99))
                .body("data[0].id", is(0));

    }

    @Test
    public void getCacheStatsTest() {
        String uriBase = "http://localhost:8080/tqs/api/cachestats";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) // O status http retornado foi 200
                .contentType(ContentType.JSON) // O response foi retornado no formato JSON
                .body("numberOfRequests", isA(int.class))
                .body("numberOfMisses", isA(int.class))
                .body("id", isA(int.class))
                .body("numberOfHits", isA(int.class));

    }

    @Test
    public void getWindSpeedTest() {
        String uriBase = "http://localhost:8080/tqs/api/windspeeds";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) // O status http retornado foi 200
                .contentType(ContentType.JSON) // O response foi retornado no formato JSON
                .body("owner", is("IPMA"))
                .body("country", is("PT"))
                .body("data[0].descClassWindSpeedDailyPT", is("---"))
                .body("data[0].descClassWindSpeedDailyEN", is("--"))
                .body("data[0].classWindSpeed", is("-99"))
                .body("data[0].id", is(0));

    }

}
