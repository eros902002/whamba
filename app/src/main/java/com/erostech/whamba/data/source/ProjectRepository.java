package com.erostech.whamba.data.source;

import com.erostech.whamba.data.source.local.ProjectLocalDataSource;
import com.erostech.whamba.models.Project;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class ProjectRepository implements DataSource<Project> {
    private ProjectLocalDataSource mLocalDataSource;

    public ProjectRepository() {
        mLocalDataSource = new ProjectLocalDataSource();
    }

    @Override
    public void getAll(GetAllCallback<Project> callback) {
        mLocalDataSource.getAll(callback);
    }

    @Override
    public void getById(int id, GetByIdCallback<Project> callback) {
        mLocalDataSource.getById(id, callback);
    }

    @Override
    public void add(Project project, InsertionCallback<Project> callback) {
        mLocalDataSource.add(project, callback);
    }
}
