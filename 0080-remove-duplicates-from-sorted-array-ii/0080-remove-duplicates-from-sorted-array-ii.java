class Solution {
    public int removeDuplicates(int[] nums) {
        int idx=2;
        if(nums.length<3)return nums.length;
        for(int i=2;i<nums.length;i++){
            if(nums[idx-2]!=nums[i])nums[idx++]=nums[i];
        }
        System.out.print(idx);
        return idx;
    }
}