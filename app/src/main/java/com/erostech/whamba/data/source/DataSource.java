package com.erostech.whamba.data.source;

import java.util.List;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public interface DataSource<T> {
    void getAll(GetAllCallback<T> callback);

    void getById(int id, GetByIdCallback<T> callback);

    void add(T t, InsertionCallback<T> callback);

    interface GetAllCallback<T> {
        void onSuccess(List<T> list);
        void onError(Throwable throwable);
    }

    interface GetByIdCallback<T> {
        void onSuccess(T t);
        void onError(Throwable throwable);
    }

    interface InsertionCallback<T> {
        void onSuccess();
        void onError(Throwable throwable);
    }
}
