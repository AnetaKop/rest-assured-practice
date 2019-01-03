package rest;

import io.restassured.RestAssured;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestConfiguration {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Before
    public void setUp(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
