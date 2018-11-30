package com.testJunit.zoo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.exception.zoo.AddFemaleException;

public class testZoo {
	ArrayList<Annimal> annimals = new ArrayList<Annimal>();

	@Before
	public void init() {
		annimals = new ArrayList<Annimal>();
		annimals.add(new Annimal(RaceEnum.BISON, "monBissonMale1", 'M', 1));
		annimals.add(new Annimal(RaceEnum.BISON, "monBissonFemale", 'F', 2));
		annimals.add(new Annimal(RaceEnum.BISON, "monBissonMale2", 'M', 3));
		annimals.add(new Annimal(RaceEnum.LION, "monLionnMale1", 'M', 4));
		annimals.add(new Annimal(RaceEnum.LION, "monLionnMale2", 'M', 5));
		annimals.add(new Annimal(RaceEnum.LION, "monLionFemale", 'F', 6));
		annimals.add(new Annimal(RaceEnum.POISSON, "monPiossonMale", 'M', 7));
		annimals.add(new Annimal(RaceEnum.POISSON, "monPoissonFemale", 'F', 8));
		annimals.add(new Annimal(RaceEnum.BISON, "monBissonFemale2", 'F', 9));
	}

	// test si en condition normale d'ajout la methode me renvoit bien true
	@Test
	public void testNewAddFemaleOK() throws AddFemaleException {
		assertTrue(annimals.get(0).addFemale(annimals.get(1)));
	}

	// test pour verfifier que l'execption est la bonne
	@Test(expected = AddFemaleException.class)
	public void testNewAddFemale_NotOK() throws AddFemaleException {
		annimals.get(0).addFemale(annimals.get(5));
	}

	// TEST si le message d'erreur quand on ajoute une femelle qui n'a pas la meme
	// race que le male est le bon
	@Test
	public void testNewAddFemale_FemaleNotSameRace() {
		try {
			annimals.get(0).addFemale(annimals.get(5));
		} catch (AddFemaleException e) {
			// System.err.println(e.getMessage());
			assert (e.getMessage().contains("ajout n'a pas abouti car  ils n'ont pas la meme race"));
		}
	}

	// TEST si le message d'erreur quand on ajoute un male sur un male est le bon
	@Test
	public void testNewAddFemale_FemaleSameSexe() {
		try {
			annimals.get(0).addFemale(annimals.get(2));
		} catch (AddFemaleException e) {
			// System.err.println(e.getMessage());
			assert (e.getMessage().contains("l'ajout n'a pas abouti car  la femelle n'est pas une femelle"));
		}
	}

	// TEST si le message d'erreur quand on ajoute une femelle sur une femelle est
	// le bon
	@Test
	public void testNewAddFemale_AddOnFemale() {
		try {
			annimals.get(5).addFemale(annimals.get(4));
		} catch (AddFemaleException e) {
			// System.err.println(e.getMessage());
			assert (e.getMessage().contains("l'ajout n'a pas abouti car  Ce n'est pas un male"));
		}
	}

	// TEST si le message d'erreur quand on ajoute une femelle a un male qui a deja
	// un femelle est le bon
	@Test
	public void testNewAdd2Female() {
		try {
			annimals.get(0).addFemale(annimals.get(1));
			annimals.get(0).addFemale(annimals.get(8));
		} catch (AddFemaleException e) {
			// System.err.println(e.getMessage());
			assert (e.getMessage().contains("l'ajout n'a pas abouti car  il à déjà une femelle"));
		}
	}

	// TEST si le nom de la femelle ajoute est bien celui attendu
	@Test
	public void testNewAddNewFemaleCheckName() {
		try {
			annimals.get(0).addFemale(annimals.get(1));
			String nameFemale = annimals.get(0).getFemale().getSurnom();
			assertTrue(nameFemale.equals("monBissonFemale"));
		} catch (AddFemaleException e) {
			System.out.println("la testNewAddFemale n'a pas abouti");
		}
	}

	// TEST si la race de la femelle ajoute est bien celui attendu
	@Test
	public void testNewAddNewFemaleCheckrace() {
		try {
			annimals.get(0).addFemale(annimals.get(1));
			RaceEnum raceFemale = annimals.get(0).getFemale().getRace();
			assertTrue(raceFemale.equals(RaceEnum.BISON));
		} catch (AddFemaleException e) {
			System.out.println("la testNewAddNewFemaleCheckrace n'a pas abouti");
		}
	}

	// TEST si le sexe de la femelle ajoute est bien celui attendu
	@Test
	public void testNewAddNewFemaleCheckSexe() {
		try {
			annimals.get(0).addFemale(annimals.get(1));
			char sexeFemale = annimals.get(0).getFemale().getSexe();
			assertTrue(sexeFemale == 'F');
		} catch (AddFemaleException e) {
			System.out.println("la testNewAddNewFemaleCheckSexe n'a pas abouti");
		}
	}
	// TEST si le tatoo de la femelle ajoute est bien celui attendu
		@Test
		public void testNewAddNewFemaleCheckTatoo() {
			try {
				annimals.get(0).addFemale(annimals.get(1));
				int tatooFemale = annimals.get(0).getFemale().getTatoo();
				assertTrue(tatooFemale == 2);
			} catch (AddFemaleException e) {
				System.out.println("la testNewAddNewFemaleCheckTatoo n'a pas abouti");
			}
		}
}
