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

public class ResourceWorkInProgressArrayRecyclerAdapter extends RecyclerView.Adapter<ResourceWorkInProgressArrayRecyclerAdapter.wipViewHolder> {

    private ArrayList<ResourceWorkInProgressClass> resourcewipClassList;

    public ResourceWorkInProgressArrayRecyclerAdapter(ArrayList<ResourceWorkInProgressClass> rList) {
        this.resourcewipClassList = rList;
    }

    @Override
    public int getItemCount() {
        if(resourcewipClassList == null){return 0;}
        return resourcewipClassList.size();
    }

    @Override
    public wipViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.wip_card, viewGroup, false);

        return new wipViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(wipViewHolder wipViewHolder, int position) {
        ResourceWorkInProgressClass ci = resourcewipClassList.get(position);
        wipViewHolder.wName.setText("Name: "+ci.getmNAME());
        wipViewHolder.wQuantity.setText("Quantity: "+Integer.toString(ci.getmQUANTITY()));
        wipViewHolder.wLocation.setText("Location: "+ci.getmLOCATION());
        }

    public static class wipViewHolder extends RecyclerView.ViewHolder {

        protected TextView wName;
        protected TextView wQuantity;
        protected TextView wLocation;


        public wipViewHolder(View w) {
            super(w);
            wName =  (TextView) w.findViewById(R.id.resourcewip_name);
            wQuantity = (TextView)  w.findViewById(R.id.resourcewip_quantity);
            wLocation = (TextView)  w.findViewById(R.id.resourcewip_location);
        }
    }
}