package Code;

public class FinancialForecaster {
    
    // Iterative
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    // Recursive
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) return presentValue;
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    // Memoized
    public static double calculateFutureValueMemoized(double presentValue, double growthRate, int periods) {
        double[] dp = new double[periods + 1];
        dp[0] = presentValue;
        for (int i = 1; i <= periods; i++) {
            dp[i] = dp[i - 1] * (1 + growthRate);
        }
        return dp[periods];
    }
}