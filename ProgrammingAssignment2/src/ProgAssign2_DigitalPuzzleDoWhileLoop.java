/* Description: This program reads a 10 digit number entered by the user, validates that each number 0 - 9 appears once in the number entered
 * 				and that the number is a 10 digits long. If valid, the program prompts the user to re-enter a valid number. Once valid, the 
 * 				program determines the number of divisions possible for where the divisor n equals the left most n digits. The number of divisions
 * 				is displayed on the console. 
 * Author: Jeremy Reinert
 * Date: 10/23/2018
 * Version: 1.0
 * 
 * STEP 1: Prompt user and read 10 digit number input and set to numberInput
 * STEP 2: Validate input - 
 * 		2a: Must be 10 digit #
 * 		2b: Must contain numbers 0 - 9 exactly once
 * 		2c: If invalid, prompt user to reenter a valid number
 * STEP 3: Determine number of divisions possible and display to console
 * 		3a: firstDigit % 1 == 0, firstTwoDigits % 2 == 0, firstThreeDigits % 3 == 0, .... allTenDigits % 10 == 0 
 */

//Import scanner library
import java.util.Scanner;
public class ProgAssign2_DigitalPuzzleDoWhileLoop {
	public static void main(String[] args) {
		// Variable declaration
		Scanner input = new Scanner(System.in);
		long numberInput, numberInputCopy, numberInputCopy2, isDivisible;
		int countZeroes, countOnes, countTwos, countThrees, countFours, countFives, countSixes, countSevens, countEights, countNines, digitCount, divisibleCount;
		
		// Initialize variables
		countZeroes = countOnes = countTwos = countThrees = countFours = countFives = countSixes = countSevens = countEights = countNines = 0;
		digitCount = 0;
		numberInputCopy = 0;
		numberInputCopy2 = 0;
		isDivisible = 0;
		divisibleCount = 0;
		
		// STEP 1: Prompt user and read 10 digit number input
		System.out.println("Please enter a 10 digit number that contains the numbers 0 - 9. Each number 0 - 9 should only be used once in the 10 digit number.");
		numberInput = input.nextLong();
		numberInputCopy = numberInputCopy2 = numberInput; // Copies of numberInput for removing digits from the integer
		
		// STEP 2: Validate input
		do {
			// Reset counts for each possible integer to 0 for loop through
			countZeroes = countOnes = countTwos = countThrees = countFours = countFives = countSixes = countSevens = countEights = countNines = 0;
			digitCount = 0;
		
			while(numberInputCopy != 0) {
				numberInputCopy2 = numberInputCopy % 10;
				numberInputCopy /= 10;
											
				switch((int)numberInputCopy2) {
				case 0: countZeroes++;
						digitCount++;
						break;
				case 1: countOnes++;
						digitCount++;
						break;
				case 2: countTwos++;
						digitCount++;
						break;
				case 3: countThrees++;
						digitCount++;
						break;
				case 4: countFours++;
						digitCount++;
						break;
				case 5: countFives++;
						digitCount++;
						break;
				case 6: countSixes++;
						digitCount++;
						break;
				case 7: countSevens++;
						digitCount++;
						break;
				case 8: countEights++;
						digitCount++;
						break;
				case 9: countNines++;
						digitCount++;
						break;
				}
				
			}
			
			if (digitCount == 10 && countZeroes == 1 && countOnes == 1 && countTwos == 1 && 
				countThrees == 1 && countFours == 1 && countFives == 1 && countSixes == 1 && 
				countSevens == 1 && countEights == 1 && countNines == 1) {
				System.out.println("You entered a valid 10 digit number.");
			} else {
				System.out.println("The number you entered was not a valid number.");
				System.out.println("Please reenter a 10 digit number that contains the numbers 0 - 9. Each number 0 - 9 should only be used once in the 10 digit number.");
				numberInputCopy = numberInput = input.nextLong();
			}			
			
		} 
		while(numberInputCopy != 0);
		
		// STEP 3: Determine number of divisions possible and display to console
		do {
			isDivisible = numberInput % digitCount;
			numberInput /= 10;
			
			switch ((int)isDivisible) {
			case 0: divisibleCount++;
					break;
			}
			digitCount--;
		}
		while (numberInput != 0);
		
		System.out.println("There were " + divisibleCount + " divisions that were performed on the number you entered where the leftmost n digits is divisible by n.");
	
				
		// Close the scanner
		input.close();
	}

}
