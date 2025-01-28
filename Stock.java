// Stock.java
public class Stock {
    // Data fields
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    // Constructor
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    // Method to set the previous closing price
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    // Method to set the current price
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    // Method to calculate the percentage change
    public double getChangePercent() {
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }

    // Getters for symbol and name (optional, if needed)
    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}

// StockTest.java
public class StockTest {
    public static void main(String[] args) {
        // Create a Stock object for Oracle Corporation
        Stock oracle = new Stock("ORCL", "Oracle Corporation");

        // Set the previous closing price
        oracle.setPreviousClosingPrice(34.5);

        // Set the current price
        oracle.setCurrentPrice(34.35);

        // Display the price-change percentage
        System.out.printf("Price-change percentage for %s (%s): %.2f%%\n", 
                          oracle.getName(), oracle.getSymbol(), oracle.getChangePercent());
    }
}
