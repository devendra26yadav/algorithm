package work.lession3.dynamic_programming.sums;

public class Main {
    // maximum sum of non-adjacent elements
    static int maxNonAdjacentSum(int[] nums){
        int len =nums.length;
        if(len==0) return -1;
       int[] dp = new int[len];
       dp[0]=nums[0];
       dp[1] = Math.max(nums[0],nums[1]);
       for(int i=2;i<len;i++) {
           dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
       }
       return dp[len-1];
    }
    static int maxNonAdjacentSumOptimised(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            int curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 10, 7};
        System.out.println(maxNonAdjacentSum(nums));
        System.out.println("Using Space Optimised");
        System.out.println(maxNonAdjacentSumOptimised(nums));

    }

}
