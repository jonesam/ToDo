package com.example.sherwin.todo;

/**
 * Created by Sherwin on 26/09/2017.
 */

public class NotificationsClass {
    String Body;
    String Title;
    String Date;

    public NotificationsClass(){}

    public NotificationsClass(String body, String title, String date) {
        this.Body = body;
        this.Title = title;
        this.Date = date;
    }

    public String getmBody() {
        return Body;
    }

    public void setmBody(String body) {
        Body = body;
    }

    public String getmTitle() {
        return Title;
    }

    public void setmTitle(String title) {
        Title = title;
    }

    public String getmDate() {
        return Date;
    }

    public void setmDate(String date) {
        Date = date;
    }
}
