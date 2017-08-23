package com.example.sherwin.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sherwin on 18/08/2017.
 */

public class ArrayRecyclerAdapter extends RecyclerView.Adapter<ArrayRecyclerAdapter.mViewHolder> {

    private ArrayList<MachineClass> machineClassList;

    public ArrayRecyclerAdapter(ArrayList<MachineClass> mList) {
        this.machineClassList = mList;
    }


    @Override
    public int getItemCount() {
        if(machineClassList == null){return 0;}
        return machineClassList.size();
    }

    @Override
    public void onBindViewHolder(mViewHolder mViewHolder, int i) {
        MachineClass ci = machineClassList.get(i);
        mViewHolder.vName.setText(ci.getmNAME());
        mViewHolder.vSurname.setText(ci.getmSTATUS());

    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.machine_card, viewGroup, false);

        return new mViewHolder(itemView);
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vSurname;


        public mViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.machine_name);
            vSurname = (TextView)  v.findViewById(R.id.machine_info);

        }
    }
}