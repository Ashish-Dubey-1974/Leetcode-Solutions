class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min=Integer.MAX_VALUE;
        int n=blocks.length();
        int[] arr = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            if(blocks.charAt(i)=='W')sum++;
            arr[i]=sum;
        }
        for(int i=0;i+k-1<n;i++){
            min=Math.min(min,arr[i+k-1]-(i>0?arr[i-1]:0));
        }return min;
    }
}