package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Instructions extends Fragment {

    public Instructions() {
        // Required empty public constructor
    }

    public static Instructions newInstance() {
        Instructions fragment = new Instructions();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_instructions, container, false);
        final String jobId = ((GlobalData)getContext().getApplicationContext()).getJobId();

        TextView jobNum = (TextView)rootView.findViewById(R.id.job_instruct_title);
        jobNum.setText("Job Number: "+jobId);
        // Inflate the layout for this fragment
        return rootView;
    }

}
