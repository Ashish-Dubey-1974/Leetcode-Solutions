class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int sum=0;
        boolean[] a = new boolean[n];
        boolean[] b = new boolean[n];
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            if(A[i]==B[i]){
                sum++;
                ans[i]=sum;
                a[A[i]-1] = true;
                b[B[i]-1] = true;
            }else{
                if(b[A[i]-1])sum++;
                if(a[B[i]-1])sum++;
                a[A[i]-1] = true;
                b[B[i]-1] = true;
                ans[i]=sum;

            }
        }return ans;
    }
}