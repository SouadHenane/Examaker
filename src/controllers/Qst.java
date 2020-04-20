package controllers;


import org.jdom2.* ;
import org.jdom2.Element ;

public class Qst {
    public  String ennonce ;
    public  float  brm ;
    public Qst (){}

    public Qst (String e , float brm )
    {
       this.ennonce = e ;
        this.brm = brm ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Qst) {
            return this.ennonce.equals(((Qst) obj).ennonce);
        }else return false;
    }

    @Override
    public int hashCode() {
        return this.ennonce.length();
    }

    // la methode d'ecrire la question sous  XML
    public Element jdom() {
        org.jdom2.Element Question = new Element("Question"); 
        org.jdom2.Element enn = new org.jdom2.Element("Ennonce");
        enn.setText(this.ennonce);
        Question.addContent(enn);
        org.jdom2.Element note = new Element("Note");
        note.setText(String.valueOf(this.brm));
        Question.addContent(note);
        return Question; 


    }
    @Override
    public String toString(){
        return ("La question est "+ this.ennonce +"et la note est :"+ String.valueOf(this.brm) );

    }
}

