package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println();

		Scanner scan = new Scanner(System.in);
		Scanner reader = new Scanner(new File("C:\\Users\\mtepe\\OneDrive\\Masaüstü\\words.txt"));
		List<String> words = new ArrayList<>();
		
		while (reader.hasNextLine()) {
			words.add(reader.nextLine());
		}
		
		String word = words.get(new Random().nextInt(words.size()));
		String cencored = "";

		for (int i = 0; i < word.length(); i++) {

			if (word.charAt(i) == ' ') {
				cencored = cencored + " ";
			} else {
				cencored = cencored + "*";
			}

		}
		System.out.println(cencored);

		int count = 0;

		while (cencored.contains("*") && count != 6) {

			System.out.println("Guess a letter: ");
			String line = scan.next().substring(0, 1);
			char letter = line.charAt(0);

			if (!word.contains(line) || cencored.contains(line)) {
				count++;
				System.out.println("False!");
			}

			if (count >= 1) {
				System.out.println("------------");
				System.out.println(" |         |");
				System.out.println(" O");
			}

			if (count >= 2) {
				System.out.print("\\ ");
			}
			if (count >= 3) {
				System.out.print("/" + "\n");
			}
			if (count >= 4) {
				System.out.println(" |");
			}
			if (count >= 5) {
				System.out.print("/ ");
			}
			if (count >= 6) {
				System.out.print("\\");
			}

			for (int i = 0; i < word.length(); i++) {

				if (letter == word.charAt(i)) {
					cencored = cencored.substring(0, i) + letter + cencored.substring(i + 1);
				}

			}
			System.out.println();
			System.out.println(cencored);

		}

		if (cencored.contains("*")) {
			System.out.println("You've failed to find the word " + word);
		}

		else {
			System.out.println("You've succeed in finding the word " + word);
		}

		scan.close();

	}

}
