package com.example.sherwin.todo;

/**
 * Created by Sherwin on 31/07/2017.
 */

public class SendMessage {
    String dateMsg;
    String sender;
    String recipient;
    String msgBody;
    String msgTitle;

    public SendMessage(String dateMsg, String sender, String recipient, String msgBody, String msgTitle) {
        this.dateMsg = dateMsg;
        this.sender = sender;
        this.recipient = recipient;
        this.msgBody = msgBody;
        this.msgTitle = msgTitle;
    }

    public String getDateMsg() {
        return dateMsg;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMsgBody() {
        return msgBody;
    }
    public String getMsgTitle(){
        return  msgTitle;
    }
}
