package com.example.login_app;

public interface LoginView {

    void showProgress(boolean showProgress);
    void setUsernameError(int messageResId);
    void setPasswordError(int messageResId);
}
