package com.erostech.whamba.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.erostech.whamba.R;
import com.erostech.whamba.models.Project;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.project_name) TextView mTitle;
    @BindView(R.id.task_count) TextView mTaskCount;

    private Project mProject;

    public ProjectViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Project project) {
        this.mProject = project;
        if (mProject != null) {
            mTitle.setText(mProject.getTitle());

            if (mProject.getTasks() != null && !mProject.getTasks().isEmpty()) {
                mTaskCount.setVisibility(View.VISIBLE);
                mTaskCount.setText(String.valueOf(mProject.getTasks().size()));
            } else {
                mTaskCount.setVisibility(View.GONE);
            }

            itemView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (mProject != null) {

        }
    }
}
