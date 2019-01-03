package rest.todo_actions;
import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_OK;
import org.junit.Test;
import rest.TestConfiguration;
import java.util.Map;

public class DeleteTodo extends TestConfiguration {


    @Test
    public void shouldDeleteATodo(){

        Map response =
                when()
                        .delete("/todos/1")
                .then().log().all()
                        .statusCode(SC_OK)
                .and()
                        .extract().path("");

        assert response.isEmpty();


    }

}

