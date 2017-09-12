package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Overview extends Fragment {

    public Overview() {
        // Required empty public constructor
    }


    public static Overview newInstance() {
        Overview fragment = new Overview();

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
        View rootView =  inflater.inflate(R.layout.fragment_overview, container, false);

        // Create a new Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1);

        // Get ListView object from xml
        final ListView listView = (ListView)rootView.findViewById(R.id.listView);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // Connect to the Firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Get a reference to the todoItems child items it the database
        String overPath = ((GlobalData) getActivity().getApplication()).getJobPath()+ "JOBOVERVIEW";
        final DatabaseReference myRef = database.getReference(overPath);


        return rootView;
    }

}
