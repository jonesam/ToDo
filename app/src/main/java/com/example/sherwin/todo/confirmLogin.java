package com.example.sherwin.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_login);

        TextView id = (TextView) findViewById(R.id.id_confirm);
        String idNum =((GlobalData) this.getApplication()).getUserID();
        id.setText(idNum);

        Button toMain = (Button) findViewById(R.id.confirm_login);
        toMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(confirmLogin.this,MainActivity.class);
                startActivity(myIntent);
            }

        });
    }
}
