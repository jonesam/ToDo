package com.example.sherwin.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MachinePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_page);

        //add to all new activities DO NOT CHANGE
        final ImageButton jobMenuBut = (ImageButton) findViewById(R.id.men_job);
        jobMenuBut.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent goToJobList = new Intent (MachinePage.this,JobList.class);
                startActivity(goToJobList);
            }
        });

        final ImageButton mailMenuBut = (ImageButton) findViewById(R.id.men_msg);
        mailMenuBut.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent goToMsgList = new Intent (MachinePage.this,MessagePage.class);
                startActivity(goToMsgList);
            }
        });

        final ImageButton resMenuBut = (ImageButton) findViewById(R.id.men_res);
        resMenuBut.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent goToResList = new Intent (MachinePage.this,ResourcePage.class);
                startActivity(goToResList);
            }
        });

        final ImageButton mchMenuBut = (ImageButton) findViewById(R.id.men_mch);
        mchMenuBut.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent goToMchList = new Intent (MachinePage.this,MachinePage.class);
                startActivity(goToMchList);
            }
        });

        final ImageButton homeMenuBut = (ImageButton) findViewById(R.id.men_home);
        homeMenuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHome = new Intent (MachinePage.this, HomePage.class);
                startActivity(goToHome);
            }
        });

    }

}
