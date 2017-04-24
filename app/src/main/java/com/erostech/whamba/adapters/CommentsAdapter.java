package com.erostech.whamba.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erostech.whamba.R;
import com.erostech.whamba.models.Comment;
import com.erostech.whamba.ui.viewholders.CommentViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentViewHolder> {
    private Context mContext;
    private List<Comment> mComments;

    public CommentsAdapter(Context context) {
        this.mContext = context;
        this.mComments = new ArrayList<>();
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        CommentViewHolder viewHolder = new CommentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.bind(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments == null ? 0 : mComments.size();
    }
}
