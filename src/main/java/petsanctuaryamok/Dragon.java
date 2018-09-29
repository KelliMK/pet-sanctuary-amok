package petsanctuaryamok;

public class Dragon extends VirtualPet {
	String petName;
	String petDesc;
	boolean isOrganic;
	boolean isCow = false;
	boolean isDragon = true;
	boolean dayTime;
	int currentTurn = 0;
	
	public Dragon(String petName, String petDesc, boolean isOrganic) {
		super(petName, petDesc, isOrganic);
		this.petName = petName;
		this.isOrganic = isOrganic;
		this.petDesc = petDesc;
	}
}
