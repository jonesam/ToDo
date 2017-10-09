package com.example.sherwin.todo;

import android.app.Application;
import android.nfc.Tag;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;


/**
 * Created by Sherwin on 17/08/2017.
 */

public class GlobalData extends Application {
//saves user ID globally + get user specific path
    private String UserID;
    private Tag UserTag;
    private String UserPath;
    private String JobId;
    private String JobPath;
    private ArrayList<String> JobNums= new ArrayList<>();
    private ArrayList<MachineClass> MachineData;

    //timer stuff
    private Handler customHandler = new Handler();
    private long startTime = 0L;
    private TextView timerValue;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;


    public ArrayList<String> getJobNums()
    {
        return JobNums;
    }//End method

    public void saveJobNum(String num)
    {
        JobNums.add(num);
    }
    public String getUserID() {
        UserID = toHexString(UserTag.getId());
        return UserID;
    }
    public String getUserPath(){
        UserPath = "USERS/" + UserID + "/";
        return UserPath;
    }

    public void setUserTag(Tag tag) {
        this.UserTag = tag;
    }

    public static String toHexString(byte[] bytes) {
        char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v / 16];
            hexChars[j * 2 + 1] = hexArray[v % 16];
        }
        return new String(hexChars);
    }
    //end of save user ID


    public String getJobPath() {
        JobPath = UserPath + "/JOBS" +JobId +"/";
        return JobPath;
    }


    public void setJobId(String jobId) {
        this.JobId = jobId;
    }


    public String getJobId()
    {
        return JobId;
    }



    public ArrayList<MachineClass> getMachineData() {
        if(MachineData == null)
        {return null;
        } else {
        return MachineData;
    }}

    public ArrayList setMachineData(MachineClass machineData) {
        MachineData.add(machineData);
        return MachineData;
    }

    private int dayCounter = 0;
    private int weekCounter = 0;
    private int monthCounter = 0;
    private int dayPage =0;
    private String graphDate;

    private int plotTrigger;
    private List<String> items = new ArrayList<>();

    public Integer shouldPlot(){
        return plotTrigger;
    }

    public void setSpinnerData(String checkedItem, int spinnerNo) {
        //checks if all 3 conditions are met
        plotTrigger = 0;
        items.add(spinnerNo,checkedItem);
        if(items.size() > 3) {
            items.remove((spinnerNo + 1));
        }

        if(items.size() == 3){
            Iterator<String> itemIterator = items.iterator();
            while( itemIterator.hasNext()){
                String str = itemIterator.next();
                if (str.equalsIgnoreCase("04950f4ae53f80")||str.equalsIgnoreCase("Estimated vs Actual Time")){
                    dayCounter++;
                    weekCounter++;
                    monthCounter++;
                }else if (str.equalsIgnoreCase("Day")){
                    dayCounter++;
                }else if(str.equalsIgnoreCase("Month")){
                    monthCounter++;
                }else if (str.equalsIgnoreCase("Week")){
                    weekCounter++;
                }

            }
            if (dayCounter==3){
                plotTrigger = 1;
            }else if (weekCounter == 3){
                plotTrigger = 2;
            }else if (monthCounter == 3) {
                plotTrigger = 3;
            }
            dayCounter = 0;
            weekCounter = 0;
            monthCounter = 0;
        }




    }

    public void setDayPage(int pageLocation) {
        dayPage = dayPage + pageLocation;
    }
    public void setChartDate(int Date){
        String mydate =Integer.toString(Date);
        SimpleDateFormat src = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        SimpleDateFormat dest = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        java.util.Date date = null;
        try {
            date = src.parse(mydate);
        } catch (ParseException e) {
            Log.d("Exception",e.getMessage());
        }
        graphDate = dest.format(date);

    }
    public String getChartDate(){
        return graphDate;
    }

    public int getDayPage(){
        return dayPage;
    }

    public void jobTimer(int function){
        if (function == 1){//start timer
            startTime = SystemClock.uptimeMillis();
            customHandler.postDelayed(updateTimerThread, 0);
        }else if (function ==2){//pause timer
            timeSwapBuff += timeInMilliseconds;
            customHandler.removeCallbacks(updateTimerThread);
        }else if(function ==3){//stop and reset timer
            customHandler.removeCallbacks(updateTimerThread);
            timeSwapBuff = 0L;
        }
    }
    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
        }
    };


}
