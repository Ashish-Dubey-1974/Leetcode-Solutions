class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int sum=0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(ispre_suf(words[i],words[j]))sum++;
            }
        }return sum;
    }
    boolean ispre_suf(String s,String str){
        return str.startsWith(s)&&str.endsWith(s);
    }
}