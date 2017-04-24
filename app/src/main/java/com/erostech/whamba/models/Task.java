package com.erostech.whamba.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class Task extends RealmObject {
    private int id;
    private RealmList<Comment> comments;
    private String title;
    private String description;
    private Date creationDate;
    private boolean pendingReview;

    public Task() {}

    public Task(String title, String description, Date creationDate, boolean pendingReview) {
        this.comments = new RealmList<>();
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.pendingReview = pendingReview;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public boolean isPendingReview() {
        return pendingReview;
    }

    public void setComments(RealmList<Comment> comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setPendingReview(boolean pendingReview) {
        this.pendingReview = pendingReview;
    }
}
