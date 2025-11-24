package work.D3.prob1a;

import java.util.*;

public class Subsetsum {
    // Function to check if a subset sum exists using DP
    public static boolean[][] subsetSumDP(int[] set, int sum) {
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (set[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp;
    }

    // Function to find all subsets that make up the target sum
    public static void findSubsets(int[] set, int n, int sum,
                                   List<Integer> current, boolean[][] dp,
                                   List<List<Integer>> allSolutions) {
        // Base conditions
        if (sum == 0) {
            allSolutions.add(new ArrayList<>(current));
            return;
        }
        if (n == 0)
            return;

        // Exclude the current element
        if (dp[n - 1][sum])
            findSubsets(set, n - 1, sum, current, dp, allSolutions);

        // Include the current element
        if (sum >= set[n - 1] && dp[n - 1][sum - set[n - 1]]) {
            current.add(set[n - 1]);
            findSubsets(set, n - 1, sum - set[n - 1], current, dp, allSolutions);
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int[] S = {3, 4, 7, 8};
        int K = 15;

        boolean[][] dp = subsetSumDP(S, K);
        int n = S.length;

        // (a) True or False
        System.out.println("(a) Subset with sum " + K + " exists: " + (dp[n][K] ? "True" : "False"));

        if (!dp[n][K]) {
            System.out.println("No subsets found.");
            return;
        }

        // (b) One solution
        List<List<Integer>> allSolutions = new ArrayList<>();
        findSubsets(S, n, K, new ArrayList<>(), dp, allSolutions);

        System.out.println("(b) One solution: " + allSolutions.get(0));

        // (c) All solutions
        System.out.print("(c) All solutions: ");
        for (List<Integer> subset : allSolutions)
            System.out.print(subset+", ");
    }
}
