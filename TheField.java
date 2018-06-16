package theField;

import java.util.*;
import java.io.*;

public class TheField {

	public static void main(String[] args) {
		final int ROLLS = 1000000; // Total Rolls
		MultiDie die1 = new MultiDie(6); // "die" ranging from 1-6
		MultiDie die2 = new MultiDie(6); // need 2 to simulate real life
		int netBalance = 0; // holds balance, update for each roll 
		double balancePerRoll = 0; // holds balance per roll, calculated later
		int faceTotal; 
		
		for(int i = 0; i < ROLLS; i++) {
			die1.roll();
			die2.roll();
			faceTotal = die1.getFaceValue() + die2.getFaceValue();
			if(faceTotal == 3 | faceTotal == 4 | faceTotal == 9 
					| faceTotal == 10 | faceTotal == 11) {
				netBalance += 10;
			}
			else if(faceTotal == 2 | faceTotal == 12) {
				netBalance += 20;
			}
			else if(faceTotal == 5 | faceTotal == 6 | faceTotal == 7
					| faceTotal == 8){
				netBalance -= 10;
			}
		}
		balancePerRoll = (double)netBalance / ROLLS; // average balance per roll
		
		System.out.println("Net Balance is: "+ netBalance);
		System.out.println("Gain/Loss per roll is: "+ balancePerRoll);
	}

}
