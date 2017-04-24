package com.erostech.whamba.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.erostech.whamba.R;
import com.erostech.whamba.models.Comment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by erosgarciaponte on 24/04/2017.
 */

public class CommentViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.comment_author) TextView mAuthor;
    @BindView(R.id.comment_content) TextView mContent;

    public CommentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Comment comment) {
        if (comment != null) {
            if (comment.getAuthor() != null && !comment.getAuthor().isEmpty()) {
                mAuthor.setText(comment.getAuthor());
            } else {
                mAuthor.setText("Anonymous");
            }

            mContent.setText(comment.getContent());
        }
    }
}
