package com.example.sherwin.todo;

/**
 * Created by Sherwin on 31/07/2017.
 */

public class SendMessage {
    String dateMsg;
    String sender;
    String recipient;
    String msgBody;

    public SendMessage(String dateMsg, String sender, String recipient, String msgBody) {
        this.dateMsg = dateMsg;
        this.sender = sender;
        this.recipient = recipient;
        this.msgBody = msgBody;
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
}
