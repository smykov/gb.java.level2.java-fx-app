package ru.gb.smykov.javafxapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatController {
    @FXML
    private TextField userMassage;
    @FXML
    private TextArea chatArea;
    public void clickExit() {
        System.exit(0);
    }

    public void clickSendButton() {
        String message = userMassage.getText();
        userMassage.clear();
        userMassage.requestFocus();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        chatArea.appendText(formatForDateNow.format(dateNow) + ": " + message + "\n");
    }
}