package com.example.demo;

import Client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignupController {


    @FXML
    TextField nameTextField;
    @FXML
    TextField lastNameTextField;
    @FXML
    TextField phoneOrEmail;
    @FXML
    private Parent root;
    private Stage stage;
    private Scene scene;
    private TextField textField;

    public void switchToMainMenu(ActionEvent event) throws IOException { // exit button
        root = FXMLLoader.load(Client.class.getResource("FirstPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        textField.setVisible(true);
    }

//    public void switchToSuccess(ActionEvent event) throws IOException { // exit button
//        Parent root = FXMLLoader.load(Client.class.getResource("signup2.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
    public void signUp(ActionEvent event) throws IOException {

        String firstname = nameTextField.getText();
        String lastname = lastNameTextField.getText();
        String numberOrEmail = phoneOrEmail.getText();

        Parent root = FXMLLoader.load(Client.class.getResource("signup2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        //controller.displayName(firstname);
//        Parent root = FXMLLoader.load(Client.class.getResource("signup2.fxml"));
        System.out.println(firstname + "  " + lastname + "  ");
    }
}
