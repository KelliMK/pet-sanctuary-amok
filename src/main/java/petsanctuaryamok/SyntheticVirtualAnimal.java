package petsanctuaryamok;

import java.util.Random;

public class SyntheticVirtualAnimal extends VirtualPet implements OilAllSynthetics {
	String petName;
	String petDesc;
	String petID;
	boolean isOrganic;
	boolean isCow;
	boolean isDragon;
	Random rand = new Random();
	int rust = 0;
	int randRust = rand.nextInt(5);
	
	public SyntheticVirtualAnimal(String petName, String petDesc, String petID) {
		super(petName, petDesc, petID);
		this.petName = petName;
		this.petDesc = petDesc;
		this.petID = petID;
		this.isOrganic = false;
	}
	
	@Override
	public void oilAllSynthetics() {
		if (rust == 0) {
			rust = 0;
		} else if (rust > 0 && rust <= 20) {
			rust = 0;
		} else if (rust <= 100) {
			rust -= 20;
		} else if (rust < 0) {
			rust = 0;
		} else {
			rust = 100;
		}
	}
	
	@Override
	public boolean tick() {
		rust += randRust;
		if (currentTurn >= 0 && currentTurn < 8) {
			dayTime = true;
			++currentTurn;
			return true;
		} else if (currentTurn == 8 || currentTurn == 9) {
			dayTime = false;
			++currentTurn;
			return true;
		} else if (currentTurn == 10) {
			dayTime = false;
			currentTurn = 0;
			return true;
		} else {
			return false;
		}
	}

}
