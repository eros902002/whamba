package com.erostech.whamba.data.source.local;

import com.erostech.whamba.data.source.DataSource;
import com.erostech.whamba.models.Project;
import com.erostech.whamba.models.Task;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class TaskLocalDataSource implements DataSource<Task> {

    private Realm mRealm;

    public TaskLocalDataSource() {
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public void getAll(GetAllCallback<Task> callback) {
        RealmQuery<Task> query = mRealm.where(Task.class);
        RealmResults<Task> tasks = query.findAll();
        if (callback != null) {
            if (!tasks.isEmpty()) {
                callback.onSuccess(tasks);
            } else {
                callback.onError(null);
            }
        }
    }

    @Override
    public void getById(int id, GetByIdCallback<Task> callback) {
        RealmQuery<Task> query = mRealm.where(Task.class).equalTo("id", id);
        RealmResults<Task> tasks = query.findAll();
        if (callback != null) {
            if (!tasks.isEmpty()) {
                callback.onSuccess(tasks.get(0));
            } else {
                callback.onError(null);
            }
        }
    }

    @Override
    public void add(final Task task, final InsertionCallback<Task> callback) {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number num = realm.where(Task.class).max("id");
                task.setId(num.intValue());
                realm.copyToRealm(task);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                if (callback != null) {
                    callback.onSuccess();
                }
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                if (callback != null) {
                    callback.onError(error);
                }
            }
        });
    }
}
