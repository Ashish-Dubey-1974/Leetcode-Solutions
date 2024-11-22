class Solution {
    public int fib(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);
        return fib2(arr,n);
    }
    int fib2(int[] arr,int n){
        if(n<=1)return n;
        arr[n] = fib2(arr,n-1)+fib2(arr,n-2);
        return arr[n];
    }
}