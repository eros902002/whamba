package com.erostech.whamba.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erostech.whamba.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProjectDetailsActivityFragment extends Fragment {

    public ProjectDetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_project_details, container, false);
    }
}
