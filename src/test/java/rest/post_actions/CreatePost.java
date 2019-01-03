package rest.post_actions;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.TestConfiguration;
import rest.post_actions.model.Post;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.apache.http.HttpStatus.SC_CREATED;

public class CreatePost extends TestConfiguration {

    private final Logger log = LoggerFactory.getLogger(getClass());


    @Test

    public void shouldCreateAPost() {

        Map response =
                given() .log().all()
                        .contentType(ContentType.JSON)
                        .body(new Post("szarlotka babci Krysi", "the best szarlotka na świecie", 1))
                .when()
                        .post("/posts")
                .then() .log().all()
                        .statusCode(SC_CREATED)
                .and()
                        .statusCode(201)
                .and()
                        .extract().path("");


        log.info("response body is: {}", response);
        assert response.get("title").equals("szarlotka babci Krysi");
        assert response.get("body").equals("the best szarlotka na świecie");
        assertEquals(1, response.get("userId"));


    }


}
