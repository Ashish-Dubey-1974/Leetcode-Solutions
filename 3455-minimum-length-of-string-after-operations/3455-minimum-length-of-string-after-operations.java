class Solution {
    public int minimumLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        Arrays.fill(arr1,-1);
        Arrays.fill(arr2,-1);
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            int idx = ch-'a';
            if(arr1[idx]==-1)arr1[idx]=i;
            else if(arr2[idx]==-1)arr2[idx]=i;
            else {
                int m1 = arr1[idx];
                int m2 = arr2[idx];
                sb.setCharAt(m1,'*');
                arr1[idx] = m2;
                sb.setCharAt(i,'*');
                arr2[idx]=-1;
                // System.out.println(sb+" "+i+" m1 "+map1+" m2 "+map2);
            }   
             
        }
        int sum=0;
        for(int i=0;i<sb.length();i++)if(sb.charAt(i)!='*')sum++;
        return sum;
    }
}