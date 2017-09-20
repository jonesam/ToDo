package com.example.sherwin.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class JobList extends Fragment implements OnItemClickListener {

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
        View rootView = inflater.inflate(R.layout.fragment_job_list, container, false);
        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.job_list_recycler_view);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        final ArrayList<JobClass> joblistclass = new ArrayList<>();
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


                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String jobno = ds.child("JOBOVERVIEW").child("jobNum").getValue(String.class);
                    JobClass jblst = ds.child("JOBOVERVIEW").getValue(JobClass.class);
                    joblistclass.add(jblst);

                    ((GlobalData) getContext().getApplicationContext()).saveJobNum(jobno);
                }

                final JobListRecyclerAdapter adapterb = new JobListRecyclerAdapter(joblistclass);

                recyclerView.setAdapter(adapterb);
                adapterb.setClickListener(JobList.this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        jobsRef.addListenerForSingleValueEvent(eventListener);

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
        return rootView;
    }


@Override
public void onClick(View view, int position) {
    ArrayList<String> nameArray = ((GlobalData) getActivity().getApplication()).getJobNums();
    String name = nameArray.get(position);
    ((GlobalData) getActivity().getApplication()).setJobId(name);
    Toast.makeText(getContext(), name,
            Toast.LENGTH_LONG).show();
    Intent intent = new Intent(getContext(), Main2Activity.class);
    startActivity(intent);
}
}

