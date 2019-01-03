package rest.todo_actions;

import io.restassured.http.ContentType;
import org.junit.Test;
import rest.TestConfiguration;
import rest.todo_actions.model.Todo;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.junit.Assert.assertFalse;

public class CreateTodo extends TestConfiguration {

    @Test

    public void shouldCreateATodo(){

        Map response =
                given() .log().all()
                        .contentType(ContentType.JSON)
                        .body(new Todo("go on vacation", false, 1))
                .when()
                        .post("/todos")
                .then() .log().all()
                        .statusCode(SC_CREATED)
                .and()
                        .extract().path("");

        assertEquals("go on vacation", response.get("title"));
        assertFalse((Boolean) response.get("completed"));
        assertEquals(1, response.get("userId"));

    }

}

