package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MessageForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_form);

        // Connect to the Firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // Add items via the Button and EditText at the bottom of the window.
        final EditText date = (EditText) findViewById(R.id.date);
        final EditText recipient = (EditText) findViewById(R.id.recID);
        final EditText sender = (EditText) findViewById(R.id.senderID);
        final EditText msg = (EditText) findViewById(R.id.mess_body);

        final DatabaseReference mess = database.getReference("MESSAGES");
        final Button but_sub = (Button) findViewById(R.id.but_msg_sub);
        but_sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // you must creat a job class
                // asumming you did it will have the toString()method in ever parmeteter in the constracter
                SendMessage mess1 = new SendMessage(date.getText().toString(),sender.getText().toString(),recipient.getText().toString(),msg.getText().toString());
                mess.child(date.getText().toString()).setValue(mess1);
                // Get a reference to the child items it the database



            }
        });


    }
}
