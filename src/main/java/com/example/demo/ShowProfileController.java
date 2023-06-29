package com.example.demo;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowProfileController implements Initializable {
    public AnchorPane parent;
    @FXML
    private Circle avatar;
    @FXML
    private ImageView header;
    @FXML
    private Label name;
    @FXML
    private Label username;
    @FXML
    private Label bio;
    @FXML
    private Label location;
    @FXML
    private Label website;
    @FXML
    private Label joinedDate;
    @FXML
    private Label followingNum;
    @FXML
    private Label followerNum;

    private User user;

    public void showProfile(User serverUser){
        user = serverUser;
        name.setText(user.getFirstName());
        username.setText(user.getUsername());
        bio.setText(user.getPersonalInfo().getBio());
        location.setText(user.getPersonalInfo().getLocation());
        website.setText(user.getPersonalInfo().getWebsite());
        joinedDate.setText(user.getBirthDate().getMonth() + " "  + user.getBirthDate().getYear());
        followingNum.setText(Integer.toString(user.getFollowings().size()));
        followerNum.setText(Integer.toString(user.getFollowers().size()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        parent.setUserData(this);
    }
}
