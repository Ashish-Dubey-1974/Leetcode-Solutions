class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> map=new HashSet<>(); 
        int k=nums.length;
        for(int i=0;i<k-2;i++){
            Set<Integer> map2 = new HashSet<>();
            for(int j=i+2;j<k;j++){
                map2.add(nums[j-1]);
                if(map2.contains(-(nums[i]+nums[j]))){
                    List<Integer> list = new ArrayList<>();
                    int m = -(nums[i]+nums[j]);
                   if(nums[i]>=nums[j]&&nums[i]>=m){list.add(nums[i]);if(nums[j]>m){list.add(nums[j]);list.add(m);}else{list.add(m);list.add(nums[j]);}}
                    else if(nums[j]>=nums[i]&&nums[j]>=m){list.add(nums[j]);if(nums[i]>m){list.add(nums[i]);list.add(m);}else{list.add(m);list.add(nums[i]);}}
                    else if(m>=nums[i]&&m>=nums[j]){list.add(m);if(nums[i]>nums[j]){list.add(nums[i]);list.add(nums[j]);}else{list.add(nums[j]);list.add(nums[i]);}}
                    map.add(list);
                }
            }          
        }
        for(List<Integer> ls : map)result.add(ls);
        return result;
    }
}