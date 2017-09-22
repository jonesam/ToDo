package com.example.sherwin.todo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by savio on 21/09/2017.
 */

public class MyCustomAdapter extends ArrayAdapter<JobOverviewResourceClass> {

    private ArrayList<JobOverviewResourceClass> JobResourcesclass;

    public MyCustomAdapter(Context context, int textViewResourceId, ArrayList<JobOverviewResourceClass> JobResourcesclass) {
        super(context, textViewResourceId, JobResourcesclass);
        this.JobResourcesclass = new ArrayList<>();
        this.JobResourcesclass.addAll(JobResourcesclass);
    }

    private class ViewHolder {
        TextView code;
        TextView amnt;
        CheckBox name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.job_overview_resource_checks, null);

            holder = new ViewHolder();
            holder.name = (CheckBox) convertView.findViewById(R.id.Resource_checkBox);
            holder.code = (TextView) convertView.findViewById(R.id.Resource_checkBox_Text);
            holder.amnt = (TextView) convertView.findViewById(R.id.Resource_checkBox_amount_Text);
            convertView.setTag(holder);

            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    JobOverviewResourceClass resource = (JobOverviewResourceClass) cb.getTag();
                    Toast.makeText(getContext(),
                            "Clicked on Checkbox: " + cb.getText() +
                                    " is " + cb.isChecked(),
                            Toast.LENGTH_LONG).show();


                    final Integer neededquant = resource.getmRESQUANTITY();
                    final String shelfresname = resource.getShelfresneeded();
                    //final Integer shelfquant =;
                    final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("RESOURCES/INVENTORY");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot data:dataSnapshot.getChildren()
                                    ) {

                                ResourceInventoryClass rcs = data.getValue(ResourceInventoryClass.class);
                                String key = data.getKey();
                                if (rcs.NAME.equals(shelfresname)){
                                    final Integer shelfquant = rcs.getmQUANTITY();

                                    final Integer NewShelfQuantity =  shelfquant - neededquant;
                                    ref.child(key).child("QUANTITY").setValue(NewShelfQuantity);
                                    break;
                                }

                            }

                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Chat", "The read failed: " + databaseError.getDetails());
                        }
                    });



                    resource.setSelected(cb.isChecked());
                    holder.name.setOnClickListener(null);


                   //END OF ONCLICK ACTIVITY
                }
            });
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        JobOverviewResourceClass resource = JobResourcesclass.get(position);
        holder.code.setText(resource.getmName());
        String xx = Integer.toString(resource.getmRESQUANTITY());
        holder.amnt.setText("     x "+ xx);
        holder.name.setChecked(resource.isSelected());
        holder.name.setTag(resource);

        return convertView;

    }

}
