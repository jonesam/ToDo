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

public class Inventory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        final RecyclerView resourcerecyclerView = (RecyclerView)findViewById(R.id.resource_recycler_view);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        resourcerecyclerView.setLayoutManager(llm);
        final ArrayList<ResourceInventoryClass> testr  = new ArrayList<>();

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("RESOURCES/INVENTORY");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data:dataSnapshot.getChildren()
                        ) {

                    ResourceInventoryClass rcs = data.getValue(ResourceInventoryClass.class);
                    if (rcs.ISWIP.equals("NO")){

                        testr.add(0,rcs);
                    }
                    else{
                        testr.add(rcs);
                    }
                }

                final ResourceArrayRecyclerAdapter radapter = new ResourceArrayRecyclerAdapter(testr);
                resourcerecyclerView.setAdapter(radapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Chat", "The read failed: " + databaseError.getDetails());
            }
        });
        }
}
