class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i :nums){
            int sum = sum(i);
            map.putIfAbsent(sum,new PriorityQueue<>(Collections.reverseOrder()));
            map.get(sum).add(i);
        }
        int max=-1;
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry : map.entrySet()){
            PriorityQueue<Integer> group = entry.getValue();
            if(group.size()>1){
                int currSum = group.remove();
                currSum+=group.remove();
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