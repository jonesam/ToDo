package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


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
        final ListView listView = (ListView) rootView.findViewById(R.id.job_quality_list_view);

        MyCustomAdapter dataAdapter = null;
        //MAKE CLASS AND PUT HERE
        final ArrayList<JobOverviewResourceClass> JobResourcesclass = new ArrayList<>();
        final String jobId = ((GlobalData)getContext().getApplicationContext()).getJobId();

        TextView jobNum = (TextView)rootView.findViewById(R.id.job_overview_title);
        jobNum.setText("Job Number: "+jobId);

        ValueEventListener eventListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    //add new resource class and put here
                    JobOverviewResourceClass rclst = ds.getValue(JobOverviewResourceClass.class);
                    JobResourcesclass.add(rclst);
                }

                //create an ArrayAdaptar from the String Array
                final MyCustomAdapter dataAdapter = new MyCustomAdapter(getContext(),R.layout.job_overview_resource_checks, JobResourcesclass);
                // Assign adapter to ListView
                listView.setAdapter(dataAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        return rootView;
    }

}
