import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {
    // Method to remove duplicates from an ArrayList of integers
    public static void removeDuplicate(ArrayList<Integer> list) {
        // Create a new ArrayList to store distinct integers
        ArrayList<Integer> distinctList = new ArrayList<>();
        
        // Iterate through the original list
        for (Integer number : list) {
            // If the distinct list doesn't already contain the number, add it
            if (!distinctList.contains(number)) {
                distinctList.add(number);
            }
        }
        
        // Clear the original list and add back distinct elements
        list.clear();
        list.addAll(distinctList);
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner input = new Scanner(System.in);
        
        // Create an ArrayList to store integers
        ArrayList<Integer> list = new ArrayList<>();
        
        // Prompt the user to enter 10 integers
        System.out.print("Enter ten integers: ");
        
        // Loop to add 10 integers to the list
        for (int i = 0; i < 10; i++) {
            list.add(input.nextInt());
        }
        
        // Call the method to remove duplicates
        removeDuplicate(list);
        
        // Display the distinct integers
        System.out.print("The distinct integers are: ");
        for (Integer number : list) {
            System.out.print(number + " ");
        }
    }
}
