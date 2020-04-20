package controllers;

import org.jdom2.* ;
import org.jdom2.Element ;


public class Choix {
     String Choice ;
    boolean choix1 ;

    public Choix (String choix , boolean choix1 ) {
         this.Choice = choix ;
        this.choix1 = choix1;
    }
    public Element jdchoix(){
        org.jdom2.Element statment=new Element("Choix");
        org.jdom2.Element stmnt  = new Element("Enndchoix");
        stmnt.setText(this.Choice);
        statment.addContent(stmnt);
        org.jdom2.Element bln = new org.jdom2.Element("boolean");
        bln.setText(String.valueOf(this.choix1));
        statment.addContent(bln);
        return  statment;

    }

}
