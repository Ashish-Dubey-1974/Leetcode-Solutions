class Solution {
    public void sortColors(int[] nums) {
        int[] re = new int[3];
        for(int i:nums)
        re[i]=re[i]+1;
        int idx=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<re[i];j++){
                nums[idx] = i;
                idx++;
            }
        }
    }
}