package salesreport;

public class PrintProduct {
    private final Product product;

    public PrintProduct(Product product) {
        this.product = product;
    }
    // prints the sales report in a formatted table with product names, monthly sales, and total sales for each product
    public void printReport(String[] productNames, String[] months, int[][] monthlySales) {
        System.out.println("MATTRESS SALES REPORT");
        System.out.println();

        System.out.printf("%-24s", "Product");
        for (String month : months) {
            System.out.printf("%11s", month);
        }
        System.out.printf("%11s%n", "Total");

        for (int row = 0; row < productNames.length; row++) {
            System.out.printf("%-24s", productNames[row]);
            for (int sales : monthlySales[row]) {
                System.out.printf("%11d", sales);
            }
            System.out.printf("%11d%n", product.getProductTotal(row));
        }

        System.out.println();
        printTotalProductSales();
        printAverageProductSales();
        printMostPopularProductSale();
    }

    public void printTotalProductSales() {
        System.out.println("Total products sold: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales() {
        System.out.printf("Average units sold per product: %.2f%n", product.GetAverageProductSold());
    }

    public void printMostPopularProductSale() {
        System.out.println("Most popular product: " + product.GetMostPopularProduct());
    }
}
