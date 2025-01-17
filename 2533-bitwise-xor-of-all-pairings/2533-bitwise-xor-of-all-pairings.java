class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int val=0;
        if(nums1.length%2!=0 && nums2.length%2!=0){
            for(int i :nums1)
            val^=i;
            for(int i :nums2)
            val^=i;
            return val;
        }else if(nums1.length%2!=0){
            for(int i :nums2)
            val^=i;
            return val;
        }else if(nums2.length%2!=0){
            for(int i :nums1)
            val^=i;
            return val;
        }
        return val;
    }
}