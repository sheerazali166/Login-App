package com.example.login_app.event;

public class PasswordErrorEvent {

    private int messageResId;

    public PasswordErrorEvent(int messageResId) {

        this.messageResId = messageResId;
    }

    public int getMessageResId() {

        return messageResId;
    }
}
