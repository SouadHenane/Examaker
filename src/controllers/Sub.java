package controllers;

import org.jdom2.Element;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sub {
    String Title ;
    String Module ;
    int Duree ;
    ArrayList<Qst> setQ = new ArrayList<Qst>();

    public Sub(String Title ,String Module ,int duree ,ArrayList<Qst> set){
        this.Title = Title ;
        this.Module = Module ;
        this.Duree = duree ;
        this.setQ =  set ;

    }


    public Element jdSub (){
        org.jdom2.Element sujet = new org.jdom2.Element("Sujet");
        org.jdom2.Element head = new Element("Head");
        sujet.addContent(head);
        org.jdom2.Element title = new org.jdom2.Element("Titre");
        title.setText(this.Title);
        head.addContent(title);
        org.jdom2.Element module = new Element("Module");
        System.out.println(this.Module);
        module.setText(this.Module.toString());
        head.addContent(module);
        org.jdom2.Element duree = new org.jdom2.Element("Duree");
        duree.setText(String.valueOf(this.Duree));
        head.addContent(duree);
        Qst qst_temp=new Qst();
            for ( int i= 0 ; i< setQ.size() ; i++ ){
                qst_temp=setQ.get(i);
                sujet.addContent(qst_temp.jdom());
           }

        return sujet ;



    }




}