package petsanctuaryamok;

public class SyntheticDragon extends SyntheticVirtualAnimal {
	String petName;
	String petDesc;
	String petID;
	boolean isOrganic = false;
	boolean isCow = false;
	boolean isDragon = true;
	boolean dayTime;
	int currentTurn = 0;
	int syntheticRust = 0;
	
	public SyntheticDragon(String petName, String petDesc, String petID) {
		super(petName, petDesc, petID);
		this.petName = petName;
		this.petDesc = petDesc;
		this.petID = petID;
		this.isOrganic = false;
	}
	
	@Override
	public void drain() {
		++syntheticRust;
	}
	
	@Override
	public String toString() {
		String balls = petName + "\t\t|" + petID + "\t\t|Dragon  |N/A     |N/A     |N/A     |N/A     |N/A     |N/A     |N/A     |" + syntheticRust + "\t\t|";
		return balls;
	}
}

