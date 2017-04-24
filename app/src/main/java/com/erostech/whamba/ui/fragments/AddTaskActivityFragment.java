package com.erostech.whamba.ui.fragments;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.erostech.whamba.R;
import com.erostech.whamba.data.source.DataSource;
import com.erostech.whamba.data.source.ProjectRepository;
import com.erostech.whamba.data.source.TaskRepository;
import com.erostech.whamba.models.Project;
import com.erostech.whamba.models.Task;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddTaskActivityFragment extends Fragment {
    @BindView(R.id.task_title_input)
    EditText mTitle;
    @BindView(R.id.task_description_input)
    EditText mDescription;
    @BindView(R.id.create_task_button)
    Button mButton;

    private Unbinder mUnbinder;

    public AddTaskActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    Task task = new Task(mTitle.getText().toString(), mDescription.getText().toString(), new Date(), false);
                    TaskRepository repository = new TaskRepository();
                    repository.add(task, new DataSource.InsertionCallback<Task>() {
                        @Override
                        public void onSuccess() {
                            getActivity().setResult(Activity.RESULT_OK);
                            getActivity().finish();
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            if (getView() != null) {
                                Snackbar.make(getView(), "There was an error inserting the task. Please try again", Snackbar.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {

                }
            }
        });
    }

    private boolean validateFields() {
        return !mTitle.getText().toString().trim().isEmpty() && !mDescription.getText().toString().trim().isEmpty();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
