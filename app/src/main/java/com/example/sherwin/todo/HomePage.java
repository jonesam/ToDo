package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class HomePage extends Fragment {

    public HomePage() {
        // Required empty public constructor
    }


    public static HomePage newInstance() {
        HomePage fragment = new HomePage();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_home_page, container, false);
        String notiPath = "USERS/04950F4AE53F80/NOTIFICATIONS/";
        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(notiPath);
        final ArrayList<NotificationsClass> notifications = new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.notification_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    NotificationsClass sc = ds.getValue(NotificationsClass.class);
                    notifications.add(sc);
                }
                final NotificationsAdapter notificationsAdapter = new NotificationsAdapter(notifications);
                recyclerView.setAdapter(notificationsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        return rootView;
    }

}

