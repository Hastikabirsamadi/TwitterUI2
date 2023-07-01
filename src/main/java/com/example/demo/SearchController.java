package com.example.demo;

import Client.Client;
import Model.User;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    public AnchorPane parent;
    @FXML
    private TextField searchChoice;
    @FXML
    private Button searchButton;
    @FXML
    private Label error;
    @FXML
    private Pane searchBox;
    @FXML
    private Label name;
    @FXML
    private Label username;
    @FXML
    private VBox searchOptions;
    //private User user;
    public void search() {
//        System.out.println("CLICKED");
        try {
            String word = searchChoice.getText();
            Client.out.writeObject("4");
            Client.out.writeObject(word);
            ArrayList<User> foundUsers = (ArrayList<User>) Client.in.readObject();
            if (foundUsers.size() == 0) {
                error.setText("Not Found!");
            }
            showSearchOptions(foundUsers);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    public void handleSearch() {
//        searchButton.setOnAction(this::search);
//    }
    public void showSearch(User serverUser){
      //  user = serverUser;
        name.setText(serverUser.getFirstName());
        username.setText(serverUser.getUsername());
    }

    public void showSearchOptions(ArrayList<User> serverUser){
        searchOptions.getChildren().clear();
        for (User user : serverUser){
            try {
                Node node = FXMLLoader.load(Client.class.getResource("BriefProfile.fxml"));
//                System.out.println(user.getUsername());
                ((SearchController) node.getUserData()).showSearch(user);
                searchOptions.getChildren().add(node);
            } catch (Exception ignore){
                ignore.printStackTrace();
                //System.out.println("toye show search error dari");
            }
        }
    }

//    public void switchToSearchOptions(ActionEvent event) throws IOException, ClassNotFoundException {
//        Button button = (Button) event.getSource();
//        FXMLLoader loader = new FXMLLoader(Client.class.getResource("Search.fxml"));
//        Parent root = null;
//        try {
//            root=loader.load();
//        }catch (IOException e){
//            System.out.println("KOMAK!");
//        }
//        Stage stage = (Stage) button.getScene().getWindow();
//        Scene scene = null;
//        if (root != null) {
//            scene = new Scene(root);
//        }
//        stage.setScene(scene);
//        //((SearchController) root.getUserData()).search();
//        stage.show();
//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        parent.setUserData(this);
    }
}
