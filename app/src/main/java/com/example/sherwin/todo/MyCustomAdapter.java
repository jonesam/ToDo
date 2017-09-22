package com.example.sherwin.todo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

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
            convertView.setTag(holder);

            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    JobOverviewResourceClass country = (JobOverviewResourceClass) cb.getTag();
                    Toast.makeText(getContext(),
                            "Clicked on Checkbox: " + cb.getText() +
                                    " is " + cb.isChecked(),
                            Toast.LENGTH_LONG).show();
                    country.setSelected(cb.isChecked());
                }
            });
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        JobOverviewResourceClass country = JobResourcesclass.get(position);
        holder.name.setText(country.getName());
        holder.name.setChecked(country.isSelected());
        holder.name.setTag(country);

        return convertView;

    }

}
