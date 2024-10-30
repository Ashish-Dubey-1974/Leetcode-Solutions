class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length+nums2.length];
        int i=0,j=0,idx=0;
        float x=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                res[idx++] = nums1[i];
                i++;
               
            }
            else{
                res[idx++] = nums2[j];
                j++;
            }
        }
        while(i<nums1.length){
            res[idx++] = nums1[i++];
        }
        while(j<nums2.length){
            res[idx++] = nums2[j++];
        }
        int len = res.length;
        if(len%2==0){
            
            x=((res[len/2]+(float)res[(len/2)-1])/2);
            return x;
        }else return (double)(res[len/2]);
    }
}