import java.util.ArrayList;
import java.util.Scanner;

class MyStack extends ArrayList<String> {
    
    // Push method to add an item to the stack
    public void push(String item) {
        this.add(item); // Add item to the end of the ArrayList
    }

    // Pop method to remove and return the top item from the stack
    public String pop() {
        if (!isEmpty()) {
            return this.remove(size() - 1); // Remove and return the last item
        }
        return null; // Return null if stack is empty
    }

    // Peek method to return the top item without removing it
    public String peek() {
        if (!isEmpty()) {
            return this.get(size() - 1); // Get the last item
        }
        return null; // Return null if stack is empty
    }

    // Check if the stack is empty
    @Override
    public boolean isEmpty() {
        return size() == 0; // Return true if size is 0
    }

    // Get the size of the stack
    @Override
    public int size() {
        return super.size(); // Use the size method from ArrayList
    }
}

public class StackTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack stack = new MyStack();

        // Prompt user for input
        System.out.println("Enter five strings:");
        for (int i = 0; i < 5; i++) {
            String input = scanner.nextLine();
            stack.push(input); // Push input to the stack
        }

        // Display strings in reverse order
        System.out.println("The strings in reverse order are:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // Pop and display each string
        }

        scanner.close();
    }
}
