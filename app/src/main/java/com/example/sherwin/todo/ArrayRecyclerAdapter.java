package com.example.sherwin.todo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Sherwin on 18/08/2017.
 */

public class ArrayRecyclerAdapter extends RecyclerView.Adapter<ArrayRecyclerAdapter.mViewHolder> {

    private ArrayList<MachineClass> machineClassList;
    private Context context;

    public ArrayRecyclerAdapter(Context context,ArrayList<MachineClass> mList) {
        this.machineClassList = mList;
        this.context = context;
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
        mViewHolder.vStatus.setText(ci.getmSTATUS());

        Glide.with(context).load(ci.getmimageURL()).into(mViewHolder.vImage);
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
        protected TextView vStatus;
        protected ImageView vImage;



        public mViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.machine_name);
            vStatus = (TextView)  v.findViewById(R.id.machine_info);
            vImage = (ImageView) v.findViewById(R.id.machine_image);


        }
    }
}