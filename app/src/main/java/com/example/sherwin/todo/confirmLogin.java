package com.example.sherwin.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class confirmLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_login);

        // Get a reference to the todoItems child items it the database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        String userPath = ((GlobalData) this.getApplication()).getUserPath() +"BASIC INFO";
        final DatabaseReference myRef = database.getReference(userPath);

        final TextView id = (TextView) findViewById(R.id.id_confirm);
        final TextView name = (TextView) findViewById(R.id.name_confirm);
        final TextView age = (TextView) findViewById(R.id.age_confirm);
        final TextView role = (TextView) findViewById(R.id.role_confirm);


        String idNum =((GlobalData) this.getApplication()).getUserID();
        id.setText(idNum);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                name.setText(dataSnapshot.child("NAME").getValue(String.class));
                age.setText(dataSnapshot.child("AGE").getValue(String.class));
                role.setText(dataSnapshot.child("POSITION").getValue(String.class));
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                name.setText(dataSnapshot.child("NAME").getValue(String.class));
                age.setText(dataSnapshot.child("AGE").getValue(String.class));
                role.setText(dataSnapshot.child("POSITION").getValue(String.class));
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });





        Button toMain = (Button) findViewById(R.id.confirm_login);
        toMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(confirmLogin.this,MainActivity.class);
                startActivity(myIntent);
            }

        });
    }
}
