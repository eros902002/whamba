package com.erostech.whamba.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class Task extends RealmObject {
    private final List<Comment> comments;
    private final String title;
    private final String description;
    private final Date creationDate;
    private final boolean pendingReview;

    public Task(String title, String description, Date creationDate, boolean pendingReview) {
        this.comments = new ArrayList<>();
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
}
