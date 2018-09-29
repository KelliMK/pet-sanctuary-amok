package petsanctuaryamok;

public class SyntheticCow extends Cow {
	String petName;
	String petDesc;
	boolean isOrganic = false;
	boolean isCow = true;
	boolean isDragon = false;
	boolean dayTime;
	int poopInPen = 0;							// effects of Hunger, Thirst, and Boredom are increased by this
	int currentTurn = 0;
	
	public SyntheticCow(String petName, String petDesc, boolean isOrganic) {
		super(petName, petDesc, isOrganic);
		this.petName = petName;
		this.isOrganic = isOrganic;
		this.petDesc = petDesc;
	}
}
