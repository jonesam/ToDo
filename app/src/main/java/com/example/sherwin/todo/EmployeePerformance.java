package com.example.sherwin.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeePerformance extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_performance);

        ArrayList<Integer> JobNo = new ArrayList<>();
        ArrayList<Integer> JobTime = new ArrayList<>();
        ArrayList<Integer> JobDate = new ArrayList<>();
        ArrayList<Integer> WorkerTime = new ArrayList<>();
        ArrayList<Integer> JobTimeError = new ArrayList<>();
        ArrayList<Integer> DayTime = new ArrayList<>();
        ArrayList<ArrayList<Integer>> Data = new ArrayList<>();

        ///gets button ids
        final Button next = (Button) findViewById(R.id.nxtBut);
        final Button prev = (Button) findViewById(R.id.prevBut);

        //Extract and store data from json
        try {
            JSONArray jArray = new JSONArray(loadJSONFromAsset());
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                int JobN = json_data.getInt("JobNo");
                int JobT = json_data.getInt("JobTime");
                int JobD = json_data.getInt("JobDate");
                int WorkT = json_data.getInt("WorkerTime");
                int JobTE = json_data.getInt("JobTimeError");
                int DayT = json_data.getInt("DayTime");
                JobNo.add(JobN);
                JobTime.add(JobT);
                JobDate.add(JobD);
                WorkerTime.add(WorkT);
                JobTimeError.add(JobTE);
                DayTime.add(DayT);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //converts date array to attain unique values
        final HashSet<Integer> UnqDate = new HashSet<>(JobDate);
        ((GlobalData)getApplication()).setDayPage(UnqDate.size());
        Data.add(0, JobNo);
        Data.add(1, JobTime);
        Data.add(2, JobDate);
        Data.add(3, WorkerTime);
        Data.add(4, JobTimeError);
        Data.add(5, DayTime);
        final ArrayList<ArrayList<Integer>> Data2 = Data;

        final GraphView graph = (GraphView) findViewById(R.id.graph);

        //find and set spinners
        Spinner selectGraphSpinner = (Spinner) findViewById(R.id.graphSpinner);
        Spinner selectUserSpinner = (Spinner) findViewById(R.id.userSpinner);
        Spinner selectTimeSpinner = (Spinner) findViewById(R.id.timeSpinner);

        //gets user array - can get this info from server if needed
        String[] items = new String[]{"Please Select a User", "04950f4ae53f80", "another user"};

        // Create ArrayAdapters for Spinners
        ArrayAdapter<CharSequence> selectGraphAdapter = ArrayAdapter
                .createFromResource(this, R.array.Graphs,
                        android.R.layout.simple_spinner_item);
        ArrayAdapter<String> userSpinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
        ArrayAdapter<CharSequence> spinTimeAdapter = ArrayAdapter
                .createFromResource(this, R.array.TimeIncrements,
                        android.R.layout.simple_spinner_item);

        // Apply the adapter to the spinner
        selectGraphSpinner.setAdapter(selectGraphAdapter);
        selectUserSpinner.setAdapter(userSpinnerAdapter);
        selectTimeSpinner.setAdapter(spinTimeAdapter);
        //selectGraphSpinner.getSelectedItem().toString()

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(((GlobalData) getApplication()).getDayPage() < UnqDate.size()){
                    ((GlobalData) getApplication()).setDayPage(1);
                }

                if (((GlobalData) getApplication()).shouldPlot()== 1) {
                    graph.removeAllSeries();
                    plot(Data2,graph);

                }else {
                    graph.removeAllSeries();
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(((GlobalData) getApplication()).getDayPage() > 1){
                    ((GlobalData) getApplication()).setDayPage(-1);
                }
                if (((GlobalData) getApplication()).shouldPlot() == 1) {
                    graph.removeAllSeries();
                    plot(Data2, graph);

                } else {
                    graph.removeAllSeries();
                }
            }
        });

        selectUserSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                ((GlobalData) getApplication()).setSpinnerData(parent.getSelectedItem().toString(),0);

                if (((GlobalData) getApplication()).shouldPlot()== 1) {
                    plot(Data2,graph);

                }else {
                    graph.removeAllSeries();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        selectGraphSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                ((GlobalData) getApplication()).setSpinnerData(parent.getItemAtPosition(position).toString(),1);
                if (((GlobalData) getApplication()).shouldPlot()== 1) {
                    plot(Data2,graph);
                }else {
                    graph.removeAllSeries();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        selectTimeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                ((GlobalData) getApplication()).setSpinnerData(parent.getSelectedItem().toString(),2);
                if (((GlobalData) getApplication()).shouldPlot()== 1) {
                    plot(Data2,graph);
                }else {
                    graph.removeAllSeries();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("convertcsv.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    public DataPoint[] getData(ArrayList<ArrayList<Integer>> Data, String Time, Integer Num){
        ArrayList<Integer> JobNo = Data.get(0);
        ArrayList<Integer> JobTimeError = Data.get(4);
        ArrayList<Integer> JobDate = Data.get(2);
        ArrayList<Integer> dayTime = Data.get(5);
        HashSet<Integer> UnqDate = new HashSet<>(JobDate);
        TreeSet<Integer> sortedDate = new TreeSet<>();
        sortedDate.addAll(UnqDate);
        Iterator<Integer> itr = sortedDate.iterator();
        DataPoint[] dataPointArray = new DataPoint[JobNo.size()];
        int dateCounter;

        if (Time.equalsIgnoreCase("Day")) {
            dateCounter =0;
            while (itr.hasNext()) {
                dateCounter++;
                Integer nextItem = itr.next();
                if (dateCounter == Num) {
                    for (int j = 0; j < JobNo.size(); j++) {
                        int dateJ = JobDate.get(j);
                        if (dateJ == nextItem) {
                            double x = 8.0+(dayTime.get(j))/60.0;
                            double y = JobTimeError.get(j);
                            dataPointArray[j] = new DataPoint(x, y);
                        }
                    }
                    ((GlobalData)getApplication()).setChartDate(nextItem);
                }

            }
            return removeNull(dataPointArray);
        }else if(Time.equalsIgnoreCase("Week")){
            return dataPointArray;
        }else {
            return dataPointArray;
        }
    }
    public DataPoint[] removeNull(DataPoint[] a) {
        ArrayList<DataPoint> removedNull = new ArrayList<>();
        for (DataPoint str : a)
            if (str != null)
                removedNull.add(str);
        return removedNull.toArray(new DataPoint[0]);
    }
    public void plot( ArrayList<ArrayList<Integer>> Data, GraphView graph){
        int whichDay = ((GlobalData)getApplication()).getDayPage();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(getData(Data, "Day", whichDay));
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(8);
        graph.getViewport().setMaxX(15);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-6);
        graph.getViewport().setMaxY(6);
        String title  = ((GlobalData)getApplication()).getChartDate();
        graph.setTitle(title);

        graph.addSeries(series);

    }
}
