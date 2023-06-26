package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import Model.*;
import Server.ServerManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.util.Scanner;

public class Client extends Application {
    private static Socket client;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static Thread clientReceiverThread;
    private static Scanner scanner;
    private static User user;
    private static boolean done = false;
    private static boolean isSignIn = false;
    private static boolean isSignUP = false;
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Client.class.getResource("FirstPage.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Twitter");
            Image twitterLogo = new Image("icon.png");
            stage.getIcons().add(twitterLogo);

            stage.setScene(scene);
            stage.show();

            client = new Socket("localhost", 9999);
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String signUp(String name, String lastName, String emailOrNumber , String userName, String pass,
                                 String passRepetition,String country, LocalDate birthDate)
            throws ParseException, IOException, InterruptedException, ClassNotFoundException {
        String temp;
        String phone = null, email = null;
        if(name.length() == 0 || lastName.length() == 0 || emailOrNumber.length() == 0 || userName.length() == 0 || pass.length() == 0 || passRepetition.length() == 0
                || country.length() == 0 || birthDate.getDayOfWeek() == null) {
            throw new IllegalArgumentException("Please fill in all the fields!");
        }
        if (ClientManager.checkEmailFormat(emailOrNumber)) {
            email = emailOrNumber;
        } else if (ClientManager.checkPhoneNumberFormat(emailOrNumber)) {
            if (ClientManager.checkPhoneNumberLength(emailOrNumber))
                phone = emailOrNumber;
            else {
                throw new IllegalArgumentException("invalid format for phone number!");
            }
        } else {
            throw new IllegalArgumentException("invalid format for phone number or email!");
        }
        if (!ClientManager.checkPasswordLength(pass)) {
            throw new IllegalArgumentException("password must be at least 8 characters!");
        }
        if (!ClientManager.checkPasswordFormat(pass)) {
            throw new IllegalArgumentException("The format of the password is wrong!");
        }
        if (!pass.equals(passRepetition)) {
            throw new IllegalArgumentException("Wrong repetition!");
        }
        user = new User(userName, pass, name, lastName, email, phone, country, birthDate);
        out.writeObject("1");
        Thread.sleep(500);
        out.writeObject(user);
        Thread.sleep(500);
        temp = (String) in.readObject();
        if (temp.equals("signed up successfully!")) {
            isSignUP = true;
        }
        return temp;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
