package com.example.demo;

import Model.Tweet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TweetController {
    @FXML
    private Button profile;
    @FXML
    private ImageView like;
    @FXML
    private ImageView comment;
    @FXML
    private ImageView retweet;
    @FXML
    private ImageView quote;
    @FXML
    private Label commentCount;
    @FXML
    private Label retweetCount;
    @FXML
    private Label likeCount;
    @FXML
    private Label body;
    @FXML
    private Label name;
    @FXML
    private Label username;
    @FXML
    private Label passedTime;
    @FXML
    private HBox tweetBox;
    private Tweet tweet;

    public HBox showTweet(Tweet serverTweet){
        tweet = serverTweet;
        name.setText(tweet.getAuthor().getFirstName());
        tweetBox.getChildren().add(name);
        username.setText(tweet.getAuthor().getUsername());
        tweetBox.getChildren().add(username);
        passedTime.setText(tweet.calculateTime());
        tweetBox.getChildren().add(passedTime);
        body.setText(tweet.getBody());
        tweetBox.getChildren().add(body);
        commentCount.setText(Integer.toString(tweet.getComments()));
        tweetBox.getChildren().add(commentCount);
        likeCount.setText(Integer.toString(tweet.getLikedUsers().size()));
        tweetBox.getChildren().add(likeCount);
        retweetCount.setText(Integer.toString(tweet.getRetweetUsers().size()));
        tweetBox.getChildren().add(retweetCount);
        tweetBox.getChildren().add(like);
        tweetBox.getChildren().add(comment);
        tweetBox.getChildren().add(retweet);
        tweetBox.getChildren().add(quote);
        return tweetBox;
    }

    public void like(MouseEvent event){

    }
}
