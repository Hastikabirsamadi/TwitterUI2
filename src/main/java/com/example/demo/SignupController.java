package com.example.demo;

import Client.Client;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignupController implements Initializable {


    @FXML
    TextField nameTextField;
    @FXML
    TextField lastNameTextField;
    @FXML
    TextField phoneOrEmail;

    @FXML
    TextField username;
    @FXML
    TextField pass;
    @FXML
    TextField passRepetition;
    @FXML
    ChoiceBox<String> country;
    @FXML
    DatePicker birthdate;
    @FXML
    private Parent root;
    @FXML
    private Label error;
    private Stage stage;
    private Scene scene;
    private boolean hasError = true;
    private TextField textField;

    public void switchToMainMenu(ActionEvent event) throws IOException { // exit button
        root = FXMLLoader.load(Client.class.getResource("FirstPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        textField.setVisible(true);
    }

    public void signUp(ActionEvent event) throws IOException {

        String firstname = nameTextField.getText();
        String lastname = lastNameTextField.getText();
        String numberOrEmail = phoneOrEmail.getText();
        String user = username.getText();
        String password = pass.getText();
        String passRep = passRepetition.getText();
        String country2 = country.getValue();
        LocalDate birthday = birthdate.getValue();
        try {
            Client.signUp(firstname, lastname, numberOrEmail, user, password, passRep, country2, birthday);
        }
        catch (IllegalArgumentException e){
            hasError = false;
            error.setText(e.getMessage());
        }
        catch (ParseException | InterruptedException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(hasError) {
            Parent root = FXMLLoader.load(Client.class.getResource("signup2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println(firstname + "  " + lastname + "  ");
        }
    }
        ObservableList<String> temp = FXCollections.observableArrayList("Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","China","Colombia","Comoros","Congo","Congo {Democratic Rep}","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland {Republic}","Israel","Italy","Ivory Coast","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Korea North","Korea South","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malakhestan","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar, {Burma}","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Qom","Romania","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia","Saint Vincent & the Grenadines","Samoa","San Marino","Sao Tome & Principe","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe");
           @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        country.setItems(temp);
    }
}
