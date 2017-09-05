package com.example.sherwin.todo;

/**
 * Created by savio on 5/09/2017.
 */

public class ResourceInventoryClass {
    String LOCATION;
    String QUANTITY;
    String NAME;

    public ResourceInventoryClass() {
    }

    public ResourceInventoryClass(String LOCATION, String QUANTITY, String NAME) {
        this.LOCATION = LOCATION;
        this.QUANTITY = QUANTITY;
        this.NAME = NAME;

    }

    public String getmLOCATION() {
        return LOCATION;
    }

    public void setmLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getmQUANTITY() {
        return QUANTITY;
    }

    public void setmQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getmNAME() {
        return NAME;
    }

    public void setmNAME(String NAME) {
        this.NAME = NAME;
    }

}
