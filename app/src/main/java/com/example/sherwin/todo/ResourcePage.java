package com.example.sherwin.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ResourcePage extends Fragment implements View.OnClickListener {

    public ResourcePage() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        // default method for handling onClick Events..
        switch (v.getId()) {

            case R.id.but_inventory:
                Intent myIntent = new Intent(getContext(),ResourceInventory.class);
                startActivity(myIntent);
                break;

            case R.id.but_work_in_progress:
                Intent wipIntent = new Intent(getContext(),ResourceWorkInProgress.class);
                startActivity(wipIntent);
                break;
            case R.id.but_employees:
                Intent employeeIntent = new Intent(getContext(),EmployeePerformance.class);
                startActivity(employeeIntent);
                break;

            default:
                break;
        }

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
        View resourceView = inflater.inflate(R.layout.fragment_resource_page, container, false);

        Button toInventory = (Button) resourceView.findViewById(R.id.but_inventory);
        toInventory.setOnClickListener(this);

        Button toWorkInProgress = (Button) resourceView.findViewById(R.id.but_work_in_progress);
        toWorkInProgress.setOnClickListener(this);

        // Inflate the layout for this fragment
        return resourceView;
    }

}
