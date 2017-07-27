package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class ResourcePage extends Fragment {
    private TextView txtContent;
    private Animation animationup;
    private Animation animationdown;

    public ResourcePage() {
        // Required empty public constructor
    }


    public static ResourcePage newInstance() {
        ResourcePage fragment = new ResourcePage();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View resourceView =  inflater.inflate(R.layout.fragment_resource_page, container, false);


        txtContent = (TextView) resourceView.findViewById(R.id.title_text);
        TextView txtTitle = (TextView) resourceView.findViewById(R.id.content_text);
        txtContent.setVisibility(View.GONE);


        animationup = AnimationUtils.loadAnimation(getActivity(), R.anim.slideup);
        animationdown = AnimationUtils.loadAnimation(getActivity(), R.anim.slidedown);

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


        // Inflate the layout for this fragment
        return resourceView;
    }

}
