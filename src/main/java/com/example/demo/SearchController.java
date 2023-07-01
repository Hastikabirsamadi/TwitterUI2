package com.example.demo;

import Client.Client;
import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    public AnchorPane parent;
    @FXML
    private TextField searchChoice;
    @FXML
    private Label error;
    @FXML
    private Pane searchBox;
    @FXML
    private Label name;
    @FXML
    private Label username;
    @FXML
    private VBox searchOption = new VBox();
    private User user;
    public void search() throws IOException, ClassNotFoundException {
        String word = searchChoice.getText();
        Client.out.writeObject("4");
        Client.out.writeObject(word);
        ArrayList<User> foundUsers = (ArrayList<User>) Client.in.readObject();
        if (foundUsers.size() == 0){
            error.setText("Not Found!");
        }
        showSearchOptions(foundUsers);
    }
    public Pane showSearch(User serverUser){
        user = serverUser;
        name.setText(user.getFirstName());
        searchBox.getChildren().add(name);
        username.setText(user.getUsername());
        searchBox.getChildren().add(username);
        return searchBox;
    }

    public void showSearchOptions(ArrayList<User> serverUser){
        for (User user : serverUser){
            try {
                Node node = FXMLLoader.load(Client.class.getResource("BriefProfile.fxml"));
                showSearch(user);
                searchOption.getChildren().add(node);
            } catch (Exception ignore){
                System.out.println("toye show search error dari");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        parent.setUserData(this);
    }
}
