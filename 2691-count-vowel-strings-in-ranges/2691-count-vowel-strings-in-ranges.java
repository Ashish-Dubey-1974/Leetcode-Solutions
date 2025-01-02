class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len =words.length;
        boolean[] vow = new boolean[len];
        int[] prefixSum = new int[len + 1];
        int[] ans = new int[queries.length];
        for(int i=0;i<len;i++){
            int l = words[i].length();
            if((words[i].charAt(0)=='a'||
                words[i].charAt(0)=='e'||
                words[i].charAt(0)=='i'||
                words[i].charAt(0)=='o'||
                words[i].charAt(0)=='u')&&(words[i].charAt(l-1)=='a'||
                words[i].charAt(l-1)=='e'||
                words[i].charAt(l-1)=='i'||
                words[i].charAt(l-1)=='o'||
                words[i].charAt(l-1)=='u'))
                {
                    vow[i] = true;
                }
        }
        // for(int i=0;i<vow.length;i++)System.out.print(vow[i]+" ");
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + (vow[i] ? 1 : 0);
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = prefixSum[right + 1] - prefixSum[left];
        }return ans;
    }
}