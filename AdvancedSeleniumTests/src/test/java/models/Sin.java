package models;

import java.util.*;
import enumerators.*;

public class Sin {
    private String title;
    private String author;
    private String message;
    private List<SinTag> tags;

    public Sin(String title, String author, String message) {
        this.title = title;
        this.author = author;
        this.message = message;
    }

    public List<SinTag> getTags() {
        return tags;
    }

    public void setTags(List<SinTag> newValue) {
        tags = newValue;
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
