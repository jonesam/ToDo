package com.example.sherwin.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class confirmLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_login);

        Button toMain = (Button) findViewById(R.id.confirm_login);
        toMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(confirmLogin.this,MainActivity.class);
                startActivity(myIntent);
            }

        });
    }
}
