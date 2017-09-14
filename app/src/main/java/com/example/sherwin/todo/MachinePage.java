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


public class MachinePage extends Fragment {

    public MachinePage() {
        // Required empty public constructor
    }


    public static MachinePage newInstance() {
        MachinePage fragment = new MachinePage();

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
        View rootView = inflater.inflate(R.layout.fragment_machine_page, container, false);
        final RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        final ArrayList<MachineClass> test  = new ArrayList<>();

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("RESOURCES/MACHINES");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data:dataSnapshot.getChildren()
                     ) {
                    //String myParentNode = dataSnapshot.getKey();
                   // GlobalData appState = ((GlobalData) getActivity().getApplication());
                    ///appState.setJobIdPath(myParentNode);
                    ///Toast.makeText(getActivity(), myParentNode, Toast.LENGTH_SHORT).show();

                    MachineClass mch = data.getValue(MachineClass.class);
                    test.add(mch);
                }

                final ArrayRecyclerAdapter adaptera = new ArrayRecyclerAdapter(getContext(),test);
                recyclerView.setAdapter(adaptera);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Chat", "The read failed: " + databaseError.getDetails());
            }
        });

        return rootView;
    }

}
