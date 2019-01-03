package rest.post_actions;
import org.junit.Test;
import rest.TestConfiguration;
import java.util.Map;
import static io.restassured.RestAssured.when;

public class DeletePost extends TestConfiguration {



    @Test
    public void shouldDeleteAPost(){

        Map response =
                when()
                        .delete("/posts/1")
                        .then()
                        .statusCode(200)
                        .extract().path("");

        assert response.isEmpty();

    }

}
