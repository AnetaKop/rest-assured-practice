package rest.todo_actions;

import io.restassured.http.ContentType;
import org.junit.Test;
import rest.TestConfiguration;
import rest.todo_actions.model.Todo;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertTrue;
import static org.apache.http.HttpStatus.SC_OK;
import java.util.Map;

public class UpdateTodo extends TestConfiguration {

    @Test
    public void shouldUpdateATodo(){

        Map response =
                given() .log().all()
                        .contentType(ContentType.JSON)
                        .body(new Todo(1, "go on vacation", true, 1))
                .when()
                        .put("/todos/1")
                .then()
                        .statusCode(SC_OK)
                .and()
                        .extract().path("");

    assertTrue((Boolean)response.get("completed"));

    }

}

