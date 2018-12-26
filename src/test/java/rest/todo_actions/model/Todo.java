package rest.todo_actions.model;

public class Todo {

    private int id;
    private int userId;
    private boolean completedStatus;
    private String title;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isCompleted() {
        return completedStatus;
    }

    public String getTitle() {
        return title;
    }


    public Todo(String title, boolean completedStatus, int userId) {
        this.title = title;
        this.completedStatus = completedStatus;
        this.userId = userId;
    }

    public Todo(int id, String title, boolean completedStatus, int userId) {
        this.id = id;
        this.title = title;
        this.completedStatus = completedStatus;
        this.userId = userId;
    }

    public Todo(String title) {
        this.title = title;
    }
}

