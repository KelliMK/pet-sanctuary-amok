package petsanctuaryamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import petsanctuaryamok.VirtualPet;

public class AnimalSanctuary implements EmptyPoopPool, CleanAllPens, OilAllSynthetics {

	Random rand = new Random();
	String sanctuaryName = "";							// The name of the player's shelter
	int unitsMilk = 0;									// How much milk your shelter has, max of 50 units
	int currentMoney = 0;								// The funds your shelter has for supplies, no limit
	int totalFeed = 5;									// How many bags of regular feed your shelter has, shelter can store up to 50
	int totalFancyFeed = 3;								// How many bags of fancy feed your shelter has, shelter can store up to 30
	int waterTrough = 0;								// How many units of water your shelter has, can store up to 400
	int currentTurn = 0;								// Player can't go to the market at night, which will be turns 9 and 10 of a 10 turn cycle
	int currentDay = 0;									// How many days has the player worked at the shelter
	boolean dayTime = true;								// Is it day or night for the player
	int poopPool = 0;									// The pool for dragon poop
	
	public AnimalSanctuary(String sanctuaryName) {
		this.sanctuaryName = sanctuaryName;
	}
	
	// Dictionary of all animals
	Map<String, VirtualPet> animals = new HashMap<>();
	// ArrayList of all animals
	ArrayList<VirtualPet> animalsArray = new ArrayList<VirtualPet>();
	
	// Dictionary of all cows
	Map<String, VirtualPet> cows = new HashMap<>();
	// ArrayList of all cows
	ArrayList<VirtualPet> cowsArray = new ArrayList<VirtualPet>();
	
	// Dictionary of all dragons
	Map<String, VirtualPet> dragons = new HashMap<>();
	// ArrayList of all dragons
	ArrayList<VirtualPet> dragonsArray = new ArrayList<VirtualPet>();
	
	// Dictionary of all organics
	Map<String, VirtualPet> organics = new HashMap<>();
	// ArrayList of all organics
	ArrayList<VirtualPet> organicsArray = new ArrayList<VirtualPet>();
	
	// Dictionary of all synthetics
	Map<String, VirtualPet> synthetics = new HashMap<>();
	// ArrayList of all synthetics
	ArrayList<VirtualPet> syntheticsArray = new ArrayList<VirtualPet>();
	
	public void addAnimalToShelter(VirtualPet testAnimal) {
		animals.put(testAnimal.getID(), testAnimal);
		animalsArray.add(testAnimal);
		if (testAnimal.isOrganic == true) {
			organics.put(testAnimal.getID(), testAnimal);
			organicsArray.add(testAnimal);
		} else {
			synthetics.put(testAnimal.getID(), testAnimal);
			syntheticsArray.add(testAnimal);
		}
		if (testAnimal.isCow == true) {
			cows.put(testAnimal.getID(), testAnimal);
			cowsArray.add(testAnimal);
		} else {
			dragons.put(testAnimal.getID(), testAnimal);
			dragonsArray.add(testAnimal);
		}
	}
	
	public void removeAnimalFromShelter(VirtualPet testAnimal) {
		if (testAnimal.isOrganic == true) {
			organics.remove(testAnimal.getID());
		} else {
			synthetics.remove(testAnimal.getID());
		}
		if (testAnimal.isCow == true) {
			cows.remove(testAnimal.getID());
		} else {
			dragons.remove(testAnimal.getID());
		}
		animals.remove(testAnimal.getID());
	}

	public void limit() {
		for (VirtualPet foo : animalsArray) {
			foo.limit();
		}
		if (poopPool >= 50) {
			poopPool = 50;
		}
		if (poopPool < 0) {
			poopPool = 0;
		}
	}
	
	public boolean tick() {
		for (VirtualPet foo : animalsArray) {
			foo.tick();
		}
		if (currentTurn < 8) {
			++currentTurn;
			dayTime = true;
			return true;
		} else if (currentTurn == 8 || currentTurn == 9) {
			++currentTurn;
			dayTime = false;
			return true;
		} else if (currentTurn == 10) {
			currentTurn = 0;
			++currentDay;
			dayTime = true;
			return true;
		} else {
			return false;
		}
	}
	
	public void oilAllSynthetics() {
		for (VirtualPet foo : syntheticsArray) {
			foo.syntheticRust = 0;
		}
	}
	
	public void emptyPoopPool() {
		poopPool = 0;
	}
	
	public void cleanAllPens() {
		for (VirtualPet foo : cowsArray) {
			foo.petDirtiness = 0;
		}
	}
	
	@SuppressWarnings("unused")
	public void drain() {
		for (VirtualPet foo : animalsArray) {
			foo.drain();
		}
		for (VirtualPet foo : dragonsArray) {
			++poopPool;
		}
	}
	
	// Display the stats of all organic animals
	public void organicStats() {
		for(VirtualPet foo : organicsArray) {
			foo.toString();
		}
	}
	
	// Display the stats of all synthetic animals
	public void syntheticStats() {
		for(VirtualPet foo : syntheticsArray) {
			foo.toString();
		}
	}

	// Display the stats of all cows
	public void cowStats() {
		for(VirtualPet foo : cowsArray) {
			foo.toString();
		}
	}
	
	// Display the stats of all dragons
	public void dragonStats() {
		for(VirtualPet foo : dragonsArray) {
			foo.toString();
		}
	}
	
	public void dragonsPlay() {
		for (VirtualPet foo : dragonsArray) {
			if (foo.petTired < 3) {
				foo.petBoredom -= (dragonsArray.size()*5);
				++foo.petTired;
			}
		}
	}
	
	public void cowsPlay() {
		for (VirtualPet foo : cowsArray) {
			if (foo.petTired < 3) {
				foo.petBoredom -= (cowsArray.size()*2);
				++foo.petTired;
			}
		}
	}
	
	public Collection<VirtualPet> getAnimals() {
		return animals.values();
	}
	
	public Collection<VirtualPet> getOrganics() {
		return organics.values();
	}
	
	public Collection<VirtualPet> getSynthetics() {
		return synthetics.values();
	}
	
	public Collection<VirtualPet> getCows() {
		return cows.values();
	}
	
	public Collection<VirtualPet> getDragons() {
		return dragons.values();
	}

}