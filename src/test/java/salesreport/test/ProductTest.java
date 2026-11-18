package salesreport.test;

import org.junit.jupiter.api.Test;
import salesreport.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    private final Product product = new Product(
        new String[]{"Single Mattress", "Double Mattress", "Queen Mattress"},
        new int[][]{
            {10, 12, 13},
            {20, 22, 24},
            {14, 17, 19}
        }
    );
    // Tests the GetMostPopularProduct method of the Product class
    @Test
    void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(151, product.GetTotalProductsSold());
    }

    @Test
    void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(50.333333, product.GetAverageProductSold(), 0.000001);
    }
}
