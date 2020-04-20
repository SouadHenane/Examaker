package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class firstonecontroller {
    @FXML
    public Button btnnv;
    public Button btno;
    public Button min;
    public Button ex;

    public void nouveau(ActionEvent actionEvent) {
        Stage stage;
        Parent root = null;
        stage = (Stage) btnnv.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/Appwin2.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void ouv(ActionEvent actionEvent) {
        FileChooser FC = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        FC.getExtensionFilters().add(extFilter);
        FC.setTitle("Save subject");
        File file = FC.showOpenDialog(new Stage());
        //System.out.println(file);
        String path = file.toString() ;
        System.out.println(path);
        path= path.replace("\\","\\\\");
        System.out.println(path);
        DB cnx = new DB(path);
        System.out.println("inséré");

    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }


    public void minz(ActionEvent actionEvent) {
        Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void ESI(Event event) {

    }
}
