package salesreport;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] productNames = {"Single Mattress", "Double Mattress", "Queen Mattress"};
        String[] months = {"January", "February", "March"};

        int[][] monthlySales = new int[productNames.length][months.length];
        Scanner input = new Scanner(System.in);

        for (int product = 0; product < productNames.length; product++) {
            for (int month = 0; month < months.length; month++) {
                int sales = -1;

                while (sales < 0) {
                    System.out.print("Enter units sold for " + productNames[product]
                            + " in " + months[month] + ": ");

                    if (!input.hasNext()) {
                        input.close();
                        return;
                    }

                    if (input.hasNextInt()) {
                        sales = input.nextInt();
                    } else {
                        input.next();
                    }

                    if (sales < 0) {
                        System.out.println("Please enter a whole number of zero or more.");
                    }
                }

                monthlySales[product][month] = sales;
            }
        }

        input.close();
        System.out.println();

        Product product = new Product(productNames, monthlySales);
        PrintProduct printer = new PrintProduct(product);
        printer.printReport(productNames, months, monthlySales);
    }
}
