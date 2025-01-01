class Solution {
    public int maxScore(String s) {
        int max=0;
        for(int i=1;i<s.length();i++){
            String s1 = s.substring(0,i);
            String s2 = s.substring(i);
            // System.out.print(s1+" "+s2);
            int l=0,r=0;
            for(int j : s1.toCharArray())if(j=='0')l++;
            for(int j : s2.toCharArray())if(j=='1')r++;
            max=max>l+r?max:l+r;
        }return max;
    }
}