package petsanctuaryamok;

public class VirtualPet {
	String petName;
	String petDesc;
	boolean isOrganic;
	boolean isCow;
	boolean isDragon;
	boolean dayTime;
	int currentTurn = 0;
	
	public VirtualPet(String petName, String petDesc, boolean isOrganic) {
		this.petName = petName;
		this.isOrganic = isOrganic;
		this.petDesc = petDesc;
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
	
	public boolean isItDayTime() {
		return dayTime;
	}
}
