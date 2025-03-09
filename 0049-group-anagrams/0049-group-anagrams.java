class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> lls = new ArrayList<>();
       HashMap<String,List<String>> map = new HashMap<>();
       for(int i=0;i<strs.length;i++){
        int[] arr = new int[26];
        for(int j=0;j<strs[i].length();j++)arr[strs[i].charAt(j)-'a']++;
        String cm = "";
        for(int j=0;j<26;j++)cm=cm+arr[j]+"#";
        map.putIfAbsent(cm,new ArrayList<String>());
        map.get(cm).add(strs[i]);
       }
       for(Map.Entry<String,List<String>>entry:map.entrySet())lls.add(entry.getValue());
       return lls;
    }
}