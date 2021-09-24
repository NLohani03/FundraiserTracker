/*********************************************************************
 * Programmer Name: Nandita Lohani
 * Date: August 27, 2020
 * *******************************************************************
 * Purpose: A program that allows the user to select a school, the donation amount and 
 * the population of the school to generate the estimated donation amount 
 */

import javax.swing.JOptionPane;

public class FundRaising {
	//set public variables for easier access
	public static int schoolChoice = 0; 
	public static int donAmountChoice = 0; 
	public static int row = 4; 
	public static int col = 9;
	public static double donation[][] = new double[row][col];
	
	public static void main (String [] args) { 
		//create the 2D array
		createDonationArray();
		//ask for user input
		while(!(schoolChoice == 9)) { 
			schoolChoice = Integer.parseInt(JOptionPane.showInputDialog(
					"Which school is doing fundrasising?" 
			+ "\n0 - Catholic Central" 
			+ "\n1 - Holy Cross"
			+ "\n2 - John Paul II" 
			+ "\n3 - Mother Teresa"
			+ "\n4 - Regina Mundi" 
			+ "\n5 - St.Joseph" 
			+ "\n6 - St.Mary" 
			+ "\n7 - St.Thomas Aquinas" 
			+ "\n9 - EXIT"));
			
			if(schoolChoice == 9) {
				System.exit(0);
				
			} else if (schoolChoice > 9 ) { 
				System.out.println("Invalid Input!");
			}
			else if (schoolChoice == 8) {
				System.out.println("Invalid Input!");
				
			}else {
				donAmountChoice = Integer.parseInt(JOptionPane.showInputDialog(
						"What is the donation amount?"
				+ "\n0 - 25 cents"
			    + "\n1 - 50 cents"
			    + "\n2 - 1 dollar"
			    + "\n3 - 2 dollars"));  
					
			    if (donAmountChoice == 0) {
			    	int schoolPop1 = Integer.parseInt(JOptionPane.showInputDialog(
			    			"What is the school population?"));
			    	//calculate add the money to the specific location
			    	donation[donAmountChoice][schoolChoice] += 0.25 * schoolPop1; 
			    	
			    	//calculate the total money collected from quarters
			    	calcQuartTotal();
			    	
			    	//place the 2D array 
			    	printDonationArray();
				
			    } 
			    else if (donAmountChoice == 1) {
				    int schoolPop2 = Integer.parseInt(JOptionPane.showInputDialog(
				    		"What is the school population?"));
				    donation[donAmountChoice][schoolChoice] += 0.50 * schoolPop2; 
				   
				    //calculate the total money collected from fifty cents
				    calcFiftyCentTotal();
				    
				    printDonationArray();
				
			    }
			    else if (donAmountChoice == 2) {
				    int schoolPop3 = Integer.parseInt(JOptionPane.showInputDialog(
				    		"What is the school population?"));
				    donation[donAmountChoice][schoolChoice] += 1.00 * schoolPop3; 
				    
				    //calculate the total money collected from 1 dollar coins
				    calcLoonieTotal();

				    printDonationArray(); 
				
			    } 
			    else if (donAmountChoice == 3) {
				    int schoolPop4 = Integer.parseInt(JOptionPane.showInputDialog(
				    		"What is the school population?"));
				    donation[donAmountChoice][schoolChoice] += 2.00 * schoolPop4; 
				   
				    //calculate the total money collected from 2 dollar coins
				    calcToonieTotal();
				    
				    printDonationArray();
			   
			    } else {
			    	System.out.println("Invalid Input!");
			    }
		    }
	    }  
	}
	
	public static void createDonationArray() {
		
		//initialize the donation array to zeros
		for (int i = 0; i < 4; i++) { 
			for (int j = 0; j < 9; j++) { 
				donation[i][j] = 0;
			}
		}
		
		//display the 2D array in a table 
		System.out.println("\n==========================================="
				+ "=================================");
		System.out.println("      CatCen   HolyC   JPII   MotherT  "
				+ " RegM   StJoe   StMary   StThom  TOTAL");
		
		for (row = 0; row < 4; row++) {
			if (row == 0) {
				System.out.print("$0.25 -\t");
			} else if (row == 1) {
				System.out.print("$0.50 -\t");
			} else if (row == 2) {
				System.out.print("$1.00 -\t");
			} else if (row == 3) {
				System.out.print("$2.00 -\t");
			}
			for (int j = 0; j  < col; j++) {
				System.out.print(donation[row][j]);
				if (donation[row][j] < 1) { 
					System.out.print("\t");
				} else { 
					System.out.print(" \t");
				}
			}
			System.out.print("\n");
		}	
		
		double totalDonations = 0.0;
		//print the totals
		System.out.println("\nTOTAL DONATIONS: " + totalDonations);
					
	}
	
	public static void calcQuartTotal() {
		
		double totQuartDonations = 0;
		//add all the quarter donations and place it under the TOTAL column
		for (int j = 0; j < col - 1; j++){
			totQuartDonations = totQuartDonations + donation[row - 4][j];
			donation[0][8] = totQuartDonations;			
		}			
	}
	
	public static void calcFiftyCentTotal() {
		
		double totFiftyCentDonations = 0;
		//add all the fifty cent donations and place it under the TOTAL column
		for (int j = 0; j < col - 1; j++){
			totFiftyCentDonations = totFiftyCentDonations + donation[row - 3][j];
			donation[1][8] = totFiftyCentDonations;
		} 			
	}
	
	public static void calcLoonieTotal() {
		
		double totLoonieDonations = 0;
		
		//add all the 1 dollar donations and place it under the TOTAL column
		for (int j = 0; j < col - 1; j++){
			totLoonieDonations = totLoonieDonations + donation[row - 2][j];
			donation[2][8] = totLoonieDonations;
		}			
	}
	
	public static void calcToonieTotal() {
		
		double totToonieDonations = 0;
		
		//add all the 2 dollar donations and place it under the TOTAL column
		for (int j = 0; j < col - 1; j++){
			totToonieDonations = totToonieDonations + donation[row - 1][j];
			donation[3][8] = totToonieDonations;
		}			
	}
	
	public static void printDonationArray() {
		// display the results in a table using "\t"
		System.out.println("\n\n======================================="
				+ "=====================================");
		System.out.println("      CaCen   HolyC   JPII   MotherT   "
				+ "RegM   StJoe   StMary   StThom  TOTAL");
		
		for (row = 0; row < 4; row++) {
			if (row == 0) {
				System.out.print("$0.25 -\t");
			} else if (row == 1) {
			System.out.print("$0.50 -\t");
			} else if (row == 2) {
				System.out.print("$1.00 -\t");
			} else if (row == 3) {
				System.out.print("$2.00 -\t");
			}
			for (int j = 0; j  < col; j++) {
				System.out.print(donation[row][j]);
				if (donation[row][j] < 1) { 
					System.out.print("\t");
				} else { 
					System.out.print(" \t");
				}
			}
			System.out.print("\n");
		}
		
		//calculate the total donations
		double totalDonations = 0.0;
		
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col-1; j++){
				totalDonations = totalDonations + donation[i][j];
			}
	    }
		//print the totals
		System.out.println("\nTOTAL DONATIONS: " + totalDonations);
	}	
}

	
