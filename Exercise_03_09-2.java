/******************************************************************************

prompt user to enter first 9 digits of ISBN number
store into an integer variable number 
calculate checksum (last digit of ISBN) using the formula
checksum = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 +
            d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11
	IF checksum is 10 THEN
		append 'X' to the ISBN
	ELSE
		append checksum 

*******************************************************************************/
import java.util.Scanner;

public class Exercise_03_09 {
    public static void main(String[] args) {
        System.out.println("This code does not validate my input");
        System.out.println("This code does not catch or throw any exceptions explicitly!");

        // Prompt user to enter first 9 digits of the ISBN number
        System.out.print("Enter the first 9 digits of the ISBN as an integer: ");
        
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        // Extract each digit from the integer
        int d9 = number % 10;
        number /= 10;
        
        int d8 = number % 10;
        number /= 10;
        
        int d7 = number % 10;
        number /= 10;
        
        int d6 = number % 10;
        number /= 10;
        
        int d5 = number % 10;
        number /= 10;
        
        int d4 = number % 10;
        number /= 10;
        
        int d3 = number % 10;
        number /= 10;
        
        int d2 = number % 10;
        number /= 10;
        
        int d1 = number % 10;
        
        // Calculate the checksum using the formula
        int d10 = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;
        
        // Display the complete ISBN-10 number
        System.out.print("The ISBN-10 number is: ");
        
        if (d10 == 10) {
            // If checksum is 10, append 'X'
            System.out.println("" + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + "X");
        } else {
            // Otherwise, append the checksum as the 10th digit
            System.out.println("" + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10);
        }
    }
}

