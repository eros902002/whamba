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
import com.erostech.whamba.models.Project;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddProjectActivityFragment extends Fragment {
    @BindView(R.id.project_name_input)
    EditText mName;
    @BindView(R.id.create_project_button)
    Button mButton;

    private Unbinder mUnbinder;

    public AddProjectActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_project, container, false);
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
                    Project project = new Project(mName.getText().toString(), new Date());
                    ProjectRepository repository = new ProjectRepository();
                    repository.add(project, new DataSource.InsertionCallback<Project>() {
                        @Override
                        public void onSuccess() {
                            getActivity().setResult(Activity.RESULT_OK);
                            getActivity().finish();
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            if (getView() != null) {
                                Snackbar.make(getView(), "There was an error inserting the project. Please try again", Snackbar.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {

                }
            }
        });
    }

    private boolean validateFields() {
        return !mName.getText().toString().trim().isEmpty();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
