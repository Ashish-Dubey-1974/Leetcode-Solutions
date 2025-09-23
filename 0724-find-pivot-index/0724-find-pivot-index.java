class Solution {
    public int pivotIndex(int[] nums) {
        int[] pSum = new int[nums.length];
        pSum[0] = nums[0];
        for(int i=1;i<nums.length;i++)pSum[i] = pSum[i-1]+nums[i];
        if(pSum[nums.length-1]-nums[0]==0)return 0;
        for(int i=1;i<nums.length;i++){
            if(pSum[i-1]==(pSum[nums.length-1]-pSum[i]))return i;
        }return -1;
    }
}