package com.example.sherwin.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JobList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml
        final ListView listView = (ListView) findViewById(R.id.listView);

        // Create a new Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(JobList.this,
                android.R.layout.simple_list_item_1, android.R.id.text1);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // Connect to the Firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Get a reference to the todoItems child items it the database
        final DatabaseReference myRef = database.getReference("JOBS");

        // Assign a listener to detect changes to the child items
        // of the database reference.
        myRef.addChildEventListener(new ChildEventListener() {

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

            // The following functions are also required in ChildEventListener implementations.
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG:", "Failed to read value.", error.toException());
            }
        });

           //to send to next page
        Button nextPage = (Button) findViewById(R.id.addNewJob);

        // Capture button clicks
        nextPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(JobList.this,
                        JobForm.class);
                startActivity(myIntent);
            }
        });
        //add to all new activities DO NOT CHANGE
        ImageButton jobMenuBut = (ImageButton) findViewById(R.id.men_job);
        jobMenuBut.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){

                Intent goToJobList = new Intent (JobList.this,JobList.class);
                startActivity(goToJobList);
            }
        });

        ImageButton mailMenuBut = (ImageButton) findViewById(R.id.men_msg);
        mailMenuBut.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent goToMsgList = new Intent (JobList.this,MessagePage.class);
                startActivity(goToMsgList);
            }
        });

        ImageButton resMenuBut = (ImageButton) findViewById(R.id.men_res);
        resMenuBut.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent goToResList = new Intent (JobList.this,ResourcePage.class);
                startActivity(goToResList);
            }
        });

        final ImageButton mchMenuBut = (ImageButton) findViewById(R.id.men_mch);
        mchMenuBut.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent goToMchList = new Intent (JobList.this,MachinePage.class);
                startActivity(goToMchList);
            }
        });

        ImageButton homeMenuBut = (ImageButton) findViewById(R.id.men_home);
        homeMenuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHome = new Intent (JobList.this, HomePage.class);
                startActivity(goToHome);
            }
        });



    }
}