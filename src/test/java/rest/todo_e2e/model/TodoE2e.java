package rest.todo_e2e.model;

public class TodoE2e {
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


    public TodoE2e(String title, boolean completedStatus, int userId) {
        this.title = title;
        this.completedStatus = completedStatus;
        this.userId = userId;
    }

    public TodoE2e(int id, String title, boolean completedStatus, int userId) {
        this.id = id;
        this.title = title;
        this.completedStatus = completedStatus;
        this.userId = userId;
    }

    public TodoE2e(String title) {
        this.title = title;
    }
}
