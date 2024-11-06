class Solution {
    public void nextPermutation(int[] nums) {
        
        int len = nums.length,idx=len-1;
        for(int i=len-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                for(int f=len-1;f>=i;f--){
                    if(nums[f]>nums[i-1]){
                        idx=f;
                        break;
                    }
                }
                //System.out.print(idx+" "+nums[i-1]);
                int temp = nums[i-1];
                nums[i-1]=nums[idx];
                nums[idx]=temp;
                len--;
                while(i<len){
                    int temp2=nums[i];
                    nums[i]=nums[len];
                    nums[len]=temp2;
                    i++;
                    len--;
                }
                return;
            }
        }
        for(int i=0;i<idx;i++){
            int temp = nums[i];
        nums[i]=nums[idx];
        nums[idx]=temp;
        idx--;
        }
       
    }
}