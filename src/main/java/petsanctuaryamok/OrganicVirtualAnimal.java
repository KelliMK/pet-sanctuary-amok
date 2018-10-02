package petsanctuaryamok;

import java.util.Random;

public class OrganicVirtualAnimal extends VirtualPet {
	Random rand = new Random();
	String petName;
	String petDesc;
	String petID;
	boolean isOrganic = true;
	boolean isCow;
	boolean isDragon;
	int petDirtiness = 0;								// out of 50
	int petHunger = 0;									// out of 50
	int petThirst = 0; 									// out of 50
	int petTired = 0; 									// pets can play twice a day
	int petBoredom = 0;									// out of 50
	int petMood = 0;									// the higher this is, the worse the pet's mood
	int randThirst = rand.nextInt(3);
	int randHunger = rand.nextInt(7);
	int randBoredom = rand.nextInt(4);
	
	public OrganicVirtualAnimal(String petName, String petDesc, String petID) {
		super(petName, petDesc, petID);
		this.petName = petName;
		this.petDesc = petDesc;
		this.petID = petID;
		this.isOrganic = true;
	}
	
	public void drain() {
		// write this out later
	}
	
	public boolean tick() {
		return true;
	}
	
	public boolean calculateMood() {
		petMood = (((petThirst + petHunger + petBoredom + petDirtiness) / 2));
		if (petMood <= 100 && petMood >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
