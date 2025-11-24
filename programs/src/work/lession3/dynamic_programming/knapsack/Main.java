package work.lession3.dynamic_programming.knapsack;

public class Main {
    // Function to solve 0/1 Knapsack and print DP table
    public static int knapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Print the DP table
        System.out.println("DP Table:");
        System.out.print("\t->");
        for (int i=0;i<=W;i++){
            System.out.printf("%4d",i);
        }
        System.out.println();
        for (int i = 0; i <= n; i++) {
            if (i <= weights.length && i>0) {
                System.out.printf("(%d,%d)",weights[i-1],values[i-1]);
            }else System.out.print("(0,0) ");
            for (int w = 0; w <= W; w++) {
                System.out.printf("%4d",dp[i][w]);
            }
            System.out.println();
        }

        return dp[n][W]; // Maximum value
    }

    public static void main(String[] args) {
        int[] values = {25, 12, 24, 16, 28};
        int[] weights = {5, 6, 8, 2, 7};
        int W = 20;

//        int[] values = {12,63,84,91,84};
//        int[] weights = {4, 8, 11, 6, 3};
//        int W = 15;

        int maxValue = knapsack(values, weights, W);
        System.out.println("Maximum value = " + maxValue);
        System.out.println("By sorting weights 1");
        System.out.println("Maximum value = " +knapsack(new int[]{16,25,12,28,24},new int[]{2,5,6,7,8},20));
        System.out.println("By sorting weights 2");
        System.out.println("Maximum value = " +knapsack(new int[]{16,25,12,28,24},new int[]{2,5,6,7,8},22));

    }
}
