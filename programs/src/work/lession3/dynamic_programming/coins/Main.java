package work.lession3.dynamic_programming.coins;

import java.util.Arrays;

public class Main {
    static void numberOfWays(int[] coins, int k) {
        int len = coins.length;
        Arrays.sort(coins);
        int[][] solutions = new int[len][k + 1];

        // Initialize: there's 1 way to make 0 (using no coins)
        for (int i = 0; i < len; i++) {
            solutions[i][0] = 1;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                // Include ways excluding current coin
                int exclude = (i > 0) ? solutions[i - 1][j] : 0;

                // Include ways including current coin (if possible)
                int include = (j - coins[i] >= 0) ? solutions[i][j - coins[i]] : 0;

                solutions[i][j] = exclude + include;
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.print(coins[i] + " -> [");
            for (int j = 0; j <= k; j++) {
                System.out.printf("%3d, ", solutions[i][j]);
            }
            System.out.print(" ]");
            System.out.println();
        }
        System.out.println("Number of ways to make "+k+ " = " +solutions[len-1][k]);

    }
    static void minCoins(int[] coins, int k) {
        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 coins to make sum 0

        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
            System.out.println("coin "+coin+" -> "+Arrays.toString(dp));
        }

        if (dp[k] == Integer.MAX_VALUE) {
            System.out.println("It’s not possible to make sum " + k + " with given coins.");
        } else {
            System.out.println("Minimum number of coins to make " + k + " = " + dp[k]);
        }
        System.out.println("DP table: " + Arrays.toString(dp));
    }

    public static void main(String[] args) {
        numberOfWays(new int[]{3,2,5},11);
        minCoins(new int[]{1,3,5},10);
    }

}
