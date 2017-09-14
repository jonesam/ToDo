package com.example.sherwin.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ResourceWorkInProgress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_in_progress);

        final RecyclerView resourcewiprecyclerView = (RecyclerView)findViewById(R.id.resource_wip_recycler_view);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        resourcewiprecyclerView.setLayoutManager(llm);
        final ArrayList<ResourceWorkInProgressClass> testwip  = new ArrayList<>();

        final DatabaseReference wipref = FirebaseDatabase.getInstance().getReference("RESOURCES/WORKINPRGRESS");
        wipref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data:dataSnapshot.getChildren()
                        ) {

                    ResourceWorkInProgressClass rcs = data.getValue(ResourceWorkInProgressClass.class);

                    testwip.add(rcs);
                }

                final ResourceWorkInProgressArrayRecyclerAdapter radapter = new ResourceWorkInProgressArrayRecyclerAdapter(testwip);
                resourcewiprecyclerView.setAdapter(radapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Chat", "The read failed: " + databaseError.getDetails());
            }
        });
    }
}
