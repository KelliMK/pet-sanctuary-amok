package petsanctuaryamok;

import java.util.Random;

public class OrganicDragon extends OrganicVirtualAnimal {
	String petName;
	String petDesc;
	String petID;
	boolean isOrganic = true;
	boolean isCow = false;
	boolean isDragon = true;
	boolean dayTime;
	int currentTurn = 0;
	Random rand = new Random();
	int petDirtiness = 0;								// out of 50
	int petHunger = 0;									// out of 50
	int petThirst = 0; 									// out of 50
	int petTired = 0; 									// pets can play twice a day
	int petBoredom = 0;									// out of 50
	int petMood = 0;									// the higher this is, the worse the pet's mood
	int petHealth = 25;	
	
	public OrganicDragon(String petName, String petDesc, String petID) {
		super(petName, petDesc, petID);
		this.petName = petName;
		this.petDesc = petDesc;
		this.petID = petID;
		this.isOrganic = true;
	}
	
	@Override
	public void drain() {
		int plusHunger = rand.nextInt(6);
		int plusThirst = rand.nextInt(4);
		int randDirt = rand.nextInt(3);
		petHunger += plusHunger;
		petThirst += plusThirst;
		petDirtiness += randDirt;
		if (petHunger >= 40) {
			--petHealth;
		}
		if (petThirst >= 35) {
			--petHealth;
		}
		if (petDirtiness >= 30) {
			--petHealth;
		}
	}
	
	@Override
	public String toString() {
		String balls = petName + "\t\t|" + petID + "\t\t|Dragons |" + petHealth +"\t\t|" + petHunger + "\t\t|" + petThirst + "\t\t|" + petBoredom + "\t\t|" + petDirtiness + "\t\t|" + petTired + "\t\t|N/A     |N/A     |";
		return balls;
	}
	
}
