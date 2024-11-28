class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n!=t.length())return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<n;i++){
            arr1[s.charAt(i)-97]++;
            arr2[t.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i])return false;
        }
        return true;
    }
}