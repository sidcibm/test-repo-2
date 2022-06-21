package model.note;

public class Note {
    // Constants to represent JSP request parameter strings
    public static final String ID = "id", NAME = "name", URL = "url", IMAGE = "image", TEXT = "text";

    private final String id;
    private String name, url, image, text;

    public Note(String id, String name, String url, String image, String text) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.image = image;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
