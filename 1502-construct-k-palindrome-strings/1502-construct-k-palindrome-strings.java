class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k)return false;
        int[] val = new int[26];
        for(char ch : s.toCharArray())val[ch-'a']++;
        int cnt=0;
        for(int i=0;i<26;i++){
            if(val[i]%2!=0)cnt++;
        }System.out.print(cnt);
        return cnt<=k;
    }
}