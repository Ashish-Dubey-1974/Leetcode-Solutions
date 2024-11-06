import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int sum=0;
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i : nums)map.put(i,true);
        for(int i=0;i<nums.length;i++){
            int s=0;
            int no=nums[i];
            if(!map.containsKey(no-1))while(map.containsKey(no++))s++;
            if(sum<s)sum=s;
            //if(sum>nums.length-i)return sum;
        }return sum;
    }
}
