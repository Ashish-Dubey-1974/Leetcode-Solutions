class Solution {
    public int arrayPairSum(int[] nums) {
        int sum=0;
        boolean add=true;
        int[] count = new int[20001];
        for(int num : nums)count[num+10000]++;
        for(int i=0;i<20001;i++){
            while(count[i]>0){
                if(add)sum+=i-10000;
                add=!add;
                count[i]--;
            }
        }return sum;
    }
}