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
    private static OnItemClickListener clickListener;


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
        View j = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.job_list_card, viewGroup, false);
        return new jobViewHolder(j);
    }

    @Override
    public void onBindViewHolder(jobViewHolder jobViewHolder, int position) {
        JobClass ci = jobClassList.get(position);
        jobViewHolder.jName.setText("Job Name: "+ci.getmJobDeet());
        jobViewHolder.jDate.setText("Due Date: "+ci.getmJobDate());
        jobViewHolder.jNumb.setText("Job #: "+ci.getmJobNum());
        jobViewHolder.jTime.setText("Estamated Job Time: "+ci.getmJobMch2()+" minutes");
    }

    public void setClickListener(OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public static class jobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView jName;
        protected TextView jDate;
        protected TextView jNumb;
        protected TextView jTime;


        public jobViewHolder(View j) {
            super(j);


            jName =  (TextView) j.findViewById(R.id.job_name);
            jDate = (TextView)  j.findViewById(R.id.job_due_date);
            jNumb = (TextView)  j.findViewById(R.id.job_Num);
            jTime = (TextView)  j.findViewById(R.id.job_time);
            j.setOnClickListener(this);  // bind the listener

        }


        @Override
        public void onClick(View view) {
            if (clickListener != null) {clickListener.onClick(view, getLayoutPosition());}

        }
    }

    }
