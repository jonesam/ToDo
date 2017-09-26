package com.example.sherwin.todo;

import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sherwin on 26/09/2017.
 */

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.notificationViewHolder> {
    ArrayList<NotificationsClass> notifications = new ArrayList<>();
    int mExpandedPosition = -1;
    ViewGroup recyclerView;

    public NotificationsAdapter(ArrayList<NotificationsClass> notiArray){
        this.notifications = notiArray;
    }
    @Override
    public int getItemCount() {
        if(notifications == null){return 0;}
        return notifications.size();
    }
    @Override
    public notificationViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        this.recyclerView = viewGroup;
        View j = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.notification_card, viewGroup, false);
        return new notificationViewHolder(j);
    }
    @Override
    public void onBindViewHolder(notificationViewHolder notificationViewHolder, final int position) {
        NotificationsClass ci = notifications.get(position);
        notificationViewHolder.jName.setText(ci.getmTitle());
        notificationViewHolder.jDate.setText(ci.getmDate());
        notificationViewHolder.details.setText(ci.getmBody());
        final boolean isExpanded = position==mExpandedPosition;
        notificationViewHolder.details.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        notificationViewHolder.itemView.setActivated(isExpanded);
        notificationViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                TransitionManager.beginDelayedTransition(recyclerView);
                notifyDataSetChanged();
            }
        });
    }


    public static class notificationViewHolder extends RecyclerView.ViewHolder {

        protected TextView jName;
        protected TextView jDate;
        protected TextView details;

        public notificationViewHolder(View j) {
            super(j);
            details = (TextView) j.findViewById(R.id.notifications_detail);
            jName =  (TextView) j.findViewById(R.id.notification_title);
            jDate = (TextView)  j.findViewById(R.id.notification_date);
        }
    }

}
