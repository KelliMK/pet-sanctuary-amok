package petsanctuaryamok;

public class OrganicCow extends Cow {
	String petName;
	String petDesc;
	boolean isOrganic = true;
	boolean isCow = true;
	boolean isDragon = false;
	boolean dayTime;
	int cowMilk = 0;							// How much milk the current organic cow has
	int poopInPen = 0;							// effects of Hunger, Thirst, and Boredom are increased by this
	int currentTurn = 0;
	
	public OrganicCow(String petName, String petDesc, boolean isOrganic) {
		super(petName, petDesc, isOrganic);
		this.petName = petName;
		this.isOrganic = isOrganic;
		this.petDesc = petDesc;
	}
	
}
