class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i :nums){
            int sum = sum(i);
            map.putIfAbsent(sum,new ArrayList<>());
            map.get(sum).add(i);
        }
        int max=-1;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> group = entry.getValue();
            if(group.size()>1){
                Collections.sort(group,Collections.reverseOrder());
                int currSum = group.get(0)+group.get(1);
                max=max>currSum?max:currSum;
            }
        }return max;
    }
    int sum(int n){
            int sum=0;
            while(n!=0){
                sum+=n%10;
                n/=10;
            }
            return sum;
        }
}