package com.example.sherwin.todo;

import android.app.Application;
import android.nfc.Tag;

import java.util.ArrayList;


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
        JobPath = UserPath + "/" +JobId +"/";
        return JobPath;
    }

    public void setJobId(String jobId) {
        this.JobId = jobId;
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
}
