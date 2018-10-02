package petsanctuaryamok;

import java.util.Random;

public class VirtualPet implements Drain {
	Random rand = new Random();
	String petName;
	String petDesc;
	String petID;
	boolean isDead = false;
	boolean isOrganic;
	boolean isCow;
	boolean isDragon;
	boolean dayTime = true;
	int petDirtiness = 0;								// out of 50
	int petHunger = 0;									// out of 50
	int petThirst = 0; 									// out of 50
	int petTired = 0; 									// pets can play twice a day
	int petBoredom = 0;									// out of 50
	int petMood = 0;									// the higher this is, the worse the pet's mood
	int petHealth = 25;									// if this reaches 0, the animal dies and you lose $100 getting rid of it
	int randThirst = rand.nextInt(3);
	int randHunger = rand.nextInt(7);
	int randBoredom = rand.nextInt(4);
	int cowMilk = 0;									// How much milk the current organic cow has, out of 30
	int syntheticRust = 0;								// If this hits 15, synthetic breaks down and you throw it away
	int currentTurn = 0;
	
	public VirtualPet(String petName, String petDesc, String petID) {
		this.petName = petName;
		this.petDesc = petDesc;
		this.petID = petID;
	}
	
	public void drain() {
	}
	
	public boolean tick() {
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
	
	public String getName() {
		return petName;
	}
	
	public String getDesc() {
		return petDesc;
	}
	
	public String getID() {
		return petID;
	}

	@SuppressWarnings("unused")
	public void limit() {
		if (petHunger > 50) {
			petHunger = 50;
		} else if (petHunger < 0) {
			petHunger = 0;
		}
		if (petThirst > 50) {
			petThirst = 50;
		} else if (petThirst < 0) {
			petThirst = 0;
		}
		if (petBoredom < 0) {
			petBoredom = 0;
		} else if (petBoredom > 50) {
			petBoredom = 50;
		}
		if (cowMilk > 30) {
			cowMilk = 30;
		} else if (cowMilk < 0) {
			cowMilk = 0;
		}
		if (petTired >= 1 && dayTime == false) {
			petTired = 0;
		}
		if (petMood > 100) {
			petMood = 100;
		} else if (petMood < 0) {
			petMood = 0;
		}
		if (petHealth > 25) {
			petHealth = 25;
		} else if (petHealth < 0) {
			petHealth = 0;
		}
		if (syntheticRust < 0) {
			syntheticRust = 0;
		} else if (syntheticRust > 15) {
			syntheticRust = 15;
		}
		if (isOrganic = true && petHealth <= 0) {
			isDead = true;
		} 
		if (isOrganic = false && syntheticRust >= 15) {
			isDead = true;
		}
	}

	public String toString() {
		return "blah";
	}
	
	public boolean isItDayTime() {
		return dayTime;
	}
	
	// change in organic cow
	public int milkCow() {
		return 0;
	}
	
	public boolean calculateMood() {
		petMood = (((petThirst + petHunger + petBoredom + petDirtiness)) / 2);
		if (petMood <= 100 && petMood >= 0) {
			return true;
		} else {
			return false;
		}
	}

	
	public void play() {
		if (petBoredom > 0 && petTired < 3) {
			System.out.println("You and " + petName + " have some fun");
			petBoredom -= 20;
			++petTired;
		} else if (petTired >= 3) {
			System.out.println(petName + " is too tired to play, and looks pissed at your suggestion");
		} else {
			System.out.println(petName + " is content and doesn't want to play");
		}
		
	}
}
