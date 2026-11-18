package salesreport;

public class Product implements IProduct {
    private final String[] productNames;
    private final int[][] monthlySales;

    public Product(String[] productNames, int[][] monthlySales) {
        this.productNames = productNames;
        this.monthlySales = monthlySales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;

        for (int product = 0; product < productNames.length; product++) {
            total += getProductTotal(product);
        }

        return total;
    }

    @Override
    public double GetAverageProductSold() {
        return (double) GetTotalProductsSold() / productNames.length;
    }
    // Finds the most popular product based on the total sales for each product
    @Override
    public String GetMostPopularProduct() {
        int mostPopularIndex = 0;
        int highestTotal = getProductTotal(0);

        for (int product = 1; product < productNames.length; product++) {
            int total = getProductTotal(product);

            if (total > highestTotal) {
                highestTotal = total;
                mostPopularIndex = product;
            }
        }

        return productNames[mostPopularIndex];
    }

    int getProductTotal(int productIndex) {
        int total = 0;

        for (int sales : monthlySales[productIndex]) {
            total += sales;
        }

        return total;
    }
}
