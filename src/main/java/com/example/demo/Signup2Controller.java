package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Signup2Controller {
    @FXML
    Label nameLabel;

    public void displayName(String name){
        nameLabel.setText("Hello: " + name);
    }
}
