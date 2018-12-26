package rest.post_actions.model;


public class Post {

    private int id;
    private String title;
    private String body;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Post(String postTitle, String postContent, int userId) {
        this.title = postTitle;
        this.body = postContent;
        this.userId = userId;
    }

    public Post(int id, String postTitle, String updatedContent, int userId) {
        this.title = postTitle;
        this.body = updatedContent;
        this.userId = userId;
        this.id = id;
    }

    public Post(String updatedTitle) {
        this.title = updatedTitle;
    }

}
