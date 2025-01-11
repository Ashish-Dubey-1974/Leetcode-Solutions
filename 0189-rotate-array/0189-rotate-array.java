class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k = k%n;
        int[] num = new int[n]; 
        for(int i=0,j=n-k;i<n;i++,j++){
            if(j>=n)j=0;
            num[i]=nums[j];
        }
        for(int i=0;i<n;i++)nums[i]=num[i];
    }
}