package hangman;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] words = { "hangman", "bat", "java", "coding", "lesson", "python", "design", "graphic", "unity","unreal engine"};
		String word = words[new Random().nextInt(words.length)];
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

		while (cencored.contains("*") && count != 7) {

			System.out.println("Guess a letter: ");
			String line = scan.next().substring(0,1);;
			char letter = line.charAt(0);

			if (!word.contains(line) || cencored.contains(line)) {
				count++;
				System.out.println("False!");
			}

			for (int i = 0; i < word.length(); i++) {

				if (letter == word.charAt(i)) {
					cencored = cencored.substring(0, i) + letter + cencored.substring(i + 1);
				}

			}
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
