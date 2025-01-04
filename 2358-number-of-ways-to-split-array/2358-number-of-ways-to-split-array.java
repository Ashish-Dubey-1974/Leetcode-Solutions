class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans = 0;
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n - 1; i++) { 
            long leftSum = prefixSum[i];
            long rightSum = prefixSum[n - 1] - prefixSum[i];
            if (leftSum >= rightSum) {
                ans++;
            }
        }

        return ans;
    }
}
