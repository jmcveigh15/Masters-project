package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import java.util.Date;

// this class works with the Forum Main
// it gets and sets user's names and their messages
public class ChatMessage {
    private String messageText, messageUser, messagePic;

    public ChatMessage(String messageText, String messageUser, String messagePic) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        this.messagePic = messagePic;

    }

    // constructor without args
    public ChatMessage() {

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public String getMessagePic() {
        return messagePic;
    }

    public void setMessagePic(String messagePic) {
        this.messagePic = messagePic;
    }
}
