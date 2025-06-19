import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        // Sample
        Product[] products = {
            new Product("P100", "Laptop", "Electronics", 999.99),
            new Product("P200", "Smartphone", "Electronics", 699.99),
            new Product("P300", "Desk Chair", "Furniture", 199.99),
            new Product("P400", "Coffee Maker", "Appliances", 49.99)
        };
        
        // Linear Search
        System.out.println("Linear Search Results:");
        Product laptop = LinearSearch.searchByName(products, "laptop");
        System.out.println("Found: " + laptop);
        
        // Binary Search
        System.out.println("\nBinary Search Results:");
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
        Product p200 = BinarySearch.searchById(products, "P200");
        System.out.println("Found: " + p200);
        
        int largeSize = 1000000;
        Product[] largeArray = generateLargeArray(largeSize);
        
        System.out.println("\nPerformance Comparison (" + largeSize + " items):");
        long start, end;
        
        // Linear Search Time
        start = System.nanoTime();
        LinearSearch.searchById(largeArray, "P" + (largeSize - 1));
        end = System.nanoTime();
        System.out.println("Linear Search Time: " + (end - start) + " ns");
        
        // Binary Search Time
        start = System.nanoTime();
        Arrays.sort(largeArray, Comparator.comparing(Product::getProductId));
        BinarySearch.searchById(largeArray, "P" + (largeSize - 1));
        end = System.nanoTime();
        System.out.println("Binary Search Time (with sort): " + (end - start) + " ns");
        
        // Binary Search Time (pre-sorted)
        start = System.nanoTime();
        BinarySearch.searchById(largeArray, "P" + (largeSize - 1));
        end = System.nanoTime();
        System.out.println("Binary Search Time (pre-sorted): " + (end - start) + " ns");
    }
    
    private static Product[] generateLargeArray(int size) {
        Product[] arr = new Product[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Product("P" + i, "Product " + i, "Category " + (i % 10), i * 10);
        }
        return arr;
    }
}