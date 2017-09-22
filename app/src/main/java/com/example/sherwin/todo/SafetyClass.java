package com.example.sherwin.todo;

/**
 * Created by Sherwin on 21/09/2017.
 */

public class SafetyClass {
    String Method;
    String Name;

    public SafetyClass(){}

    public SafetyClass(String method, String name) {
        this.Method = method;
        this.Name = name;
    }

    public String getSafeName() {
        return Name;
    }

    public void setSafeName(String name) {
        Name = name;
    }

    public String getSafeMethod() {
        return Method;
    }

    public void setSafeMethod(String method) {
        Method = method;
    }
}
