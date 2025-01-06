class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> ls = new ArrayList<>();
        int n = boxes.length();
        int[] ans = new int[n];
        for(int i=0;i<n;i++)if(boxes.charAt(i)=='1')ls.add(i);
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<ls.size();j++){
                sum += Math.abs(ls.get(j)-i);
            }
            ans[i]=sum;
        }return ans;
    }
}