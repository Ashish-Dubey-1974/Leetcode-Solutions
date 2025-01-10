class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] maxFre = new int[26];
        for(String s : words2){
            int[] fre = new int[26];
            for(int i=0;i<s.length();i++)fre[s.charAt(i)-'a']++;
            for(int i=0;i<26;i++)maxFre[i] = Math.max(maxFre[i],fre[i]);
        }
        for(String s : words1){
            int[] fre = new int[26];
            for(char ch : s.toCharArray())fre[ch-'a']++;
            boolean check=true;
            for(int i=0;i<26;i++){
                if(fre[i]<maxFre[i]){
                    check=false;
                    break;
                }
            }if(check)list.add(s);
        }return list;
    }
}