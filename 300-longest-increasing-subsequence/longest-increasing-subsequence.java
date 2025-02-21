class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int globalMax = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }
}