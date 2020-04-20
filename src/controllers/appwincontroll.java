package controllers;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Node;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import static controllers.Tabcon.TC;
import static controllers.Tabcon1.TC1;


public class appwincontroll{
    public Button btnvalider;
    public Button btnautre ;
    public Button btnsave ;
    public AnchorPane question;
    public AnchorPane anchor1 ;
    public AnchorPane anchorQ ;
   // public static Choix[] TC = new Choix[5];
    @FXML
    public RadioButton rbqo  ;
    public RadioButton rvf ;
    public TextField FT ;
    public TextField FM ;
    public static ArrayList<Qst> set = new ArrayList<Qst>();
    public Sub sujet ;
    //public Set<Qst> setqo = new HashSet<>();
    public TextField FQ;
    public TextField FN;
    public static boolean tf ;
    public RadioButton vrai;
    public RadioButton faux;
    public Spinner FD;
    public ToggleGroup tg ;
    public RadioButton rbqcs;
    public RadioButton rbqcm;
    public DatePicker FDate;
    public LocalDate Date ;
    public String D ;
    public Button ex;
    public Button min;
    public Label Err1;
    public Label Err;
    String t ;

    @FXML
    public void valider(ActionEvent actionEvent) {
        RadioButton srb =(RadioButton) tg.getSelectedToggle();
        t = srb.getText();
        System.out.println(t);

             btnvalider.setOnAction(event ->  {
                 if ((FT.getText() == null ||  ! FT.getText().trim().isEmpty() ) && (FM.getText() == null ||  ! FM.getText().trim().isEmpty()) && (t.equals("Question au choix ")) || (t.equals("Questions ouvertes"))) {
                     anchor1.setDisable(true);
                     anchorQ.setDisable(false);
                     System.out.println(D);
                     if (t.equals("Question au choix ")) rbqo.setDisable(true);
                     if (t.equals("Questions ouvertes")) {
                         rbqcm.setDisable(true);
                         rbqcs.setDisable(true);
                         rvf.setDisable(true);
                     }
                 } else Err.setText("Veuillez remplir tout les champs ");


             });

        }

    public void QCM(ActionEvent actionEvent) {

        try {

            URL url = getClass().getResource("/FXML/qcm.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            AnchorPane page = (AnchorPane) fxmlLoader.load(url.openStream());

            question.getChildren().clear();///name of pane where you want to put the fxml.
            question.getChildren().add(page);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void QCS(ActionEvent actionEvent) {
        try {

            URL url = getClass().getResource("/FXML/qcs.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            AnchorPane page = (AnchorPane) fxmlLoader.load(url.openStream());

            question.getChildren().clear();///name of pane where you want to put the fxml.
            question.getChildren().add(page);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void vf(ActionEvent actionEvent) {

        try {

            URL url = getClass().getResource("/FXML/VOF.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            AnchorPane page = (AnchorPane) fxmlLoader.load(url.openStream());

            question.getChildren().clear();///name of pane where you want to put the fxml.
            question.getChildren().add(page);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Nothing(ActionEvent actionEvent) {

        try {

            URL url = getClass().getResource("/FXML/OQ.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            AnchorPane page = (AnchorPane) fxmlLoader.load(url.openStream());

            question.getChildren().clear();
            question.getChildren().add(page);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    ToggleGroup TGG ;
    @FXML
    ToggleGroup TG11 ;


    public void setrue(ActionEvent actionEvent) {
        tf = true ;
        System.out.println("Hi  i am   " + tf);
    }

    public void setfalse(ActionEvent actionEvent) {
        tf = false ;
        System.out.println("Hi ana houwa " + tf);
    }

    public void OtherQ(ActionEvent actionEvent) {


        if (FQ.getText() == null || ! FQ.getText().trim().isEmpty())  {
            RadioButton t =(RadioButton) TGG.getSelectedToggle();
            if (t.getText().equals("Question ouverte ")) {

                Qst qo = new Qst(FQ.getText() , Float.parseFloat(FN.getText())) ;
                qo.toString();
                 String k = qo.toString();
                set.add(qo);
                System.out.println(k);
                FQ.setText("");
            }



                if (t.getText().equals("Vrai ou Faux")) {

                    VouF statement = new VouF(FQ.getText(), Float.parseFloat(FN.getText()), tf);
                    set.add(statement);
                    FQ.setText("");
                    System.out.println(tf);
                    try {

                        URL url = getClass().getResource("/FXML/VOF.fxml");
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(url);
                        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
                        AnchorPane page = (AnchorPane) fxmlLoader.load(url.openStream());

                        question.getChildren().clear();
                        question.getChildren().add(page);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            if (t.getText().equals("QCM")) {
                    QCM qcm = new QCM(FQ.getText(), Float.parseFloat(FN.getText()), TC);
                   set.add(qcm);
                    FQ.setText("");
                    try {
                        URL url = getClass().getResource("/FXML/qcm.fxml");
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(url);
                        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
                        AnchorPane page = (AnchorPane) fxmlLoader.load(url.openStream());

                        question.getChildren().clear();///name of pane where you want to put the fxml.
                        question.getChildren().add(page);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            if (t.getText().equals("QCS")) {
                    Choix [] c;
                    c = TC1 ;
                System.out.println("Hi");
                    QCM qcs = new QCM(FQ.getText(), Float.parseFloat(FN.getText()), c);
                    System.out.println("object");
                    set.add(qcs);
                    FQ.setText("");
                    try {
                        URL url = getClass().getResource("/FXML/qcs.fxml");
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(url);
                        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
                        AnchorPane page = (AnchorPane) fxmlLoader.load(url.openStream());

                        question.getChildren().clear();///name of pane where you want to put the fxml.
                        question.getChildren().add(page);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


        } else {
            Err1.setText("Veuillez Tapez l'ennonce de la question");

        }



    }


    public void SaveSub(ActionEvent actionEvent){
        if (FQ.getText().trim().isEmpty()){
            //System.out.println((int)FD.getValue());
            FileChooser FC = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
            FC.getExtensionFilters().add(extFilter);
            FC.setTitle("Save subject");
            File file = FC.showSaveDialog(new Stage());
            //System.out.println(file);
            String path = file.toString() ;
            System.out.println(path);
            path= path.replace("\\","\\\\");
            System.out.println(path);



            System.out.println(FT.getText());
            System.out.println(FM.getText());
            System.out.println((int)FD.getValue());
            sujet = new Sub(FT.getText() , FM.getText() , (int)FD.getValue() , this.set );
            System.out.println("it's done whith this");
            Element racine = new Element("Type");
            racine.setText(t);
            Element Date = new Element("Date") ;
            Date.setText(D);
            org.jdom2.Document document = new Document(racine);
            racine.addContent(sujet.jdSub());
            racine.addContent(Date);
            try
            {
                XMLOutputter xmlOutput = new XMLOutputter();
                xmlOutput.setFormat(Format.getPrettyFormat());
                xmlOutput.output(document, new FileWriter(path));
            }
            catch (java.io.IOException ignored){}

    } else {
           Err1.setText("Veuillez Ajouter la question");
        }
}


    public void SetD(ActionEvent actionEvent) {
        Date = FDate.getValue() ;
        D = Date.toString();


    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    public void minz(ActionEvent actionEvent) {
        Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
}




