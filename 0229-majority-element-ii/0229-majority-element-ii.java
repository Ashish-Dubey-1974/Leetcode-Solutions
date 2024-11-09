class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length/3;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==len+1)list.add(nums[i]);
        }
        return list;
    }
}