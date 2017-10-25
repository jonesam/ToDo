package com.example.sherwin.todo;

/**
 * Created by savio on 25/10/2017.
 */

public class JobQualityClass {
    String Info;
    boolean selected = false;

    public JobQualityClass (){ }

    public JobQualityClass(String Info, boolean selected) {
        this.Info = Info;
        this.selected = selected;

    }
}
