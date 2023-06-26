package com.example.demo;

import Client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;

public class SignInController {

    @FXML
    private Parent root;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label error;
    private Stage stage;
    private Scene scene;
    private boolean hasError = false;

    public void switchToMainMenu(ActionEvent event) throws IOException { // exit button
        root = FXMLLoader.load(Objects.requireNonNull(Client.class.getResource("FirstPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(true);
        stage.show();
    }

    public void signIn(ActionEvent event) throws IOException {
        String user, pass, feedback = " ";
        user = username.getText();
        pass = password.getText();
        try {
            feedback = Client.signIn(user,pass);
        }
        catch (IllegalArgumentException e){
            hasError = true;
            error.setText(e.getMessage());
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if (!hasError){
            if (!feedback.equals("signed in successfully!")){
                error.setText(feedback);
            }
            Parent root = FXMLLoader.load(Objects.requireNonNull(Client.class.getResource("?")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println(user + "  " + pass + "  ");
        }
    }
}
