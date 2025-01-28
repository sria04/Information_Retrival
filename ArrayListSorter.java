import java.util.ArrayList;

public class ArrayListSorter {

    // Method to sort an ArrayList of Numbers
    public static void sort(ArrayList<Number> list) {
        // Use Collections.sort() to sort the list
        // We need to convert each Number to its double value for sorting
        list.sort((n1, n2) -> Double.compare(n1.doubleValue(), n2.doubleValue()));
    }

    // Test the sort method
    public static void main(String[] args) {
        ArrayList<Number> numberList = new ArrayList<>();

        // Adding different types of numbers (Integer, Double, Float)
        numberList.add(5);
        numberList.add(3.2);
        numberList.add(10);
        numberList.add(4.5);
        numberList.add(7.7f);

        // Display the original list
        System.out.println("Original list: " + numberList);

        // Sort the list
        sort(numberList);

        // Display the sorted list
        System.out.println("Sorted list: " + numberList);
    }
}