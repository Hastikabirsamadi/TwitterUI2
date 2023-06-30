package com.example.demo;

import Client.Client;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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

    @FXML
    private TextField editedBio;
    @FXML
    private TextField editedWebsite;
    @FXML
    private TextField editedLocation;
    @FXML
    private Label error;
    private boolean hasError = false;

    private User user;

    public void showProfile(User serverUser){
        user = serverUser;
        name.setText(user.getFirstName());
        username.setText(user.getUsername());
        bio.setText(user.getPersonalInfo().getBio());
        location.setText(user.getPersonalInfo().getLocation());
        website.setText(user.getPersonalInfo().getWebsite());
        joinedDate.setText(user.getSignupDate().getMonth() + " "  + user.getSignupDate().getYear());
        followingNum.setText(Integer.toString(user.getFollowings().size()));
        followerNum.setText(Integer.toString(user.getFollowers().size()));
    }

    public void backToMainPage(MouseEvent event) throws IOException, ClassNotFoundException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Client.class.getResource("MainPage.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        try {
            ((MainPageController) root.getUserData()).showTimeline(Client.timelineReceiver());
        } catch (NullPointerException e) {
            System.out.println("koomak !");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void switchToMainMenu(ActionEvent event) { // log out
        Button logout = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(Client.class.getResource("FirstPage.fxml"));
        Parent root = null;
        try {
            root=loader.load();
        }catch (IOException e){
            System.out.println("KOMAK koskesh!");
        }
        Stage stage = (Stage) logout.getScene().getWindow();
        Scene scene = null;
        if (root != null) {
            scene = new Scene(root);
        }
        stage.setScene(scene);
        stage.show();
    }

    public void editProfile(ActionEvent event) throws IOException, ClassNotFoundException {
        String biography = editedBio.getText();
        if (biography.length() == 0){
            biography = user.getPersonalInfo().getBio();
        }
        String loc = editedLocation.getText();
        if (loc.length() == 0){
            loc = user.getPersonalInfo().getLocation();
        }
        String web = editedWebsite.getText();
        if (web.length() == 0){
            web = user.getPersonalInfo().getWebsite();
        }
        hasError = false;
        try {
            Client.editProfile(biography, web, loc);
        }
        catch (IllegalArgumentException e){
            hasError = true;
            error.setText(e.getMessage());
        }
        catch (IOException | ClassNotFoundException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!hasError){
            backToShowProfile(event);
        }
    }

    public void backToShowProfile(ActionEvent event) throws IOException, ClassNotFoundException {
        Client.out.writeObject("0");
        Button button = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(Client.class.getResource("showProfile.fxml"));
        Parent root = null;
        try {
            root=loader.load();
        }catch (IOException e){
            System.out.println("KOMAK!");
        }
        Stage stage = (Stage) button.getScene().getWindow();
        Scene scene ;
        if (root != null) {
            scene = new Scene(root);
            stage.setScene(scene);
            Client.showMyProfile((ShowProfileController) root.getUserData());
            stage.show();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        parent.setUserData(this);

    }

}
