import java.util.Scanner;

public class QuadraticEquation {
    // Private data fields
    private double a;
    private double b;
    private double c;

    // Constructor
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Getter for 'a'
    public double getA() {
        return a;
    }

    // Getter for 'b'
    public double getB() {
        return b;
    }

    // Getter for 'c'
    public double getC() {
        return c;
    }

    // Method to calculate the discriminant
    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    // Method to calculate the first root
    public double getRoot1() {
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return 0;
        } else {
            return (-b + Math.sqrt(discriminant)) / (2 * a);
        }
    }

    // Method to calculate the second root
    public double getRoot2() {
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return 0;
        } else {
            return (-b - Math.sqrt(discriminant)) / (2 * a);
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create Scanner object for input
        Scanner input = new Scanner(System.in);

        // Prompt user for the coefficients
        System.out.print("Enter coefficient a: ");
        double a = input.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = input.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = input.nextDouble();

        // Create an instance of QuadraticEquation
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        // Get the discriminant
        double discriminant = equation.getDiscriminant();

        // Check the discriminant and display the results
        if (discriminant > 0) {
            System.out.println("The equation has two roots: " + equation.getRoot1() + " and " + equation.getRoot2());
        } else if (discriminant == 0) {
            System.out.println("The equation has one root: " + equation.getRoot1());
        } else {
            System.out.println("The equation has no real roots.");
        }
        
        // Close scanner
        input.close();
    }
}
