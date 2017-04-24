package com.erostech.whamba.data.source.local;

import com.erostech.whamba.data.source.DataSource;
import com.erostech.whamba.models.Project;

import java.util.List;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class ProjectLocalDataSource implements DataSource<Project> {
    private Realm mRealm;

    public ProjectLocalDataSource() {
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public void getAll(GetAllCallback<Project> callback) {
        RealmQuery<Project> query = mRealm.where(Project.class);
        RealmResults<Project> projects = query.findAll();
        if (callback != null) {
            if (!projects.isEmpty()) {
                callback.onSuccess(projects);
            } else {
                callback.onError(null);
            }
        }
     }

    @Override
    public void getById(int id, GetByIdCallback<Project> callback) {
        RealmQuery<Project> query = mRealm.where(Project.class).equalTo("id", id);
        RealmResults<Project> projects = query.findAll();
        if (callback != null) {
            if (!projects.isEmpty()) {
                callback.onSuccess(projects.get(0));
            } else {
                callback.onError(null);
            }
        }
    }

    @Override
    public void add(final Project project, final InsertionCallback<Project> callback) {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number num = realm.where(Project.class).max("id");
                project.setId(num.intValue());
                realm.copyToRealm(project);
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
