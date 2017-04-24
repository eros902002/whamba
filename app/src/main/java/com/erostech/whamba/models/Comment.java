package com.erostech.whamba.models;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class Comment extends RealmObject {
    private int index;
    private String author;
    private String content;
    private Date creationDate;

    public Comment(String author, String content, Date creationDate) {
        this.author = author;
        this.content = content;
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
