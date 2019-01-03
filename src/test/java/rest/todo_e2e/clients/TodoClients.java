package rest.todo_e2e.clients;
import io.restassured.http.ContentType;
import rest.todo_actions.model.Todo;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.Map;

public class TodoClients {

    private static final int USER_ID = 1;

    public static ArrayList getUserTodos(){
        return
        when()
                .get("/todos?userId=1")
        .then()
                .extract().path("userId");

    }

    public static Map createTodo(String title, boolean completedStatus, int userId){
        return
        given()
                .contentType(ContentType.JSON)
                .body(new Todo(title, completedStatus, userId))
        .when()
                .post("/todos")
        .then()
                .extract().path("");
    }

    public static Map updateTodo(int id, String title, boolean completedStatus, int userId){
        return
        given()
                .contentType(ContentType.JSON)
                .body(new Todo(id, title, completedStatus, userId))
        .when()
                .put("/todos/"+ USER_ID)
        .then()
                .extract().path("");
    }

    public static Map modifyTodo(String title){
        return
        given()
                .contentType(ContentType.JSON)
                .body(new Todo(title))
        .when()
                .patch("/todos/" + USER_ID)
        .then()
                .extract().path("");
    }

    public static Map deleteTodo(){
        return
        when()
                .delete("/todos/" + USER_ID)
        .then()
                .extract().path("");

    }

}

