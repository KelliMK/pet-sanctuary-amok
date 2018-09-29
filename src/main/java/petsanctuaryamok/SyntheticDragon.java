package petsanctuaryamok;

public class SyntheticDragon extends Dragon {
	String petName;
	String petDesc;
	boolean isOrganic = false;
	boolean isCow = false;
	boolean isDragon = true;
	boolean dayTime;
	int currentTurn = 0;
	
	public SyntheticDragon(String petName, String petDesc, boolean isOrganic) {
		super(petName, petDesc, isOrganic);
		this.petName = petName;
		this.isOrganic = isOrganic;
		this.petDesc = petDesc;
	}
}

