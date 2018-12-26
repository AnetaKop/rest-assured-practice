package rest.api_methods;



import org.junit.Test;
import rest.TestConfiguration;

import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;

public class ApiMethods extends TestConfiguration {

    @Test
    public void shouldGetAvailableApiMethods(){

        when()
                .options("")
        .then() .log().all()
                .statusCode(SC_NO_CONTENT)
        .and()
                .header("Access-Control-Allow-Methods", "GET,HEAD,PUT,PATCH,POST,DELETE");

    }
}
