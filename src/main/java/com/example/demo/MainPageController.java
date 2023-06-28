package com.example.demo;

import Client.Client;
import Model.*;
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
    private static VBox timeline = new VBox();

    @FXML
    private ImageView profile;
    @FXML
    private ImageView search;
    @FXML
    private ImageView home;
    @FXML
    private Button textTweet;
    @FXML
    private ImageView photoTweet;
    private static Stage stage;
    private static Scene scene;
    private static ArrayList<Tweet> sentTweets;

    public static void showTimeline(ArrayList<Tweet> serverTweets){
        sentTweets = serverTweets;
        TweetController tweetController = new TweetController();
        for (Tweet tweet : sentTweets){
            timeline.getChildren().add(tweetController.showTweet(tweet));
        }
    }

    public static void switchToMainPage(ActionEvent event) throws IOException, ClassNotFoundException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Client.class.getResource("MainPage.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        try {
            showTimeline(Client.timelineReceiver());
            for (Tweet tweet : Client.timelineReceiver()) {
                System.out.println(tweet.getAuthor() + " : " + tweet.getBody());
            }
        } catch (NullPointerException e) {
            System.out.println("koomak !");
        }
        stage.show();
    }

    public void switchToAddTweet(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();
        FXMLLoader loader = new FXMLLoader(Client.class.getResource("addTweet.fxml"));
        Parent root = null;
        try {
            root=loader.load();
        }catch (IOException e){
            System.out.println("KOMAK!");
        }
        Stage stage = (Stage) imageView.getScene().getWindow();
        Scene scene = null;
        if (root != null) {
            scene = new Scene(root);
        }
        stage.setScene(scene);
        stage.show();
    }
}
