package rest.todo_actions;

import org.junit.Test;
import rest.TestConfiguration;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.apache.http.HttpStatus.SC_OK;

public class GetUserTodos extends TestConfiguration {

    @Test

    public void shouldGetUserTodos(){

        ArrayList response =
                given() .log().all().

                when()
                        .get("/todos?userId=1")
                .then() .log().all()
                        .statusCode(SC_OK)
                .and()
                        .extract().path("userId");

    System.out.println(response);
    for(int x = 0; x <= response.size(); x++) assertTrue(response.contains(1));

    }
}

