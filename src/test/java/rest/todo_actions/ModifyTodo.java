package rest.todo_actions;
import io.restassured.http.ContentType;
import org.junit.Test;
import rest.TestConfiguration;
import rest.todo_actions.model.Todo;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ModifyTodo extends TestConfiguration {

    @Test
    public void shouldModifyATodo(){

        String response =
                given()
                        .contentType(ContentType.JSON)
                        .body(new Todo("go to work"))
                .when()
                        .patch("/todos/1")
                .then()
                        .statusCode(SC_OK)
                .and()
                        .extract().path("title");

    assert response.equals("go to work");

    }

}

