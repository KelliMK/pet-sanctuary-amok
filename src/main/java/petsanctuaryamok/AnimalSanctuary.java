package petsanctuaryamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AnimalSanctuary {

	Map<String, VirtualPet> animals = new HashMap<>();
	Map<String, Cow> cows = new HashMap<>();
	Map<String, Dragon> dragons = new HashMap<>();
	Map<String, VirtualPet> organics = new HashMap<>();
	Map<String, VirtualPet> synthetics = new HashMap<>();
	
	public void addAnimalToShelter(VirtualPet testAnimal) {
		animals.put(testAnimal.getName(), testAnimal);
		if (testAnimal.isOrganic == true) {
			// More to do in this method
		}
	}
	
	public void fireEmployee(String testFuckerID) {
		animals.remove(testFuckerID);
		// More to do in this method
	}

	public Collection<VirtualPet> getEmployees() {
		
		return animals.values();
		// more to do in this method
	}

}