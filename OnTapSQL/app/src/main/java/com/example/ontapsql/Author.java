package com.example.ontapsql;

public class Author {
    private int authorId;
    private String authorName;
    private String authorAddress;
    private String authorEmail;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Author(int authorId, String authorName, String authorAddress, String authorEmail) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorAddress = authorAddress;
        this.authorEmail = authorEmail;
    }

    public Author() {
        this.authorId = 0;
        this.authorName = null;
        this.authorAddress = null;
        this.authorEmail = null;
    }
}
