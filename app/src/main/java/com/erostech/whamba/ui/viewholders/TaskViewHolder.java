package com.erostech.whamba.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.erostech.whamba.R;
import com.erostech.whamba.models.Task;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.task_title) TextView mTitle;
    @BindView(R.id.review_state) TextView mState;

    private Task mTask;

    public TaskViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Task task) {
        this.mTask = task;
        if (mTask != null) {
            mTitle.setText(mTask.getTitle());
            if (mTask.isPendingReview()) {
                mState.setVisibility(View.VISIBLE);
            } else {
                mState.setVisibility(View.GONE);
            }
            itemView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (mTask != null) {

        }
    }
}
