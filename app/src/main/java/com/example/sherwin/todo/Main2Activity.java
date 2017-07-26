package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment2 = null;
            switch (item.getItemId()) {
                case R.id.navigation2_home://maybe edit so that it goes back to first activity
                    selectedFragment2 = HomePage.newInstance();
                    break;
                case R.id.navigation_overview:
                    selectedFragment2 = Overview.newInstance();
                    break;
                case R.id.navigation_safety:
                    selectedFragment2 = Safety.newInstance();
                    break;
                case R.id.navigation_quality:
                    selectedFragment2 = Quality.newInstance();
                    break;
                case R.id.navigation_instruction:
                    selectedFragment2 = Instructions.newInstance();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content2, selectedFragment2);
            transaction.commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation2);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
