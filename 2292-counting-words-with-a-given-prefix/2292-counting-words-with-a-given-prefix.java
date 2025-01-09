class Solution {
    public int prefixCount(String[] words, String pref) {
        int sum=0;
        for(String i:words){if(i.startsWith(pref))sum++;}
        return sum;
    }
}