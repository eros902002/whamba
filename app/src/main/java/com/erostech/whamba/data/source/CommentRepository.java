package com.erostech.whamba.data.source;

import com.erostech.whamba.data.source.local.CommentLocalDataSource;
import com.erostech.whamba.models.Comment;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class CommentRepository implements DataSource<Comment> {
    private CommentLocalDataSource mLocalDataSource;

    public CommentRepository() {
        mLocalDataSource = new CommentLocalDataSource();
    }

    @Override
    public void getAll(GetAllCallback<Comment> callback) {
        mLocalDataSource.getAll(callback);
    }

    @Override
    public void add(Comment comment, InsertionCallback<Comment> callback) {
        mLocalDataSource.add(comment, callback);
    }

    @Override
    public void getById(int id, GetByIdCallback<Comment> callback) {
        mLocalDataSource.getById(id, callback);
    }
}
