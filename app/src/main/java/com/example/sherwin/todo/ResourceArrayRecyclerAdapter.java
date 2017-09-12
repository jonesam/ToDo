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

public class ResourceArrayRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ResourceInventoryClass> resourceClassList;

    private final int WIP = 0, ISNOTWIP = 1;

    public ResourceArrayRecyclerAdapter(ArrayList<ResourceInventoryClass> rList) {
        this.resourceClassList = rList;
    }


    @Override
    public int getItemCount() {

        if(resourceClassList == null){return 0;}
        return resourceClassList.size();
    }

    @Override
    public int getItemViewType(int position){
        if(resourceClassList.get(position).getmISWIP().equals("YES")){
            return WIP;
        } else if(resourceClassList.get(position).getmISWIP().equals("NO")){
            return ISNOTWIP;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder;

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case WIP:
                View v1 = inflater.inflate(R.layout.wip_card, viewGroup, false);
                viewHolder = new wipViewHolder(v1);
                break;
            case ISNOTWIP:
                View v2 = inflater.inflate(R.layout.resource_card, viewGroup, false);
                viewHolder = new rViewHolder(v2);
                break;
            default:
                View v = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                viewHolder = new RecyclerViewSimpleTextViewHolder(v);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()){
            case WIP:
                wipViewHolder vh1 = (wipViewHolder) viewHolder;
                configurewipViewHolder(vh1, position);
                break;
            case ISNOTWIP:
                rViewHolder vh2 = (rViewHolder) viewHolder;
                configurerViewHolder(vh2, position);
                break;
            default:
                RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) viewHolder;
                configureDefaultViewHolder(vh, position);
                break;
        }
    }

    private void configureDefaultViewHolder(RecyclerViewSimpleTextViewHolder vh, int position) {
        ResourceInventoryClass ci = resourceClassList.get(position);
        if (resourceClassList != null) {
            vh.sName.setText("Name: "+ci.getmNAME());
            vh.sQuantity.setText("Quantity: "+ci.getmQUANTITY());
            vh.sLocation.setText("Location: "+ci.getmLOCATION());
        }
    }

    private void configurewipViewHolder(wipViewHolder vh1, int position) {
        ResourceInventoryClass ci = resourceClassList.get(position);
        if (resourceClassList != null) {
            vh1.wName.setText("Name: "+ci.getmNAME());
            vh1.wQuantity.setText("Quantity: "+ci.getmQUANTITY());
            vh1.wLocation.setText("Location: "+ci.getmLOCATION());
        }
    }

    private void configurerViewHolder(rViewHolder vh2, int position) {
        ResourceInventoryClass ci = resourceClassList.get(position);
        if (resourceClassList != null) {
            vh2.vName.setText("Name: "+ci.getmNAME());
            vh2.vQuantity.setText("Quantity: "+ci.getmQUANTITY());
            vh2.vLocation.setText("Location: "+ci.getmLOCATION());
        }
    }


    public static class RecyclerViewSimpleTextViewHolder extends RecyclerView.ViewHolder {

        protected TextView sName;
        protected TextView sQuantity;
        protected TextView sLocation;


        public RecyclerViewSimpleTextViewHolder(View s) {
            super(s);
            sName =  (TextView) s.findViewById(R.id.resourcewip_name);
            sQuantity = (TextView)  s.findViewById(R.id.resourcewip_quantity);
            sLocation = (TextView)  s.findViewById(R.id.resourcewip_location);
        }
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