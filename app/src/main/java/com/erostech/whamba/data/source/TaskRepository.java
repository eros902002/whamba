package com.erostech.whamba.data.source;

import com.erostech.whamba.data.source.local.TaskLocalDataSource;
import com.erostech.whamba.models.Task;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class TaskRepository implements DataSource<Task> {
    private TaskLocalDataSource mLocalDataSource;

    public TaskRepository() {
        mLocalDataSource = new TaskLocalDataSource();
    }

    @Override
    public void getAll(GetAllCallback<Task> callback) {
        mLocalDataSource.getAll(callback);
    }

    @Override
    public void add(Task task, InsertionCallback<Task> callback) {
        mLocalDataSource.add(task, callback);
    }

    @Override
    public void getById(int id, GetByIdCallback<Task> callback) {
        mLocalDataSource.getById(id, callback);
    }
}
