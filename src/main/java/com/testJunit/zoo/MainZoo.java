package com.testJunit.zoo;

import java.util.ArrayList;

import com.exception.zoo.AddFemaleException;


public class MainZoo {

	public static void main(String[] args) {
		
		ArrayList<Annimal> annimals= new ArrayList<Annimal>();
		annimals.add(new Annimal(RaceEnum.BISON,"monBissonMale1",'M',1));
		annimals.add(new Annimal(RaceEnum.BISON,"monBissonFemale",'F',2));
		annimals.add(new Annimal(RaceEnum.BISON,"monBissonMale2",'M',3));
		annimals.add(new Annimal(RaceEnum.LION,"monLionnMale1",'M',4));
		annimals.add(new Annimal(RaceEnum.LION,"monLionnMale2",'M',5));
		annimals.add(new Annimal(RaceEnum.LION,"monLionFemale",'F',6));
		annimals.add(new Annimal(RaceEnum.POISSON,"monPiossonMale",'M',7));
		annimals.add(new Annimal(RaceEnum.POISSON,"monPoissonFemale",'F',8));
			
		try {
			annimals.get(0).addFemale(annimals.get(1));
		} catch (AddFemaleException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(annimals.get(0));
		try {
			annimals.get(2).addFemale(annimals.get(0));
		} catch (AddFemaleException e) {
			System.out.println(e.getMessage());
		}
		try {
			annimals.get(2).addFemale(annimals.get(7));
		} catch (AddFemaleException e) {
			System.out.println(e.getMessage());
		}	
		System.out.println(annimals.get(2));
	}

}
