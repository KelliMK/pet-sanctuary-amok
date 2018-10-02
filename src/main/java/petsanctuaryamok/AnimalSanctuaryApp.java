package petsanctuaryamok;

import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import petsanctuaryamok.VirtualPet;
import petsanctuaryamok.AnimalSanctuary;
import petsanctuaryamok.OrganicVirtualAnimal;
import petsanctuaryamok.SyntheticVirtualAnimal;
import petsanctuaryamok.OrganicCow;
import petsanctuaryamok.OrganicDragon;
import petsanctuaryamok.SyntheticCow;
import petsanctuaryamok.SyntheticDragon;

@SuppressWarnings("unused")
public class AnimalSanctuaryApp {
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		boolean localKillSwitch = false; 						// When true, ends smaller individual cow loop
		boolean marketKillSwitch = false; 						// When true, ends smaller "market" loop
		boolean mainKillSwitch = false; 						// When true, ends game loop
		int randBoredom = rand.nextInt((8 - 3) + 1) + 3; 		// reduce boredom
		int randDesc = rand.nextInt((9 - 0) + 1);
		int IDNumber = 0;

		System.out.println("Welcome to \"Cow and Dragon Sanctuary Simulator!\"\nby Kelli Knipe\nASCII art by Christopher Johnson and Shanaka Dias");
		System.out.println("\n \nPlease input the name of your new cow sanctuary");
		System.out.print("> ");
		String sanctuaryName = input.nextLine();
		AnimalSanctuary sanctuary = new AnimalSanctuary(sanctuaryName);
		// Two user inputs so that we can convert all input to lowercase for the console
		String userInput1 = " ";
		String userInput2 = userInput1.toLowerCase();
		
		// Pets the shelter is initialized with
		// figure out how to automate IDs so that each pet is given a number and two initials according to type (for example: "sc0000" for the first synthetic Cow)
		// ... the above line will be implemented later
		SyntheticCow rose = new SyntheticCow("ROSE", "ROSE is a mechanical cow, here to make rescues comfortable", "sc0.00");
		OrganicCow melody = new OrganicCow("MELODY", "MELODY is a cutie, and loves to play", "oc0.00");
		SyntheticDragon josie = new SyntheticDragon("JOSIE", "JOSIE is a mechanical dragon, here to make rescues comfortable", "sd0.00");
		OrganicDragon selena = new OrganicDragon("SELENA", "SELENA was found abandoned in a field with a torn wing", "od0.00");
		sanctuary.addAnimalToShelter(rose);
		sanctuary.addAnimalToShelter(josie);
		sanctuary.addAnimalToShelter(melody);
		sanctuary.addAnimalToShelter(selena);
		
		while (!mainKillSwitch) {
			System.out.println("What you you like to do?\n1) Look at sanctuary stats (stats)\n2) Look at specific animal (specific)\n3) Clean up (clean)\n4) Let animals out to play (play)\n5) Manage animals (manage)\n6) Go to local market (market)\n7) Do nothing (nope)\n9) Exit game (exit)");
			System.out.print("> ");
			userInput1 = input.nextLine();
			userInput2 = userInput1.toLowerCase();
			
			// Choice number 1
			if (userInput2.equals("1") || userInput2.equals("stats")) {
				System.out.println("What stats would you like to display?\n1) All animal stats (all)\n2) All cow stats (cows)\n3) All dragon stats (dragons)\n4) All organics stats (organics)\n5) All synthetics stats (synthetics)\n6) Sanctuary Supplies (inventory) \n7) Nevermind (Im stupid)");
				System.out.print("> ");
				userInput1 = input.nextLine();
				userInput2 = userInput1.toLowerCase();
				chooseDisplay(userInput2, sanctuary);
			
			// Choice number 2
			} else if (userInput2.equals("2") || userInput2.equals("specific")) {
				System.out.println("Enter ID of organic animal you want to interact with");
				System.out.print("> ");
				userInput1 = input.nextLine();
				userInput2 = userInput1.toLowerCase();
				individualView(userInput2, sanctuary);
			
			// Choice number 3
			} else if (userInput2.equals("3") || userInput2.equals("clean")) {
				System.out.println("What would you like to clean?\n1) Dragon's poop pool (pool)\n2) Cow pens (pens)\n3) Oil all synthetics (oil)\n9) Nevermind (oops)");
				System.out.print("> ");
				userInput1 = input.nextLine();
				userInput2 = userInput1.toLowerCase();
				clean(userInput2, sanctuary);
			
			// Choice number 4
			} else if (userInput2.equals("4") || userInput2.equals("play")) {
				System.out.println("What animals do you want to let out to play?\n1) Cows (cows)\n2) Dragons (terrify town)\n3) Nevermind (oops)");
				System.out.print("> ");
				userInput1 = input.nextLine();
				userInput2 = userInput1.toLowerCase();
				if (userInput2.equals("1") || userInput2.equals("cows")) {
					System.out.println("You let the cows out to play");
					sanctuary.cowsPlay();
					sanctuary.drain();
					sanctuary.tick();
					sanctuary.limit();
				} else if (userInput2.equals("2") || userInput2.equals("dragons") || userInput2.equals("terrify town")) {
					System.out.println("You let the dragons out to fly and hear screams in the distance");
					sanctuary.dragonsPlay();
					sanctuary.drain();
					sanctuary.tick();
					sanctuary.limit();
				} else if (userInput2.equals("3") || userInput2.equals("oops") || userInput2.equals("nevermind")) {
					System.out.println("Okay");
				} else {
					System.out.println("I didn't catch that");
				}
			
			// Choice number 5 
			} else if (userInput2.equals("5") || userInput2.equals("manage")) {
				System.out.println("What would you like to do?\n1) Get a new animal (get animal)\n2) Give an animal to a new home (give away)\n3) Feed all animals (feed)\n4) Give all animals water (water)\n5) Take an animal to the vet for $25 (vet)\n9) nevermind (oops)");
				System.out.print("> ");
				userInput1 = input.nextLine();
				userInput2 = userInput1.toLowerCase();
				if (userInput2.equals("1") || userInput2.equals("get animal")) {
					System.out.println("What kind of animal?\n1) Rescue organic cow (organic cow)\n2) Rescue organic dragon (organic dragon)\n3) Buy synthetic cow for $50 (synthetic cow)\n4) Buy synthetic dragon for $100\n9) nevermind (oops)");
					++IDNumber;
					userInput1 = input.nextLine();
					userInput2 = userInput1.toLowerCase();
					newAnimal(userInput2, sanctuary, IDNumber);
				} else if (userInput2.equals("2") || userInput2.equals("give away")) {
					System.out.println("Which animal would you like to give to a good home? (Enter animal ID)");
					System.out.print("> ");
					userInput1 = input.nextLine();
					userInput2 = userInput1.toLowerCase();
					VirtualPet pisslord = sanctuary.animals.get(userInput2);
					if (!pisslord.isOrganic) {
						System.out.println("You made some money!");
						sanctuary.currentMoney += 25;
					}
					sanctuary.removeAnimalFromShelter(pisslord);
					sanctuary.drain();
					sanctuary.tick();
					sanctuary.limit();
				} else if (userInput2.equals("3") || userInput2.equals("feed")) {
					feedChoice(sanctuary);
					sanctuary.drain();
					sanctuary.tick();
					sanctuary.limit();
				} else if (userInput2.equals("4") || userInput2.equals("water")) {
					if (sanctuary.waterTrough >= sanctuary.organicsArray.size()) {
						for (VirtualPet foo : sanctuary.organicsArray) {
							foo.petThirst -= 10;
							--sanctuary.waterTrough;
						}
					sanctuary.drain();
					sanctuary.tick();
					sanctuary.limit();
					} else if (sanctuary.waterTrough < sanctuary.organicsArray.size()) {
						System.out.println("You don't have enough water");
					}
				} else if (userInput2.equals("5") || userInput2.equals("vet")) {
					System.out.println("Which animal would you like to take to the vet? (Enter animal ID)");
					System.out.print("> ");
					userInput1 = input.nextLine();
					userInput2 = userInput1.toLowerCase();
					// build function here
					VirtualPet pisslord = sanctuary.animals.get(userInput2);
					sanctuary.drain();
					sanctuary.tick();
					sanctuary.limit();
				} else if (userInput2.equals("9") || userInput2.equals("oops") || userInput2.equals("nevermind")) {
					System.out.println("Okay");
				} else {
					System.out.println("I didn't understand that");
				}
			
			// Choice number 6
			} else if (userInput2.equals("6") || userInput2.equals("market")) {
				market(sanctuary);
				sanctuary.drain();
				sanctuary.tick();
				sanctuary.limit();
			
			// Choice number 7
			} else if (userInput2.equals("7") || userInput2.equals("nope")) {
				System.out.println("Okay you lazy butt");
				sanctuary.drain();
				sanctuary.tick();
				sanctuary.limit();
			
			// Exit choice and catches for bad input
			} else if (userInput2.equals("9") || userInput2.equals("exit")) {
				mainKillSwitch = true;
			} else if (userInput2.equals("xyzzy")) {
				System.out.println("This isn't that type of game, but nice reference");
			} else {
				System.out.println("I didn't understand that");
			}
			deathCheck(sanctuary);
		}
		System.out.println("Thanks for playing!");
	}


	public static void newAnimal(String piss, AnimalSanctuary sanctuary, int IDNumber) {
		String[] cowDescriptions = { " seems to be in a good mood whenever you scratch her head",
				" has some spots that look like they make a face", " does not seem too fond of you",
				" loves playing with other cows", " once won a ribbon at the Ohio State Fair",
				" is terrified of people with blue hair", " will nibble your hand if you let her",
				" enjoys getting your attention", " once stepped on a rat that got in her stall",
				" goes moo so muuuuuuch" };
		String[] dragonDescriptions = { " loves rolling around with their arms tucked away like a cat", " is usually picking at the space between their toes", " is actually super docile most of the time", " can't breathe enough fire to light a match", " broke the roof of the last sanctuary they were at" };
		Random rand = new Random();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int randCowDesc = rand.nextInt(10);
		String cowDesc = cowDescriptions[randCowDesc];
		int randDragonDesc = rand.nextInt(5);
		String dragonDesc = dragonDescriptions[randDragonDesc];
		
		if ((piss.equals("1") || piss.equals("organic cow")) && sanctuary.organicsArray.size() < 10) {
			System.out.println("What do you want to name your new cow?");
			System.out.print("> ");
			String userInput1 = input.nextLine();
			String organicCowName = userInput1.toLowerCase();
			OrganicCow fuck = new OrganicCow(organicCowName, cowDesc, "oc" + IDNumber);
			sanctuary.addAnimalToShelter(fuck);
			sanctuary.drain();
			sanctuary.tick();
			sanctuary.limit();
		} else if ((piss.equals("2") || piss.equals("organic dragon")) && sanctuary.organicsArray.size() < 10) {
			System.out.println("What do you want to name your new dragon?");
			System.out.print("> ");
			String userInput1 = input.nextLine();
			String organicDragonName = userInput1.toLowerCase();
			OrganicDragon fuck = new OrganicDragon(organicDragonName, dragonDesc, "od" + IDNumber);
			sanctuary.addAnimalToShelter(fuck);
			sanctuary.drain();
			sanctuary.tick();
			sanctuary.limit();
		} else if ((piss.equals("1") || piss.equals("organic cow") || piss.equals("2") || piss.equals("organic dragon")) && sanctuary.organicsArray.size() >= 10) {
			System.out.println("Your sanctuary is at capacity! You can only hold up to 10 organic animals");
		} else if ((piss.equals("3") || piss.equals("synthetic cow")) && sanctuary.syntheticsArray.size() < 6 && sanctuary.currentMoney >= 50) {
			sanctuary.currentMoney -= 50;
			System.out.println("What do you want to name your new synthetic cow?");
			System.out.print("> ");
			String userInput1 = input.nextLine();
			String syntheticCowName = userInput1.toLowerCase();
			SyntheticCow fuck = new SyntheticCow(syntheticCowName, " is a synthetic", "sc" + IDNumber);
			sanctuary.addAnimalToShelter(fuck);
			sanctuary.drain();
			sanctuary.tick();
			sanctuary.limit();
		} else if ((piss.equals("4") || piss.equals("synthetic dragon")) && sanctuary.syntheticsArray.size() < 6 && sanctuary.currentMoney >= 100) {
			sanctuary.currentMoney -= 100;
			System.out.println("What do you want to name your new synthetic dragon?");
			System.out.print("> ");
			String userInput1 = input.nextLine();
			String syntheticDragonName = userInput1.toLowerCase();
			SyntheticCow fuck = new SyntheticCow(syntheticDragonName, " is a synthetic", "sd" + IDNumber);
			sanctuary.addAnimalToShelter(fuck);
			sanctuary.drain();
			sanctuary.tick();
			sanctuary.limit();
		} else if ((piss.equals("3") || piss.equals("synthetic cow") || piss.equals("4") || piss.equals("synthetic dragon")) && sanctuary.syntheticsArray.size() >= 6) {
			System.out.println("Your sanctuary is at capacity! You can only hold up to 6 synthetic animals");
		} else if (((piss.equals("3") || piss.equals("synthetic cow")) && sanctuary.currentMoney >= 50) || ((piss.equals("3") || piss.equals("synthetic cow")) && sanctuary.currentMoney >= 100)) {
			System.out.println("You don't have enough money");
		} else {
			System.out.println("I didn't understand that");
		}
	}
	
	
 	public static void clean(String input, AnimalSanctuary sanctuary) {
		if (input.equals("1") || input.equals("pool")) {
			sanctuary.emptyPoopPool();
			sanctuary.drain();
			sanctuary.tick();
			sanctuary.limit();
		} else if (input.equals("2") || input.equals("pens")) {
			sanctuary.cleanAllPens();
			sanctuary.drain();
			sanctuary.tick();
			sanctuary.limit();
		} else if (input.equals("3") || input.equals("oil")) {
			sanctuary.oilAllSynthetics();
			sanctuary.drain();
			sanctuary.tick();
			sanctuary.limit();
		} else if (input.equals("9") || input.equals("oops")) {
			System.out.println("No worries");
		}
	}
	
	
	@SuppressWarnings("resource")
	public static void market(AnimalSanctuary sanctuary) {
		Random rand = new Random();
		int randSales = rand.nextInt((35 - 15) + 1) + 15; 		// Sales of Milk
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the market!");
		System.out.println("   _        ,\n" + "  (_\\______/________\n" + "     \\-|-|/|-|-|-|-|/\n"
				+ "      \\==/-|-|-|-|-/\n" + "       \\/|-|-|-|,-'\n" + "        \\--|-'''\n"
				+ "         \\_j________\n" + "         (_)      (_)");
		int cashMade = (sanctuary.unitsMilk * randSales);
		System.out.println("You sold your " + sanctuary.unitsMilk + " units of milk for $" + cashMade);
		sanctuary.currentMoney += cashMade;
		sanctuary.unitsMilk = 0;
		System.out.println("You have $" + sanctuary.currentMoney);
		System.out.println("What would you like to do?\n1) Buy Water ($5 each)\n2) Buy Regular Feed ($20 each)\n3) Buy Fancy Feed ($50 each)\n4) Leave Market");
		System.out.print("> ");
		String marketInput = input.nextLine();
		String lowercaseMarketInput = marketInput.toLowerCase();
		
		// While loop for market view
		boolean marketKillSwitch = false;
		while (!marketKillSwitch) 
		{
			if (lowercaseMarketInput.equals("1") || lowercaseMarketInput.equals("buy water") || lowercaseMarketInput.equals("water")) {
				System.out.print("How many units of water would you like to buy?\nYour barn's trough can't handle more than 40 units at a time");
				System.out.print("> ");
				int waterWanted = input.nextInt();
				if ((waterWanted * 5) > sanctuary.currentMoney) 
				{
				System.out.println("You don't have enough money!");
				} 
				else 
				{
					if ((sanctuary.waterTrough + waterWanted) > 40) {
						System.out.println("You can't have more than 40 units of water in your trough at a time\n"
								+ "You currently have" + sanctuary.waterTrough + ", which means you'd have" + (sanctuary.waterTrough + waterWanted));
					}
					else 
					{
						sanctuary.currentMoney -= (waterWanted * 5);
						sanctuary.totalFancyFeed += waterWanted;
						System.out.println("You now have " + sanctuary.waterTrough + " units of water in your trough\n");
					}
				}
			} 
			else if (lowercaseMarketInput.equals("2") || lowercaseMarketInput.equals("buy regular feed") || lowercaseMarketInput.equals("regular feed") || lowercaseMarketInput.equals("regular")) 
			{
				System.out.print("How many bags of regular feed would you like to buy?\nYour barn can't handle more than 5 bags at a time");
				System.out.print("> ");
				int feedWanted = input.nextInt();
				if ((feedWanted * 20) > sanctuary.currentMoney) 
				{
					System.out.println("You don't have enough money!");
				} 
				else 
				{
					if ((sanctuary.totalFeed + feedWanted) > 50) {
						System.out.println("You can't have more than 50 bags of regular feed in your barn at a time\n"
								+ "You currently have" + sanctuary.totalFeed + ", which means you'd have" + (sanctuary.totalFeed + feedWanted));
					}
					else 
					{
						sanctuary.currentMoney -= (feedWanted * 20);
						sanctuary.totalFeed += feedWanted;
						System.out.println("You now have " + sanctuary.totalFeed + " bags of regular feed\n");
					}							
				}
			} 
			else if (lowercaseMarketInput.equals("3") || lowercaseMarketInput.equals("buy fancy feed") || lowercaseMarketInput.equals("fancy feed") || lowercaseMarketInput.equals("fancy")) 
			{
				System.out.println("How many bags of fancy feed would you like to buy?\nYour barn can't handle more than 5 bags at a time");
				System.out.print("> ");
				int fancyFeedWanted = input.nextInt();
				if ((fancyFeedWanted * 50) > sanctuary.currentMoney) 
				{
					System.out.println("You don't have enough money!");
				} 
				else 
				{
					if ((sanctuary.totalFancyFeed + fancyFeedWanted) > 30) {
						System.out.println("You can't have more than 30 bags of fancy feed in your barn at a time\n"
								+ "You currently have" + sanctuary.totalFancyFeed + ", which means you'd have" + (sanctuary.totalFancyFeed + fancyFeedWanted));
					}
					else 
					{
						sanctuary.currentMoney -= (fancyFeedWanted * 50);
						sanctuary.totalFancyFeed += fancyFeedWanted;
						System.out.println("You now have " + sanctuary.totalFancyFeed + " bags of fancy feed\n");
					}
				}
			} 
			else if (lowercaseMarketInput.equals("feed")) 
			{
				System.out.println("What type of feed?");
			} 
			else if (lowercaseMarketInput.equals("4") || lowercaseMarketInput.equals("leave market") || lowercaseMarketInput.equals("leave")) 
			{
				System.out.println("You head back to the cow shelter");
				marketKillSwitch = true;
			} 
			else 
			{
				System.out.println("Sorry, I didn't understand that");
			}
		}
	}
	
	
	public static void chooseDisplay(String foo, AnimalSanctuary sanctuary) {
		if (foo.equals("1") || foo.equals("all")) {
			System.out.println("Name    |ID      |Species |Health  |Hunger  |Thirst  |Boredom |Dirty   |Tired   |Milk    |Rust    |\n" + 
					"-------------------------------------------------------------------------------------------------\n" + 
					"maximum |N/A     |N/A     |25      |50      |50      |50      |50      |3       |30      |15      |");
			sanctuary.organicStats();
			sanctuary.syntheticStats();
		} else if (foo.equals("2") || foo.equals("cows")) {
			System.out.println("Name    |ID      |Species |Health  |Hunger  |Thirst  |Boredom |Dirty   |Tired   |Milk    |Rust    |\n" + 
					"-------------------------------------------------------------------------------------------------\n" + 
					"maximum |N/A     |N/A     |25      |50      |50      |50      |50      |3       |30      |15      |");
			sanctuary.cowStats();
		} else if (foo.equals("3") || foo.equals("dragons")) {
			System.out.println("Name    |ID      |Species |Health  |Hunger  |Thirst  |Boredom |Dirty   |Tired   |Milk    |Rust    |\n" + 
					"-------------------------------------------------------------------------------------------------\n" + 
					"maximum |N/A     |N/A     |25      |50      |50      |50      |50      |3       |30      |15      |");
			sanctuary.dragonStats();
		} else if (foo.equals("4") || foo.equals("organics")) {
			System.out.println("Name    |ID      |Species |Health  |Hunger  |Thirst  |Boredom |Dirty   |Tired   |Milk    |Rust    |\n" + 
					"-------------------------------------------------------------------------------------------------\n" + 
					"maximum |N/A     |N/A     |25      |50      |50      |50      |50      |3       |30      |15      |");
			sanctuary.organicStats();
		} else if (foo.equals("5") || foo.equals("synthetics")) {
			System.out.println("Name    |ID      |Species |Health  |Hunger  |Thirst  |Boredom |Dirty   |Tired   |Milk    |Rust    |\n" + 
					"-------------------------------------------------------------------------------------------------\n" + 
					"maximum |N/A     |N/A     |25      |50      |50      |50      |50      |3       |30      |15      |");
			sanctuary.syntheticStats();
		} else if (foo.equals("6") || foo.equals("inventory")) {
			System.out.println("You have " + sanctuary.totalFeed + "(/50) bags of regular feed\nYou have " + sanctuary.totalFancyFeed + "(/30) bags of fancy feed\nYou have " + sanctuary.waterTrough + "(/400) units of water\nYou have " + sanctuary.unitsMilk + "(/30) bottles of milk\nYou have $" + sanctuary.currentMoney);
		} else if (foo.equals("7") || foo.equals("im stupid")) {
			System.out.println("...okay");
		} else {
			System.out.println("Sorry, I didn't understand that");
		}
	}
	
	public static void deathCheck(AnimalSanctuary sanctuary) {
		for (VirtualPet foo : sanctuary.animalsArray) {
			if (foo.isDead) {
				sanctuary.currentMoney -= 25;
				sanctuary.removeAnimalFromShelter(foo);
			}
		}
	}
	
	public static void feedChoice(AnimalSanctuary sanctuary) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What type of feed would you like to give your animals?\n1) Regular feed (regular)\n2) Fancy feed (fancy)\n9) nevermind (oops)");
		System.out.print("> ");
		String userInput1 = input.nextLine();
		String userInput2 = userInput1.toLowerCase();
		int fuck = sanctuary.organicsArray.size();
		if ((userInput2.equals("1") || userInput2.equals("regular")) && sanctuary.totalFeed >= fuck) {
			for (VirtualPet foo : sanctuary.organicsArray) {
				foo.petHunger -= 15;
				--sanctuary.totalFeed;
				sanctuary.drain();
				sanctuary.tick();
				sanctuary.limit();
			}
		} else if ((userInput2.equals("1") || userInput2.equals("regular")) && sanctuary.totalFeed < fuck) {
			System.out.println("You don't have enough feed, idiot");
		} else if ((userInput2.equals("2") || userInput2.equals("fancy")) && sanctuary.totalFancyFeed >= fuck) {
			for (VirtualPet foo : sanctuary.organicsArray) {
				foo.petHunger -= 40;
				--sanctuary.totalFancyFeed;
				sanctuary.drain();
				sanctuary.tick();
				sanctuary.limit();
			}
		} else if ((userInput2.equals("2") || userInput2.equals("fancy")) && sanctuary.totalFancyFeed < fuck) {
			System.out.println("You don't have enough fancy feed, idiot");
		} else if (userInput2.equals("9") || userInput2.equals("oops") || userInput2.equals("nevermind")) {
			System.out.println("Okay");
		} else {
			System.out.println("I didn't catch that");
		}
	}
	
	public static void individualView(String petToExamine, AnimalSanctuary sanctuary) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String petToExamine1 = petToExamine.toLowerCase();
		VirtualPet petToExamine2 = sanctuary.animals.get(petToExamine1);
		boolean localKillSwitch = false;
		
		// While loop for individual cow view
		while (!localKillSwitch) {
			if (petToExamine2.isCow && petToExamine2.isOrganic) {
				System.out.println("What would you like to do with " + petToExamine2.getName() + "?\n1) look at " + petToExamine2.getName() + " (look at)\n2) play with " + petToExamine2.petName + " (play)\n3) Milk " + petToExamine2.getName() + "\n9) Nothin' else (exit)");
			} else if (petToExamine2.isOrganic) {
				System.out.println("What would you like to do with " + petToExamine2.getName() + "?\n1) look at " + petToExamine2.getName() + " (look at)\n2) play with (play)\n9) Nothin' else (exit)");
			} else {
				System.out.println("this ain't no actual animal");
				break;
			}
			System.out.print("> ");
			String anotherInput = input.nextLine();
			if (!petToExamine2.isOrganic) {
				
			} else if (anotherInput.equals("look at") || anotherInput.equals("1")) {
				petToExamine2.calculateMood();
				moodGraphic(petToExamine2);
			} else if (anotherInput.equals("play") || anotherInput.equals("2")) {
				petToExamine2.play();
				sanctuary.drain();
				sanctuary.tick();
				sanctuary.limit();
			} else if (anotherInput.equals("milk") || anotherInput.equals("3")) { 
				if (petToExamine2.isCow && petToExamine2.isOrganic) {
					petToExamine2.milkCow();
					sanctuary.drain();
					sanctuary.tick();
					sanctuary.limit();
				} else {
					System.out.println("..no");
				}
			} else if (anotherInput.equals("exit") || anotherInput.equals("9")) {
				System.out.println("You say goodbye to " + petToExamine2.petName);
				localKillSwitch = true;
			} else {
				System.out.println("Didn't catch that");
			}
		}
	}

	
	public static boolean moodGraphic(VirtualPet test) {
		System.out.println(test.petName + test.petDesc);
		if (!test.isOrganic) {
			System.out.println("Mechanical pets don't have moods");
			return true;
		} else if (test.isOrganic) {
			test.calculateMood();
			if (test.isCow) {
				displayCowMood(test);
				return true;
			} else if (test.isDragon) {
				displayDragonMood(test);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Display the cow's mood state
	public static void displayCowMood(VirtualPet test) {
		affectionateCowGraphic(test);
		happyCowGraphic(test);
		normalCowGraphic(test);
		sadCowGraphic(test);
		angryCowGraphic(test);
		asleepCowGraphic(test);
	}

	// Best Cow Mood State
	public static boolean affectionateCowGraphic(VirtualPet test) {
		if (test.petMood <= 20 && test.dayTime) {
			System.out.println(test.petName + " is very happy!");
			System.out.println("		           \\|/\n" + "   (___)      %            =+=\n"
					+ "   (^#^)_____/		   /|\\\n" + "    @@ `     \\         \n"
					+ "     \\ ____, /		\"moooo~\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}

	// Second Cow Best Mood State
	public static boolean happyCowGraphic(VirtualPet test) {
		if (test.petMood > 20 && test.petMood <= 40 && test.dayTime) {
			System.out.println(test.petName + " is happy");
			System.out.println("		           \\|/\n" + "   (___)      %            =+=\n"
					+ "   (^ ^)_____/		   /|\\\n" + "    @@ `     \\         \n"
					+ "     \\ ____, /		\"moooo!\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}

	// Middle Ground Cow Mood State
	public static boolean normalCowGraphic(VirtualPet test) {
		if (test.petMood > 40 && test.petMood <= 60 && test.dayTime) {
			System.out.println(test.petName + " seems melancholy");
			System.out.println("		           \\|/\n" + "   (___)                   =+=\n"
					+ "   (o o)_____/		   /|\\\n" + "    @@ `     \\         \n"
					+ "     \\ ____, /		\"moo\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}

	// Second Worst Cow Mood State
	public static boolean sadCowGraphic(VirtualPet test) {
		if (test.petMood > 60 && test.petMood <= 80 && test.dayTime) {
			System.out.println(test.petName + " is sad\nMaybe you should check up on her.");
			System.out.println("		           \\|/\n" + "   (___)      %            =+=\n"
					+ "   (- -)______		   /|\\\n" + "    @@ `     \\\\        \n"
					+ "     \\ ____, /		\"...\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}

	// Worst Cow Mood State
	public static boolean angryCowGraphic(VirtualPet test) {
		if (test.petMood > 80 && test.petMood <= 100 && test.dayTime) {
			System.out.println(test.petName + " is upset\nYou probably need to do something or let her sleep");
			System.out.println("		           \\|/\n" + "   (___)                   =+=\n"
					+ "   (\\ /)______		   /|\\\n" + "    @@ `     \\\\        \n"
					+ "     \\ ____, /		\"MRRRRRRR\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}

	// Asleep Cow Mood State
	// Would LOVE to learn how to set up a state-machine in Java
	public static boolean asleepCowGraphic(VirtualPet test) {
		if (!test.dayTime) {
			System.out.println(test.petName + " is asleep");
			System.out.println("                     ,-,\n" + "   (___)            / {   \n"
					+ "   (_ _)______	    \\ {    \n" + "    @@ `     \\\\      `-`\n" + "     \\ ____, / \\	 \n"
					+ "     //    //  		\"zzzz\"\n" + "     ``    ``");
			return true;
		} else {
			return false;
		}
	}

	// Display the dragon's mood state
	public static void displayDragonMood(VirtualPet test) {
		affectionateDragonGraphic(test);
		happyDragonGraphic(test);
		normalDragonGraphic(test);
		sadDragonGraphic(test);
		angryDragonGraphic(test);
		asleepDragonGraphic(test);
	}

	// Best Dragon Mood State
	public static boolean affectionateDragonGraphic(VirtualPet test) {
		if (test.petMood <= 20 && test.dayTime) {
			System.out.println(test.petName + " is very happy!");
			System.out.println(" <>=======() \n" + "(/\\___   /|\\\\          ()==========<>_\n"
					+ "      \\_/ | \\\\        //|\\   ______/ \\)\n" + "        \\_|  \\\\      // | \\_/\n"
					+ "          \\|\\/|\\_   //  /\\/\n" + "           (^\\^) \\_//  /\n"
					+ "          //_/\\_\\/ /  |      /\\/\\\n" + "         @@/  |=\\  \\  |      \\  /\n"
					+ "              \\_=\\_ \\ |       \\/\n" + "                \\==\\ \\|\\_\n"
					+ "             __(\\===\\(  )\\\n" + "            (((~) __(_/   |\n"
					+ "                 (((~) \\  /\n" + "                 ______/ /\n" + "                 '------'");
			return true;
		} else {
			return false;
		}
	}

	// Second Best Dragon Mood State
	public static boolean happyDragonGraphic(VirtualPet test) {
		if (test.petMood > 20 && test.petMood <= 40 && test.dayTime) {
			System.out.println(test.petName + " is in a good mood");
			System.out.println(" <>=======() \n" + "(/\\___   /|\\\\          ()==========<>_\n"
					+ "      \\_/ | \\\\        //|\\   ______/ \\)\n" + "        \\_|  \\\\      // | \\_/\n"
					+ "          \\|\\/|\\_   //  /\\/\n" + "           (^ ^) \\_//  /\n"
					+ "          //_/\\_\\/ /  |\n" + "         @@/  |=\\  \\  |\n" + "              \\_=\\_ \\ |\n"
					+ "                \\==\\ \\|\\_\n" + "             __(\\===\\(  )\\\n"
					+ "            (((~) __(_/   |\n" + "                 (((~) \\  /\n"
					+ "                 ______/ /\n" + "                 '------'");
			return true;
		} else {
			return false;
		}
	}

	// Middle Ground Dragon Mood State
	public static boolean normalDragonGraphic(VirtualPet test) {
		if (test.petMood > 40 && test.petMood <= 60 && test.dayTime) {
			System.out.println(test.petName + " seems melancholy");
			System.out.println(" <>=======() \n" + "(/\\___   /|\\\\          ()==========<>_\n"
					+ "      \\_/ | \\\\        //|\\   ______/ \\)\n" + "        \\_|  \\\\      // | \\_/\n"
					+ "          \\|\\/|\\_   //  /\\/\n" + "           (o o) \\_//  /\n"
					+ "          //_/\\_\\/ /  |\n" + "         @@/  |=\\  \\  |\n" + "              \\_=\\_ \\ |\n"
					+ "                \\==\\ \\|\\_\n" + "             __(\\===\\(  )\\\n"
					+ "            (((~) __(_/   |\n" + "                 (((~) \\  /\n"
					+ "                 ______/ /\n" + "                 '------'");
			return true;
		} else {
			return false;
		}
	}

	// Second Worst Dragon Mood State
	public static boolean sadDragonGraphic(VirtualPet test) {
		if (test.petMood > 60 && test.petMood <= 80 && test.dayTime) {
			System.out.println(test.petName + " looks sad");
			System.out.println(" <>=======() \n" + "(/\\___   /|\\\\          ()==========<>_\n"
					+ "      \\_/ | \\\\        //|\\   ______/ \\)\n" + "        \\_|  \\\\      // | \\_/\n"
					+ "          \\|\\/|\\_   //  /\\/\n" + "           (- -) \\_//  /\n"
					+ "          //_/\\_\\/ /  |\n" + "         @@/  |=\\  \\  |\n" + "              \\_=\\_ \\ |\n"
					+ "                \\==\\ \\|\\_\n" + "             __(\\===\\(  )\\\n"
					+ "            (((~) __(_/   |\n" + "                 (((~) \\  /\n"
					+ "                 ______/ /\n" + "                 '------'");
			return true;
		} else {
			return false;
		}
	}

	// Worst Dragon Mood State
	public static boolean angryDragonGraphic(VirtualPet test) {
		if (test.petMood > 80 && test.petMood <= 100 && test.dayTime) {
			System.out.println(test.petName + " is upset... and terrifying!");
			System.out.println(" <>=======() \n" + "(/\\___   /|\\\\          ()==========<>_\n"
					+ "      \\_/ | \\\\        //|\\   ______/ \\)\n" + "        \\_|  \\\\      // | \\_/\n"
					+ "          \\|\\/|\\_   //  /\\/\n" + "           (> <) \\_//  /\n"
					+ "          //_/\\_\\/ /  |\n" + "         @@/  |=\\  \\  |\n" + "              \\_=\\_ \\ |\n"
					+ "                \\==\\ \\|\\_\n" + "             __(\\===\\(  )\\\n"
					+ "            (((~) __(_/   |\n" + "                 (((~) \\  /\n"
					+ "                 ______/ /\n" + "                 '------'");
			return true;
		} else {
			return false;
		}
	}

	// Asleep Dragon Mood State
	// Again, learning how to make a State Machine would be cool as hell
	public static boolean asleepDragonGraphic(VirtualPet test) {
		if (!test.dayTime) {
			System.out.println(test.petName + " is asleep");
			System.out.println(" <>=======() \n" + "(/\\___   /|\\\\          ()==========<>_\n"
					+ "      \\_/ | \\\\        //|\\   ______/ \\)\n" + "        \\_|  \\\\      // | \\_/\n"
					+ "          \\|\\/|\\_   //  /\\/\n" + "           (_ _) \\_//  /\n"
					+ "          //_/\\_\\/ /  |\n" + "         @@/  |=\\  \\  |\n" + "              \\_=\\_ \\ |\n"
					+ "                \\==\\ \\|\\_\n" + "             __(\\===\\(  )\\\n"
					+ "            (((~) __(_/   |\n" + "                 (((~) \\  /\n"
					+ "                 ______/ /\n" + "                 '------'");
			return true;
		} else {
			return false;
		}
	}
}