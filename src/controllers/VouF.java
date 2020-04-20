package controllers;

import org.jdom2.Element;

public class VouF extends Qst {
	private boolean stf ;

	public VouF (String e  , float brm , boolean stf) {
		super(e , brm);
		this.stf = stf ;

	}

	@Override
	public Element jdom ( ) {
		org.jdom2.Element Question= super.jdom();
		org.jdom2.Element vf = new org.jdom2.Element("vouf");
		vf.setText(String.valueOf(this.stf));
		Question.addContent(vf);
		return Question ;
	}

	

}
