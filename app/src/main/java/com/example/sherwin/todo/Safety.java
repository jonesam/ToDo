package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Safety extends Fragment {

    public Safety() {
        // Required empty public constructor
    }

    public static Safety newInstance() {
        Safety fragment = new Safety();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_safety, container, false);

        final RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.safety_recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);

        // String jobPath = ((GlobalData)getContext()).getJobPath();//gets the job path -to use in final app
        final String jobId = ((GlobalData)getContext().getApplicationContext()).getJobId();
        String jobPath = "USERS/04950F4AE53F80/JOBS/" + jobId + "/";
        final ArrayList<SafetyClass> safety = new ArrayList();

        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(jobPath);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    if (ds.getKey().equalsIgnoreCase("JOBSAFTY")) {
                        for(DataSnapshot ds2:ds.getChildren()) {
                            SafetyClass sc = ds2.getValue(SafetyClass.class);
                            safety.add(sc);
                        }
                    }
                }
                final SafetyAdapter safetyAdapter = new SafetyAdapter(safety);
                recyclerView.setAdapter(safetyAdapter);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


        // Inflate the layout for this fragment
        return rootView;
    }

}
