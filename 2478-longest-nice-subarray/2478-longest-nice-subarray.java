class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, mask = 0, maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            while ((mask & nums[right]) != 0) {
                mask ^= nums[left]; 
                left++;
            }
            mask |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
