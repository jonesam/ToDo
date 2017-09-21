package com.example.sherwin.todo;

/**
 * Created by Sherwin on 21/09/2017.
 */

public class SafetyClass {
    String Name;
    String Method;

    public SafetyClass(){}

    public SafetyClass(String name, String method) {
        this.Name = name;
        this.Method = method;
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
