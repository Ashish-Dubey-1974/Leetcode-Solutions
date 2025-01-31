class Solution {
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0]=nums[0];
        suf[n-1] = nums[n-1];
        for(int i=1;i<n;i++)pre[i] = nums[i]>pre[i-1]?nums[i]:pre[i-1];
        for(int i=n-2;i>=0;i--)suf[i]=nums[i]<suf[i+1]?nums[i]:suf[i+1];
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(suf));
        for(int i=0;i<n;i++)if(pre[i]<=suf[i+1])return i+1;
        return -1;
    }
}