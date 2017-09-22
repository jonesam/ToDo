package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Overview extends Fragment {

    public Overview() {
        // Required empty public constructor
    }


    public static Overview newInstance() {
        Overview fragment = new Overview();

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
        View rootView = inflater.inflate(R.layout.fragment_overview, container, false);
        final ListView listView = (ListView) rootView.findViewById(R.id.job_overview_resource_list_view);

        MyCustomAdapter dataAdapter = null;
        //MAKE CLASS AND PUT HERE
        final ArrayList<JobOverviewResourceClass> JobResourcesclass = new ArrayList<>();
        final String jobId = ((GlobalData)getContext().getApplicationContext()).getJobId();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference jobsRef = rootRef.child("USERS").child("04950F4AE53F80").child("JOBS").child(jobId).child("RESOURCESNEEDED");

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

/*
              listView.setOnItemClickListener(new OnItemClickListener() {
                  public void onItemClick(AdapterView<?> parent, View view,
                                          int position, long id) {
                      // When clicked, show a toast with the TextView text chang this to do integer addition
                      Country country = (Country) parent.getItemAtPosition(position);
                      Toast.makeText(getApplicationContext(),
                              "Clicked on Row: " + country.getName(),
                              Toast.LENGTH_LONG).show();
                  }
              });
              */
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        jobsRef.addListenerForSingleValueEvent(eventListener);


        return rootView;
    }


/*  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
      // Inflate the layout for this fragment

      return inflater.inflate(R.layout.fragment_overview, container, false);
  }
  */

}
