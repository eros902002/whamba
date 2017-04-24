package com.erostech.whamba.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erostech.whamba.R;
import com.erostech.whamba.models.Project;
import com.erostech.whamba.ui.viewholders.ProjectViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectViewHolder> {

    private Context mContext;
    private List<Project> mProjects;

    public ProjectsAdapter(Context context) {
        this.mContext = context;
        this.mProjects = new ArrayList<>();
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);
        ProjectViewHolder viewHolder = new ProjectViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        holder.bind(mProjects.get(position));
    }

    @Override
    public int getItemCount() {
        return mProjects == null ? 0 : mProjects.size();
    }
}
