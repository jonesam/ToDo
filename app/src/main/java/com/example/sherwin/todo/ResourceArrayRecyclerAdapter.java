package com.example.sherwin.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by savio on 5/09/2017.
 */

public class ResourceArrayRecyclerAdapter extends RecyclerView.Adapter<ResourceArrayRecyclerAdapter.rViewHolder> {

    private ArrayList<ResourceInventoryClass> resourceClassList;

    public ResourceArrayRecyclerAdapter(ArrayList<ResourceInventoryClass> rList) {
        this.resourceClassList = rList;
    }


    @Override
    public int getItemCount() {

        if(resourceClassList == null){return 0;}
        return resourceClassList.size();
    }

    @Override
    public void onBindViewHolder(rViewHolder rViewHolder, int i) {
        ResourceInventoryClass ci = resourceClassList.get(i);
        rViewHolder.vName.setText("Name: "+ci.getmNAME());
        rViewHolder.vQuantity.setText("Quantity: "+ci.getmQUANTITY());
        rViewHolder.vLocation.setText("Location: "+ci.getmLOCATION());

    }

    @Override
    public rViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.resource_card, viewGroup, false);

        return new rViewHolder(itemView);
    }

    public static class rViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vQuantity;
        protected TextView vLocation;


        public rViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.resource_name);
            vQuantity = (TextView)  v.findViewById(R.id.resource_quantity);
            vLocation = (TextView)  v.findViewById(R.id.resource_location);

        }
    }
}