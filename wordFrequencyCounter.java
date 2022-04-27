/* 
 * Tim Rainey
 * 4/1/2022
 * Word Frequency Counter
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class wordFrequencyCounter {
	
	private Scanner scan = null;

	private Scanner file = null;

	private ArrayList<String> words = null;
	
	private ArrayList<Integer> counts = null;

	// parameterized constructor
	public wordFrequencyCounter(String filename) throws FileNotFoundException {
		
		// scanner object to get inputs from the user
		this.scan = new Scanner(System.in);
		
		this.file = new Scanner(new File(filename));
		
		this.words = new ArrayList<String>();
		
		this.counts = new ArrayList<Integer>();
	}

	private void counting() {
		
		String str;
		
		String s = "";
		
		while (file.hasNext()) {
			s = "";
			str = file.next();
			
			for (int i = 0; i < str.length(); i++) {
				
				if (Character.isAlphabetic(str.charAt(i))) {
					s += str.charAt(i);
				}
			}
			if (!words.contains(s)) {
				words.add(s);
				counts.add(1);
			} else {
				int indx = words.indexOf(str);
				counts.set(indx, counts.get(indx) + 1);
			}
		}

		file.close();

		// Sorts elements in ascending order
		int temp;
		
		String wtemp;
		
		for (int i = 0; i < words.size(); i++) {
			
			for (int j = i + 1; j < words.size(); j++) {
				
				if (words.get(i).compareTo(words.get(j)) > 0) {
					wtemp = words.get(i);
					words.set(i, words.get(j));
					words.set(j, wtemp);

					temp = counts.get(i);
					counts.set(i, counts.get(j));
					counts.set(j, temp);

				}
			}
		}
	}

	private void displayCount() {
		
		System.out.println(" Count\tWord");
		
		System.out.println(" -----\t----");

		for (int i = 0; i < words.size(); i++) {
			
			System.out.printf("%6d %-10s\n", counts.get(i), words.get(i));
		}
	}

	public void countWords() {
		
		counting();
		
		displayCount();
	}

}
