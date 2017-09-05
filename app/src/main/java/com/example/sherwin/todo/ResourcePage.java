package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ResourcePage extends Fragment {


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
        final RecyclerView resourcerecyclerView = (RecyclerView)resourceView.findViewById(R.id.resource_recycler_view);


        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        resourcerecyclerView.setLayoutManager(llm);
        final ArrayList<ResourceInventoryClass> testr  = new ArrayList<>();

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("RESOURCES/INVENTORY");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data:dataSnapshot.getChildren()
                        ) {

                    ResourceInventoryClass rcs = data.getValue(ResourceInventoryClass.class);
                    testr.add(rcs);
                }

                final ResourceArrayRecyclerAdapter radapter = new ResourceArrayRecyclerAdapter(testr);
                resourcerecyclerView.setAdapter(radapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Chat", "The read failed: " + databaseError.getDetails());
            }
        });

        // Inflate the layout for this fragment
        return resourceView;
    }

}
