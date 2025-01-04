class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> map=new HashSet<>(); 
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>0)k--;
                else if(sum<0)j++;
                else{
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                    map.add(list);
                    j++;
                    k--;
                    while(j<n&&nums[j]==nums[j-1])j++;
                    while(k>=0&&nums[k]==nums[k+1])k--;
                }
            }
        }
        for(List<Integer> ls : map)result.add(ls);
        return result;
    }
}