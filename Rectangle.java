public class Rectangle {
    // Data fields
    private double width;
    private double height;

    // No-arg constructor (default constructor)
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    // Constructor with specified width and height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Setter for width
    public void setWidth(double width) {
        this.width = width;
    }

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(double height) {
        this.height = height;
    }

    // Method to calculate the area of the rectangle
    public double getArea() {
        return width * height;
    }

    // Method to calculate the perimeter of the rectangle
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Override toString() method to return string representation of the rectangle
    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height + "]";
    }

    // Override equals() method to compare two rectangles
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            return this.width == other.width && this.height == other.height;
        }
        return false;
    }

    public static void main(String[] args) {
        // Create two Rectangle objects
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        // Display the width, height, area, and perimeter of the first rectangle
        System.out.println("Rectangle 1:");
        System.out.println("Width: " + rectangle1.getWidth());
        System.out.println("Height: " + rectangle1.getHeight());
        System.out.println("Area: " + rectangle1.getArea());
        System.out.println("Perimeter: " + rectangle1.getPerimeter());
        System.out.println(rectangle1.toString());

        // Display the width, height, area, and perimeter of the second rectangle
        System.out.println("\nRectangle 2:");
        System.out.println("Width: " + rectangle2.getWidth());
        System.out.println("Height: " + rectangle2.getHeight());
        System.out.println("Area: " + rectangle2.getArea());
        System.out.println("Perimeter: " + rectangle2.getPerimeter());
        System.out.println(rectangle2.toString());

        // Check if the two rectangles are equal
        System.out.println("\nAre the two rectangles equal? " + rectangle1.equals(rectangle2));
    }
}
