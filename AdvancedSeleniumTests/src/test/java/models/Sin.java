package models;

public class Sin {
    private String title;
    private String author;
    private String message;

    public Sin(String title, String author, String message) {
        this.title = title;
        this.author = author;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public void setTitle(String newValue) {
        title = newValue;
    }

    public void setAuthor(String newValue) {
        author = newValue;
    }

    public void setMessage(String newValue) {
        message = newValue;
    }
}
