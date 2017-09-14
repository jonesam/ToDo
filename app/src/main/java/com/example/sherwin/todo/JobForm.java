package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JobForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_form);

        // Connect to the Firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // Add items via the Button and EditText at the bottom of the window.
        final EditText jobNum = (EditText) findViewById(R.id.job_ID);
        final EditText jobDate = (EditText) findViewById(R.id.date_now);
        final EditText jobPri = (EditText) findViewById(R.id.job_imp);
        final EditText jobDeet = (EditText) findViewById(R.id.job_des);
        final EditText jobMch1 = (EditText) findViewById(R.id.first_machine);
        final EditText jobMch2 = (EditText) findViewById(R.id.second_machine);

        String userPath = ((GlobalData) this.getApplication()).getUserPath() + "JOBS";
        final DatabaseReference job1 = database.getReference(userPath);
        final Button but_sub = (Button) findViewById(R.id.but_sub);
        but_sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // you must creat a job class
                // asumming you did it will have the toString()method in ever parmeteter in the constracter
                JobClass job = new JobClass(jobNum.getText().toString(),jobDate.getText().toString(),jobPri.getText().toString(),jobDeet.getText().toString(),jobMch1.getText().toString(),jobMch2.getText().toString());
                job1.child(jobNum.getText().toString()).setValue(job);
        // Get a reference to the child items it the database

                Toast.makeText(JobForm.this, "JobClass Listed!", Toast.LENGTH_LONG).show();

            }
        });


    }
}
