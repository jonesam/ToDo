package com.example.sherwin.todo;

/**
 * Created by Sherwin on 18/08/2017.
 */

public class MachineClass {
    String NAME;
    String LAST_USER;
    String STATUS;
    String imageURL;
    String HOURS;

    public MachineClass() {
    }

    public MachineClass(String NAME, String LAST_USER, String STATUS,String imageURL, String HOURS) {
        this.NAME = NAME;
        this.LAST_USER = LAST_USER;
        this.STATUS = STATUS;
        this.imageURL = imageURL;
        this.HOURS = HOURS;

    }

    public String getmNAME() {
        return NAME;
    }

    public void setmNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getmLAST_USER() {
        return LAST_USER;
    }

    public void setmLAST_USER(String LAST_USER) {
        this.LAST_USER = LAST_USER;
    }

    public String getmSTATUS() {return STATUS; }

    public void setmSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getmimageURL() {
        return imageURL;
    }

    public void setmimageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getmHOURS() {
        return HOURS;
    }

    public void setmHOURS(String HOURS) {
        this.HOURS = HOURS;
    }
}
