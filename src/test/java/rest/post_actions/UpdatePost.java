package rest.post_actions;

import io.restassured.http.ContentType;
import org.junit.Test;
import rest.TestConfiguration;
import rest.post_actions.model.Post;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.apache.http.HttpStatus.SC_OK;



public class UpdatePost extends TestConfiguration {



    @Test
    public void shouldUpdateAPost(){
        String response =

                given()     .log().all()
                        .contentType(ContentType.JSON)
                        .body(new Post(1, "szarlotka babci Krysi", "jednak zakalec nie szarlotka", 1))
                .when()
                        .put("/posts/1")
                .then()     .log().all()
                        .statusCode(SC_OK)
                .and()
                        .extract().path("body");

    System.out.println(response);
    assertEquals("jednak zakalec nie szarlotka", response);

    }

}

