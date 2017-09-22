package com.example.sherwin.todo;

/**
 * Created by savio on 21/09/2017.
 */

public class JobOverviewResourceClass {
    String ID;
    String Name;
    String QUANTITY;
    boolean selected = false;


    public JobOverviewResourceClass(String ID, String Name, String QUANTITY,boolean selected) {
        this.ID = ID;
        this.Name = Name;
        this.QUANTITY = QUANTITY;
        this.selected = selected;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
