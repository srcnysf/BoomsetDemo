package com.example.sercanyusuf.boomsetdemo.ui.base;

public interface BaseView {

    void showWaitingDialog();

    void dismissWaitingDialog();

    void showErrorMessage(int returnCode, String message);

}
