package com.example.demo;

import Client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FirstMenuController {

    @FXML
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void switchToSignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Client.class.getResource("signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}