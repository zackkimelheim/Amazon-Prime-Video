
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

public class TestInventory {

	public static void main(String[] args) throws FileNotFoundException {
		Inventory inv = new Inventory();
		File file = new File("src/movies_db.txt");

		try {
			Scanner fileInput = new Scanner(file);
			int lineCounter = 0;
			while (fileInput.hasNextLine()) {
				String line = fileInput.nextLine();
				// split up the line based on our delimiter
				// (in this case it's the '-' character)
				String[] splitLine = line.split("-");

				if (splitLine[4].equals("Action")) {
					String title = splitLine[0];
					int year = Integer.parseInt(splitLine[1]);
					int duration = Integer.parseInt(splitLine[2]);
					double rating = Double.parseDouble(splitLine[3]);
					int explosions = Integer.parseInt(splitLine[5]);

					Movie newMovie = new Action(title, year, duration, rating, explosions);
					inv.add(newMovie);
				}
				if (splitLine[4].equals("RomCom")) {
					String title = splitLine[0];
					int year = Integer.parseInt(splitLine[1]);
					int duration = Integer.parseInt(splitLine[2]);
					double rating = Double.parseDouble(splitLine[3]);
					int jerks = Integer.parseInt(splitLine[5]);
					int friendzones = Integer.parseInt(splitLine[6]);

					Movie newMovie = new RomCom(title, year, duration, rating, jerks, friendzones);
					inv.add(newMovie);
				}
				lineCounter ++;
			}
		fileInput.close();

		} catch (FileNotFoundException e) {
			System.out.println("Cannot open file. Sorry");
		}

		// TODO: Read in the input file and populate the movieList. Manage
		// exceptions.
		// On a failed movie load print the message
		// "Exception " + e.getMessage() + " for film " + title. No loading."

		System.out.println("Inventory should now contain file contents.");
		System.out.println(inv.toString());

		Movie starWars = new Action("Star Wars - A New Hope", 1977, 121, 3.8, 89);
		inv.add(starWars);

		Movie numberFour = new Action("I Am Number Four", 2011, 101, 3.2, 11);
		inv.add(numberFour);

		Movie someoneLikeYou = new RomCom("Someone Like You", 2011, 101, 3.2, 2, 5);
		inv.add(someoneLikeYou);

		Movie crazyStupidLove = new RomCom("Crazy, Stupid, Love 2", 2013, 113, 3.9, 1, 3);
		inv.add(crazyStupidLove);

		System.out.println("Inventory should now contain 13 movies. " + (inv.size() == 13));

		if (inv.remove(crazyStupidLove.getTitle(), crazyStupidLove.getYearReleased())) {
			System.out.println("Successfully removed 'Crazy, Stupid, Love'");
			if (!inv.remove(crazyStupidLove.getTitle(), crazyStupidLove.getYearReleased())) {
				System.out.println("Successfully ignored second remove attempt for 'Crazy, Stupid, Love'");
			}
		}

		try {
			inv.add(new RomCom("27 Dresses", 2008, 103, 4.4, 1, 1));
		} catch (IllegalArgumentException e) {
			System.out.println("Successfully threw exception on invalid parameter.");
		}

		try {
			inv.add(someoneLikeYou);
		} catch (MovieInventoryException e) {
			System.out.println("Successfully threw exception on duplicate add attempt.");
		}

		System.out.println("Inventory should now contain 12 movies. " + (inv.size() == 12));

		System.out.println("Inventory should not contain 'The Matrix'? " + !inv.contains("The Matrix", 1999));
		System.out.println(
				"Inventory should not contain 'Something Borrowed'? " + !inv.contains("Something Borrowed", 2009));
		System.out.println("Inventory should not contain '27 Dressed'? " + !inv.contains("27 Dressed", 2008));

		System.out.println("\n" + inv.toString());
	}

}
