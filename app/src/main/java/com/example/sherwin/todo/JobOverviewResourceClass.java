package com.example.sherwin.todo;

/**
 * Created by savio on 21/09/2017.
 */

public class JobOverviewResourceClass {
    String ID;
    String Name;
    Integer RESQUANTITY;
    boolean selected = false;

    public JobOverviewResourceClass (){ }
    public JobOverviewResourceClass(String ID, String Name, Integer RESQUANTITY,boolean selected) {
        this.ID = ID;
        this.Name = Name;
        this.RESQUANTITY = RESQUANTITY;
        this.selected = selected;

    }

    public String getmID() {
        return ID;
    }

    public void setmID(String ID) {
        this.ID = ID;
    }

    public String getmName() {
        return Name;
    }

    public void setmName(String name) {
        this.Name = name;
    }

    public Integer getmRESQUANTITY() {
        return RESQUANTITY;
    }

    public void setmRESQUANTITY(Integer RESQUANTITY) {
        this.RESQUANTITY = RESQUANTITY;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
