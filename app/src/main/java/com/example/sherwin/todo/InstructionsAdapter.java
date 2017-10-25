package com.example.sherwin.todo;

import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sherwin on 21/09/2017.
 */

public class InstructionsAdapter extends RecyclerView.Adapter<InstructionsAdapter.mViewHolder> {
    private ArrayList<SafetyClass> instructions;
    int mExpandedPosition = -1;
    ViewGroup recyclerView;

    public InstructionsAdapter(ArrayList<SafetyClass> mList) {
        this.instructions = mList;
    }
    @Override
    public int getItemCount() {
        if(instructions == null){return 0;}
        return instructions.size();
    }
    @Override
    public void onBindViewHolder(InstructionsAdapter.mViewHolder mViewHolder, final int i) {
        SafetyClass ci = instructions.get(i);
        mViewHolder.vName.setText(ci.getSafeName());
        mViewHolder.vDetails.setText(ci.getSafeMethod());
        final boolean isExpanded = i==mExpandedPosition;
        mViewHolder.vDetails.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        mViewHolder.itemView.setActivated(isExpanded);
        mViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:i;
                TransitionManager.beginDelayedTransition(recyclerView);
                notifyDataSetChanged();
            }
        });
    }
    @Override
    public mViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.recyclerView = viewGroup;
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.instructions_card, viewGroup, false);
        return new mViewHolder(itemView);
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vDetails;

        public mViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.instructionsTitle);
            vDetails = (TextView)  v.findViewById(R.id.instructionsInfo);
        }
    }
}

