package com.erostech.whamba.data.source.local;

import com.erostech.whamba.data.source.DataSource;
import com.erostech.whamba.models.Comment;

import java.util.List;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class CommentLocalDataSource implements DataSource<Comment> {
    @Override
    public void getAll(GetAllCallback<Comment> callback) {

    }

    @Override
    public void add(Comment comment, InsertionCallback<Comment> callback) {

    }

    @Override
    public void getById(int id, GetByIdCallback<Comment> callback) {

    }
}
