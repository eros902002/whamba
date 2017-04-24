package com.erostech.whamba.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erostech.whamba.R;
import com.erostech.whamba.models.Task;
import com.erostech.whamba.ui.viewholders.TaskViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class TasksAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private Context mContext;
    private List<Task> mTasks;

    public TasksAdapter(Context context) {
        this.mContext = context;
        this.mTasks = new ArrayList<>();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        TaskViewHolder viewHolder = new TaskViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.bind(mTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTasks == null ? 0 : mTasks.size();
    }
}
