package com.example.demo;

import Model.Tweet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class TweetController implements Initializable {

    @FXML
    private HBox tweetBox = new HBox();
    @FXML
    private Image image = new Image("like.png");
    private ImageView likeIcon = new ImageView(new Image("like.png"));
    @FXML
    private Circle profileCircle;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        profileCircle.setFill(new ImagePattern(image));
    }
    //    private VBox myBox;
//    private void addBox(HBox hBox) {
//        myBox.getChildren().add(hBox);
//    }

}
