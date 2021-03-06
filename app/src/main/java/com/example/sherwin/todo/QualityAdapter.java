package com.example.sherwin.todo;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by savio on 21/09/2017.
 */

public class QualityAdapter extends ArrayAdapter<JobOverviewResourceClass> {

    private ArrayList<JobOverviewResourceClass> JobResourcesclass;
    PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, new Intent(getContext(), getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

    public QualityAdapter(Context context, int textViewResourceId, ArrayList<JobOverviewResourceClass> JobResourcesclass) {
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
//Add NFC on click

            //end NFC OnClick
            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    JobOverviewResourceClass resource = (JobOverviewResourceClass) cb.getTag();
                    Toast.makeText(getContext(),
                            "Clicked on Checkbox: " + cb.getText() +
                                    " is " + cb.isChecked(),
                            Toast.LENGTH_LONG).show();

                    resource.setSelected(cb.isChecked());
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
