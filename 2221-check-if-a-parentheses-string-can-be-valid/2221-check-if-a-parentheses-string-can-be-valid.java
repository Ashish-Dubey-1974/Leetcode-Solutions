class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n<2)return false;
        if (n % 2 != 0) return false;
        int open = 0;
        int flex=0;
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0')flex++;
            else if(s.charAt(i)=='(')open++;
            else{
                if(open>0)open--;
                else if(flex>0)flex--;
                else return false;
            }
        }if(open>flex)return false;
        open=0;
        flex=0;
        for(int i=n-1;i>=0;i--){
            if(locked.charAt(i)=='0')flex++;
            else if(s.charAt(i)==')')open++;
            else{
                if(open>0)open--;
                else if(flex>0)flex--;
                else return false;
            }
        }return open<=flex;
    }
}