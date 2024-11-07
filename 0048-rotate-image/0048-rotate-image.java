class Solution {
    public void rotate(int[][] arr) {
        transpose(arr);
        for(int i=0;i<arr.length;i++){
            int l=0,r=arr.length-1;
            while(l<r){
                int temp = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = temp;
                l++;
                r--;
            }
        }
    }
    static int[][] transpose(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }return arr;
    }
}