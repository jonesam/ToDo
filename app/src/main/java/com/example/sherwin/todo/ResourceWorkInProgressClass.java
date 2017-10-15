package com.example.sherwin.todo;

/**
 * Created by savio on 5/09/2017.
 */

public class ResourceWorkInProgressClass {
    String LOCATION;
    Integer QUANTITY;
    String OWNER;
    String NAME;
    String ISWIP;


    public ResourceWorkInProgressClass() {
    }

    public ResourceWorkInProgressClass(String LOCATION, Integer QUANTITY,String OWNER, String NAME,String ISWIP) {
        this.LOCATION = LOCATION;
        this.QUANTITY = QUANTITY;
        this.OWNER = OWNER;
        this.NAME = NAME;
        this.ISWIP = ISWIP;
    }

    public String getmLOCATION() {return LOCATION;}

    public void setmLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public Integer getmQUANTITY() {
        return QUANTITY;
    }

    public void setmQUANTITY(Integer QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getmOWNER() {
        return OWNER;
    }

    public void setmOWNER(String OWNER) {
        this.OWNER = OWNER;
    }

    public String getmNAME() {
        return NAME;
    }

    public void setmNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getmISWIP() {
        return ISWIP;
    }

    public void setmISWIP(String ISWIP) {
        this.ISWIP = ISWIP;
    }
}
