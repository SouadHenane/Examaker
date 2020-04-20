package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Tabcon {

    @FXML
    public  TextField c1;
    public RadioButton r1;
    public TextField c2;
    public RadioButton r2;
    public TextField c3;
    public RadioButton r3;
    public TextField c4;
    public RadioButton r4;
    public TextField c5;
    public RadioButton r5;
    public Label Err;
    public Button AS;
    boolean b1 = false , b2 = false , b3 = false , b4 = false , b5 = false ;
    public static  Choix[] TC = new Choix[5] ;




    public void roa1(ActionEvent actionEvent) {
        if(r1.isSelected()){

            b1 = true ;
            System.out.println("Hii :) i am "+ b1 +" now !! ");
        } else    {
            b1 = false ;
            System.out.println("Hii i am r1 :) just copy me  i am "+ b1 +" now !! ");
        }

    }
    public void roa2(ActionEvent actionEvent) {
        if(r2.isSelected()){
            b2 = true ;
        } else    {
            b2 = false ;
        }
    }
    public void roa3(ActionEvent actionEvent) {
        if(r3.isSelected()){
            b3 = true ;

        } else    {
            b3 = false ;

        }
    }
    public void roa4(ActionEvent actionEvent) {
        if(r4.isSelected()){
            b4 = true ;
        } else    {
            b4 = false ;
        }
    }
    public void roa5(ActionEvent actionEvent) {
        if(r5.isSelected()){
            b5 = true ;
        } else    {
            b5 = false ;

        }
    }






    public void AddStat(ActionEvent actionEvent) {
        if ( (c1.getText() != null ||  ! c1.getText().trim().isEmpty()) && (c2.getText() != null || ! c2.getText().trim().isEmpty()) && (c3.getText() == null || ! c3.getText().trim().isEmpty())){
            System.out.println("it's working !! :3 ");
            TC[0] = new Choix(c1.getText() , b1) ;
            TC[1] = new Choix(c2.getText() , b2);
            TC[2]= new Choix(c3.getText() , b3);
                        if (c4.getText() != null || ! c4.getText().trim().isEmpty()) {
                            TC[3] = new Choix(c4.getText() , b4);
                        }else TC[3]= null ;
            if (c5.getText() != null || ! c5.getText().trim().isEmpty()) {
                TC[4] = new Choix(c5.getText() , b5);
            } else TC[4]= null ;
            Err.setText("Les choix sont ajoutés :D");
            c1.setText("");c2.setText("");c3.setText("");c4.setText("");c5.setText("");
                AS.setDisable(true);
        } else {
            Err.setText("3 champs sont obligatoires");
        }
    }
}
