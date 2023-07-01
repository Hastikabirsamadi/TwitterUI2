package com.example.demo;

import Client.Client;
import Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class SearchController {
    @FXML
    private TextField searchChoice;
    @FXML
    private Label error;
    public void search() throws IOException, ClassNotFoundException {
        String word = searchChoice.getText();
        Client.out.writeObject(word);
        ArrayList<User> foundUsers = (ArrayList<User>) Client.in.readObject();
        if (foundUsers.size() == 0){
            error.setText("Not Found!");
        }
    }
}
