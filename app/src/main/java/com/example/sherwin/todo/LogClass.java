package com.example.sherwin.todo;

/**
 * Created by Sherwin on 27/09/2017.
 */

public class LogClass {
    String DATE;
    String LOGIN;
    String LOGOUT;

    public LogClass(){ }

    public LogClass(String DATE, String LOGIN, String LOGOUT) {
        this.DATE = DATE;
        this.LOGIN = LOGIN;
        this.LOGOUT = LOGOUT;
    }

    public String getmDATE() {
        return DATE;
    }

    public void setmDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getmLOGIN() {
        return LOGIN;
    }

    public void setmLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public String getmLOGOUT() {
        return LOGOUT;
    }

    public void setmLOGOUT(String LOGOUT) {
        this.LOGOUT = LOGOUT;
    }
}
