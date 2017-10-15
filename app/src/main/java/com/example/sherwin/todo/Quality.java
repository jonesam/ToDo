package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Quality extends Fragment {

    public Quality() {
        // Required empty public constructor
    }

    public static Quality newInstance() {
        Quality fragment = new Quality();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_quality, container, false);
        final String jobId = ((GlobalData)getContext().getApplicationContext()).getJobId();
        TextView jobNum = (TextView)rootView.findViewById(R.id.job_qual_title);

        jobNum.setText("Job Number: "+jobId);

        return rootView;
    }

}
