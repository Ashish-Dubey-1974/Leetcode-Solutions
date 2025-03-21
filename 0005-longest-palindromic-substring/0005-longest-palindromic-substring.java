class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String ans=s.charAt(0)+"";
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                String s1 = s.substring(i,j+1);
                if(check(s1)){
                    if(s1.length()>ans.length())ans=s1;
                }
            }
        }return ans;
    }
    boolean check(String s){
        int left=0;
        int right = s.length()-1;
        while(left<right)if(s.charAt(left++)!=s.charAt(right--))return false;
        return true;
    }
}