package petsanctuaryamok;

public class Cow extends VirtualPet implements CleanAllPens {
	String petName;
	String petDesc;
	boolean isOrganic;
	boolean isCow = true;
	boolean isDragon = false;
	boolean dayTime;
	int poopInPen = 0;							// effects of Hunger, Thirst, and Boredom are increased by this
	int currentTurn = 0;
	
	public Cow(String petName, String petDesc, boolean isOrganic) {
		super(petName, petDesc, isOrganic);
		this.petName = petName;
		this.isOrganic = isOrganic;
		this.petDesc = petDesc;
	}
	
	@Override
	public boolean tick() {
		if (currentTurn >= 0 && currentTurn < 8) {
			dayTime = true;
			++currentTurn;
			if (currentTurn%2 == 1 || currentTurn == 4) {
				++poopInPen;	
			}
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
	
	public boolean cleanAllPens() {
		if (dayTime) {
			poopInPen = 0;
			return true;
		} else {
			return false;
		}
	}
}
