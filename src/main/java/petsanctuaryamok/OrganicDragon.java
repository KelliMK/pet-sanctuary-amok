package petsanctuaryamok;

public class OrganicDragon extends Dragon {
	String petName;
	String petDesc;
	boolean isOrganic = true;
	boolean isCow = false;
	boolean isDragon = true;
	boolean dayTime;
	int currentTurn = 0;
	
	public OrganicDragon(String petName, String petDesc, boolean isOrganic) {
		super(petName, petDesc, isOrganic);
		this.petName = petName;
		this.isOrganic = isOrganic;
		this.petDesc = petDesc;
	}
}
