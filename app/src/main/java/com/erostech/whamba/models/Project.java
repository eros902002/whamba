package com.erostech.whamba.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class Project extends RealmObject {
    private int id;
    private String title;
    private Date creationDate;
    private RealmList<Task> tasks;

    public Project() {}

    public Project(String title, Date creationDate) {
        this.title = title;
        this.creationDate = creationDate;
        this.tasks = new RealmList<>();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setTasks(RealmList<Task> tasks) {
        this.tasks = tasks;
    }
}
