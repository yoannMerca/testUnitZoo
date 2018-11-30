package com.testJunit.zoo;

import com.exception.zoo.AddFemaleException;
import com.exception.zoo.MyException;

public class Annimal {
		/*Un animal possède une race, un surnom, un sexe et un numéro de tatouage.
		Deux animaux peuvent être accouplés si et seulement s’ils sont de sexe opposé et de même race (c’est
		l’animal male qui garde l’information d’accouplement).
		*/
	RaceEnum race;
	String surnom="";
	//true male  --- false female
	char sexe = 'M';
	int tatoo =0;

	Annimal female =null;
	
	
	
	public Annimal(RaceEnum race, String surnom, char sexe, int tatoo) {
		this.race = race;
		this.surnom = surnom;
		this.sexe = sexe;
		this.tatoo = tatoo;
	}
	public Annimal(RaceEnum race, String surnom, char sexe, int tatoo, Annimal female) {
		this.race = race;
		this.surnom = surnom;
		this.sexe = sexe;
		this.tatoo = tatoo;
		this.female = female;
	}
	public RaceEnum getRace() {
		return race;
	}
	public void setRace(RaceEnum race) {
		this.race = race;
	}
	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public int getTatoo() {
		return tatoo;
	}
	public void setTatoo(int tatoo) {
		this.tatoo = tatoo;
	}
	
	public Annimal getFemale() {
		return female;
	}
	public boolean checkFemale(Annimal newFemale) throws MyException {
		String message ="";
		boolean ifOk = true;
		if(!newFemale.getRace().equals(race)){
			message += " ils n'ont pas la meme race";
		}
		if(sexe != 'M'){
			message += " Ce n'est pas un male";
		}if(female != null) {
			message += " il à déjà une femelle";
		}if(newFemale.getSexe() != 'F' ) {
			message += " la femelle n'est pas une femelle";
		}
		if(message.length()>1 ){
			ifOk = false;
			throw new MyException(message);
		}
		return ifOk;
	}
	public boolean addFemale(Annimal newFemale) throws AddFemaleException {
		boolean test = false;
		try {
			if(checkFemale(newFemale)) {
				this.female = newFemale;
				test= true;
			}
		} catch (MyException e) {
			throw new AddFemaleException("l'ajout n'a pas abouti car "+e.getMessage());
		}
		
		return test;
	}
	@Override
	public String toString() {
		String result ="";
		if(female == null) {
			result = "Annimal [race=" + race + ", surnom=" + surnom + ", sexe=" + sexe + ", tatoo=" + tatoo + "]";
		}else {
			result = "Annimal [race=" + race + ", surnom=" + surnom + ", sexe=" + sexe + ", tatoo=" + tatoo +", female="+ female +"]";
		}
		return result;
	}
	
}
