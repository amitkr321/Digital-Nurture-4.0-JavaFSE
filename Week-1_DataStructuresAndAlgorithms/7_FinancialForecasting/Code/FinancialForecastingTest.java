package Code;
public class FinancialForecastingTest {
    public static void main(String[] args) {
        double initialInvestment = 1000.0;
        double annualGrowthRate = 0.05; // 5%
        int years = 10;
        
        // Basic recursion
        double futureValue = FinancialForecaster.calculateFutureValue(
            initialInvestment, annualGrowthRate, years);
        System.out.printf("Basic recursive: $%.2f after %d years\n", futureValue, years);
        
        // Variable growth rates
        // double[] variableRates = {0.05, 0.06, 0.04, 0.07, 0.03};
        // double variableFutureValue = FinancialForecaster.calculateFutureValue(
        //     initialInvestment, variableRates, 0);
        // System.out.printf("Variable rates: $%.2f after %d years\n", 
        //     variableFutureValue, variableRates.length);
        
        // Memoized
        double memoizedFutureValue = FinancialForecaster.calculateFutureValueMemoized(
            initialInvestment, annualGrowthRate, years);
        System.out.printf("Memoized recursive: $%.2f after %d years\n", 
            memoizedFutureValue, years);
            
        // Iterative
        double iterativeFutureValue = FinancialForecaster.calculateFutureValueIterative(
            initialInvestment, annualGrowthRate, years);
        System.out.printf("Iterative: $%.2f after %d years\n", 
            iterativeFutureValue, years);
        
        int largeYears = 10000;
        
        long start = System.nanoTime();
        FinancialForecaster.calculateFutureValueIterative(initialInvestment, annualGrowthRate, largeYears);
        long end = System.nanoTime();
        System.out.println("Iterative time: " + (end - start) + " ns");
        
        start = System.nanoTime();
        FinancialForecaster.calculateFutureValueMemoized(initialInvestment, annualGrowthRate, largeYears);
        end = System.nanoTime();
        System.out.println("Memoized recursive time: " + (end - start) + " ns");
    }
}
