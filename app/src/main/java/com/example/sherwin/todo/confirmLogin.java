package com.example.sherwin.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class confirmLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_login);

        // Get a reference to the todoItems child items it the database
        final FirebaseDatabase basicdatabase = FirebaseDatabase.getInstance();
        String userPath = ((GlobalData) this.getApplication()).getUserPath() +"BASIC INFO";
        final DatabaseReference myRef = basicdatabase.getReference(userPath);

        final TextView id = (TextView) findViewById(R.id.id_confirm);
        final TextView name = (TextView) findViewById(R.id.name_confirm);
        final TextView age = (TextView) findViewById(R.id.age_confirm);
        final TextView role = (TextView) findViewById(R.id.role_confirm);


        String idNum =((GlobalData) this.getApplication()).getUserID();
        id.setText(idNum);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                name.setText("Name: "+dataSnapshot.child("NAME").getValue(String.class));
                age.setText("Age: "+dataSnapshot.child("AGE").getValue(String.class));
                role.setText("Role: "+dataSnapshot.child("POSITION").getValue(String.class));
            }
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
