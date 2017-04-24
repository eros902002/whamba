package com.erostech.whamba.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class Project extends RealmObject {
    private final String title;
    private final Date creationDate;
    private final List<Task> tasks;

    public Project(String title, Date creationDate) {
        this.title = title;
        this.creationDate = creationDate;
        this.tasks = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
