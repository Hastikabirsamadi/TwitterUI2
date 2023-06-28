package com.example.demo;

import Client.Client;
import Model.Tweet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;

public class MainPageController {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox timeline;

    @FXML
    private ImageView profile;
    @FXML
    private ImageView search;
    @FXML
    private ImageView home;
    private Stage stage;
    private Scene scene;
    private ArrayList<Tweet> sentTweets;

    public void showTimeline(ArrayList<Tweet> serverTweets){
        sentTweets = serverTweets;
        TweetController tweetController = new TweetController();
        for (Tweet tweet : sentTweets){
            timeline.getChildren().add(tweetController.showTweet(tweet));
        }
    }

    public void switchToMainPage(ActionEvent event) throws IOException, ClassNotFoundException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Client.class.getResource("MainPage.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        this.showTimeline(Client.timelineReceiver());
        stage.show();
    }

    public void switchToAddTweet(MouseEvent event) throws IOException {
        ImageView imageView = (ImageView) event.getSource();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Client.class.getResource("addTweet.fxml")));
        stage = (Stage) imageView.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//        try {
//            root=loader.load();
//        }catch (IOException e){
//            System.out.println("KOMAK!");
//        }
//        stage = (Stage) imageView.getScene().getWindow();
//        scene = null;
//        if (root != null) {
//            scene = new Scene(root);
//        }
//        stage.setScene(scene);
//        stage.show();
    }
}
