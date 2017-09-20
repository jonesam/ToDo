package com.example.sherwin.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class JobList extends Fragment {

    public JobList() {
    }
    public static JobList newInstance() {
        JobList fragment = new JobList();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_job_list, container, false);
        final RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.job_list_recycler_view);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        final ArrayList<JobClass> joblistclass  = new ArrayList<>();
        /*
        // Create a new Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1);
            */

        // Get a reference to the todoItems child items it the database
        //String userPath = ((GlobalData) getActivity().getApplication()).getUserPath() +"JOBS";
        //final DatabaseReference myRef = database.getReference(userPath);
       // final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("USERS/04950F4AE53F80/JOBS");
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference jobsRef = rootRef
                .child("USERS")
                .child("04950F4AE53F80")
                .child("JOBS");
        // Assign a listener to detect changes to the child items
        // of the database reference.
       // myRef.addValueEventListener(new ValueEventListener() {
        ValueEventListener eventListener = new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String jobDate = ds.child("JOBOVERVIEW").child("jobDate").getValue(String.class);
                    JobClass jblst = ds.child("JOBOVERVIEW").getValue(JobClass.class);
                    joblistclass.add(jblst);

                    Log.d("TAG", jobDate);
                }
                final JobListRecyclerAdapter adapterb = new JobListRecyclerAdapter(joblistclass);

                recyclerView.setAdapter(adapterb);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        jobsRef.addListenerForSingleValueEvent(eventListener);


/*
            // This function is called once for each child that exists
            // when the listener is added. Then it is called
            // each time a new child is added.
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

                String value = dataSnapshot.getKey();
                adapter.add(value);
            }

            // This function is called each time a child item is removed.
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getKey();
                adapter.remove(value);
            }
            */


/*
            // The following functions are also required in ChildEventListener implementations.
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
            }
*/
     ///to send to next page
        Button nextPage = (Button) rootView.findViewById(R.id.addNewJob);

        // Capture button clicks
        nextPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(getContext(), JobForm.class);
                startActivity(myIntent);
            }
        });


        // go to job page when clicked
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                String name = (String) listView.getItemAtPosition(position);
                ((GlobalData) getActivity().getApplication()).setJobId(name);
                // use -((GlobalData) getActivity().getApplication()).getJobId() to refer to the job id
                Intent goToJob = new Intent(getContext(), Main2Activity.class);
                startActivity(goToJob);

            }
        });
        */

        return rootView;
    }



}
