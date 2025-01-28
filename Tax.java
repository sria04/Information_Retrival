public class Tax {
    // Constants for filing status
    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus;
    private int[][] brackets;
    private double[] rates;
    private double taxableIncome;

    // No-arg constructor
    public Tax() {
        this.filingStatus = SINGLE_FILER;
        this.brackets = new int[4][];
        this.rates = new double[0];
        this.taxableIncome = 0;
    }

    // Constructor with parameters
    public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    // Getter and setter for filingStatus
    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    // Getter and setter for brackets
    public int[][] getBrackets() {
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    // Getter and setter for rates
    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    // Getter and setter for taxableIncome
    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    // Method to calculate tax
    public double getTax() {
        double tax = 0;
        int[] bracket = brackets[filingStatus];

        if (taxableIncome <= bracket[0]) {
            return taxableIncome * rates[0];
        }

        tax += bracket[0] * rates[0];

        for (int i = 1; i < bracket.length; i++) {
            if (taxableIncome > bracket[i]) {
                tax += (bracket[i] - bracket[i - 1]) * rates[i];
            } else {
                tax += (taxableIncome - bracket[i - 1]) * rates[i];
                break;
            }
        }

        if (taxableIncome > bracket[bracket.length - 1]) {
            tax += (taxableIncome - bracket[bracket.length - 1]) * rates[rates.length - 1];
        }

        return tax;
    }
}

class TestTax {
    public static void main(String[] args) {
        // 2001 tax brackets
        int[][] brackets2001 = {
            {27050, 65550, 136750, 297350},
            {45200, 109250, 166500, 297350},
            {22600, 54625, 83250, 148675},
            {36250, 93650, 151650, 297350}
        };

        double[] rates2001 = {0.15, 0.275, 0.305, 0.355, 0.391};

        // Test for different statuses with taxable income $50,000 to $60,000
        for (int income = 50000; income <= 60000; income += 1000) {
            for (int status = 0; status <= 3; status++) {
                Tax tax2001 = new Tax(status, brackets2001, rates2001, income);
                System.out.println("For status " + status + " with income " + income + ", tax is: " + tax2001.getTax());
            }
        }
    }
}
