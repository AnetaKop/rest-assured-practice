package rest.todo_e2e.assertions;

import java.util.Map;

import static rest.todo_e2e.clients.TodoClients.*;

public class TodoAssertions {

    public static boolean userTodoExists(String title, boolean completedStatus, int userId) {

        Map<String, Object> response = createTodo(title, completedStatus, userId);

        String responseTodoTile = (String) response.get("title");
        Boolean responseCompletedStatus = (boolean) response.get("completed");
        Integer responseUserId = (int) response.get("userId");


        return responseTodoTile.equals(title) && responseCompletedStatus.equals(completedStatus) &&
                responseUserId.equals(userId);

    }


    public static boolean todoHasBeenUpdated(int id, String title, boolean updatedCompletedStatus, int userId) {

        Map<String, Object> response = updateTodo(id, title, updatedCompletedStatus, userId);

        Boolean responseUpdatedCompletedStatus = (boolean) response.get("completed");

        return responseUpdatedCompletedStatus.equals(updatedCompletedStatus);
    }


    public static boolean todoHasBeenModified(String updatedTitle) {

        Map<String, Object> response = modifyTodo(updatedTitle);

        String responseUpdatedTitle = (String) response.get("title");

        return responseUpdatedTitle.equals(updatedTitle);


    }

    public static boolean todoHasBeenDeleted() {

        Map response = deleteTodo();

        return response.isEmpty();
    }

}