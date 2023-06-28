package com.example.demo;

import Client.ClientManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AddTweetController {

    @FXML
    private TextField tweetTextField;
    @FXML
    private Label error;

//    public void addTweet(ActionEvent event, ObjectInputStream in, ObjectOutputStream out, String author) throws IOException, ClassNotFoundException, InterruptedException {
//        String body = tweetTextField.getText();
//        try {
//            ClientManager.addTweet(out, in, body, author);
//        }
//        catch (IllegalArgumentException e){
//            error.setText(e.getMessage());
//        }
//    }

    public void addTweet(ActionEvent event, ObjectInputStream in, ObjectOutputStream out, String author) {
        String body = tweetTextField.getText();
        try {
            ClientManager.addTweet(out, in, body, author);
        }
        catch (IllegalArgumentException | IOException | ClassNotFoundException | InterruptedException e){
            error.setText(e.getMessage());
        }
    }

//    public void addNewTweet(ActionEvent event) {
//        String body = tweetTextField.getText();
//        try {
//            ClientManager.addTweet(out, in, body, author);
//        }
//        catch (IllegalArgumentException | IOException | ClassNotFoundException | InterruptedException e){
//            error.setText(e.getMessage());
//        }
//    }
}
