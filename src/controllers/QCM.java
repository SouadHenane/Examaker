package controllers;

import org.jdom2.Element;

public class QCM extends Qst {
	
	public String ennonce ; 
	public Choix[] TC = new Choix[5] ;
	public float brm ;


	 public QCM (String e , float brm , Choix [] TC  ) {
		 super (e , brm) ;
		 this.TC = TC ;
	 }

	@Override
	public Element jdom(){
		Element Question = super.jdom();
		org.jdom2.Element statments  = new org.jdom2.Element("statmnts");
		for (int i=0  ; i < TC.length ; i++) {
			statments.addContent(TC[i].jdchoix());
		}
        Question.addContent(statments);
        return Question ;
	}
	



}
