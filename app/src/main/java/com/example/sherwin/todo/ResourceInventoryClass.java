package com.example.sherwin.todo;

/**
 * Created by savio on 5/09/2017.
 */

public class ResourceInventoryClass {
    String LOCATION;
    Integer QUANTITY;
    String NAME;
    String ISWIP;


    public ResourceInventoryClass() {
    }

    public ResourceInventoryClass(String LOCATION, Integer QUANTITY, String NAME,String ISWIP) {
        this.LOCATION = LOCATION;
        this.QUANTITY = QUANTITY;
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
