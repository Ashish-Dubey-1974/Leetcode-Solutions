class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min=Integer.MAX_VALUE;
        int n=blocks.length();
        for(int i=0;i<n;i++){
            if(i+k>n)return min;
            int dummyMin=0;
            for(int j=i;j<k+i;j++){
                if(blocks.charAt(j)=='W')dummyMin++;
            }min=min>dummyMin?dummyMin:min;
        }return min;
    }
}