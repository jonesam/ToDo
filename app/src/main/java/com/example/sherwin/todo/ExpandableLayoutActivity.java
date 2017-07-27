/**
 * Created by savio on 27/07/2017.
 */
package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class ExpandableLayoutActivity extends AppCompatActivity{
    private TextView txtContent;
    private Animation animationup;
    private Animation animationdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityexlayout);

        txtContent = (TextView) findViewById(R.id.title_text);
        TextView txtTitle = (TextView) findViewById(R.id.content_text);
        txtContent.setVisibility(View.GONE);


        animationup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideup);
        animationdown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slidedown);

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (txtContent.isShown()) {
                    txtContent.setVisibility(View.GONE);
                    txtContent.startAnimation(animationup);
                } else {
                    txtContent.setVisibility(View.VISIBLE);
                    txtContent.startAnimation(animationdown);
                }


            }


        });
    }
}

