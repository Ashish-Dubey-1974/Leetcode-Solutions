class Solution {
    public int minimumLength(String s) {
        int sum=0;
        int[] arr1 = new int[26];
        for(int i=0;i<s.length();i++)arr1[s.charAt(i)-'a']++;
        for(int i:arr1){
            if(i==0)continue;
            else if(i%2==0)sum+=2;
            else sum++;
        }
        return sum;
    }
}