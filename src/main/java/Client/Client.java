package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Client extends Application {
    @Override
    public void start(Stage stage) {
        try {
            //FXMLLoader fxmlLoader = FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            Parent root = FXMLLoader.load(Client.class.getResource("FirstPage.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Twitter");
            Image twitterLogo = new Image("icon.png");
            stage.getIcons().add(twitterLogo);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
