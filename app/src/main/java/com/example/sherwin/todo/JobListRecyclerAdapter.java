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

public class JobListRecyclerAdapter extends RecyclerView.Adapter<JobListRecyclerAdapter.jobViewHolder> {

    private ArrayList<JobClass> jobClassList;

    public JobListRecyclerAdapter(ArrayList<JobClass> rList) {
        this.jobClassList = rList;
    }

    @Override
    public int getItemCount() {
        if(jobClassList == null){return 0;}
        return jobClassList.size();
    }

    @Override
    public jobViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.job_list_card, viewGroup, false);

        return new jobViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(jobViewHolder jobViewHolder, int position) {
        JobClass ci = jobClassList.get(position);
        jobViewHolder.jName.setText("Name: "+ci.getmJobNum());
        jobViewHolder.jDate.setText("Quantity: "+ci.getmJobDate());

    }

    public static class jobViewHolder extends RecyclerView.ViewHolder {

        protected TextView jName;
        protected TextView jDate;


        public jobViewHolder(View j) {
            super(j);
            jName =  (TextView) j.findViewById(R.id.job_name);
            jDate = (TextView)  j.findViewById(R.id.job_due_date);

        }
    }
}