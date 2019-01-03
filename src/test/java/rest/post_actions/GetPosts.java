package rest.post_actions;

import org.junit.Test;
import rest.TestConfiguration;

import static io.restassured.RestAssured.when;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.lessThan;



public class GetPosts extends TestConfiguration {

    @Test
    public void shouldGetPosts(){
            when()
                    .get("")
            .then()
                    .statusCode(SC_OK)
            .and()
                    .time(lessThan(2000L));


    }
}


