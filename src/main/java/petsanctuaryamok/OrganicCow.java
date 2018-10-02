package petsanctuaryamok;

import java.util.Random;

public class OrganicCow extends OrganicVirtualAnimal {
	Random rand = new Random();
	String petName;
	String petDesc;
	String petID;
	boolean isOrganic = true;
	boolean isCow = true;
	boolean isDragon = false;
	int petDirtiness = 0;								// out of 50
	int petHunger = 0;									// out of 50
	int petThirst = 0; 									// out of 50
	int petTired = 0; 									// pets can play twice a day
	int petBoredom = 0;									// out of 50
	int petMood = 0;									// the higher this is, the worse the pet's mood
	int randThirst = rand.nextInt(3);
	int randHunger = rand.nextInt(7);
	int randBoredom = rand.nextInt(4);
	int cowMilk = 0;									// How much milk the current organic cow has
	int currentTurn = 0;
	
	public OrganicCow(String petName, String petDesc, String petID) {
		super(petName, petDesc, petID);
		this.petName = petName;
		this.petDesc = petDesc;
		this.petID = petID;
		this.isOrganic = true;
	}
	
	@Override
	public boolean calculateMood() {
		petMood = (((petThirst + petHunger + petBoredom + petDirtiness) - (cowMilk)) / 2);
		if (petMood <= 100 && petMood >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void drain() {
		int plusHunger = rand.nextInt(6);
		int plusThirst = rand.nextInt(4);
		int randDirt = rand.nextInt(3);
		int randMilk = rand.nextInt(3);
		petHunger += plusHunger;
		petThirst += plusThirst;
		petDirtiness += randDirt;
		cowMilk += randMilk;
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
		String balls = petName + "\t\t|" + petID + "\t\t|Cow     |" + petHealth +"\t\t|" + petHunger + "\t\t|" + petThirst + "\t\t|" + petBoredom + "\t\t|" + petDirtiness + "\t\t|" + petTired + "\t\t|" + cowMilk + "\t\t|N/A     |";
		return balls;
	}
	
	@Override
	public int milkCow() {
		int fuck = (cowMilk/3);
		cowMilk = 0;
		return fuck;
	}
	
}
