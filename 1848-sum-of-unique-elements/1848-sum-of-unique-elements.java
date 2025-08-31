class Solution {
    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        for(int i=0;i<nums.length;i++)freq[nums[i]]++;
        int ans=0;
        for(int i=1;i<=100;i++)if(freq[i]==1)ans+=i;
        return ans;
    }
}