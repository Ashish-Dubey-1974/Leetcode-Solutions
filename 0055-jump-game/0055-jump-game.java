class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i=0;i<nums.length;i++){
            if(i>reachable)return false;
            reachable = reachable>i+nums[i]?reachable:i+nums[i];
        }return true;
    }
}