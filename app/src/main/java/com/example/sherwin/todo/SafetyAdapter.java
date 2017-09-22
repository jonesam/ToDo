package com.example.sherwin.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sherwin on 21/09/2017.
 */

public class SafetyAdapter extends RecyclerView.Adapter<SafetyAdapter.mViewHolder> {
    private ArrayList<SafetyClass> safety;

    public SafetyAdapter(ArrayList<SafetyClass> mList) {
        this.safety = mList;
    }
    @Override
    public int getItemCount() {
        if(safety == null){return 0;}
        return safety.size();
    }
    @Override
    public void onBindViewHolder(SafetyAdapter.mViewHolder mViewHolder, int i) {
        SafetyClass ci = safety.get(i);

        mViewHolder.vName.setText(ci.getSafeName());
        mViewHolder.vStatus.setText(ci.getSafeMethod());
    }
    @Override
    public mViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.safety_card, viewGroup, false);
        return new mViewHolder(itemView);
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vStatus;

        public mViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.safetyTitle);
            vStatus = (TextView)  v.findViewById(R.id.safetyInfo);
        }
    }
}
