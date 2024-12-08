class Solution {  
    public String countAndSay(int n) {  
        String ans = "1";  
        for (int h = 0; h < n - 1; h++) {  
            StringBuilder sb = new StringBuilder();  
            int count = 1;  
            for (int i = 1; i < ans.length(); i++) {  
                if (ans.charAt(i) == ans.charAt(i - 1)) {  
                    count++;  
                } else {  
                    sb.append(count).append(ans.charAt(i - 1));  
                    count = 1;
                }  
            }  
            sb.append(count).append(ans.charAt(ans.length() - 1));  
            ans = sb.toString();
        }  
        return ans;  
    }  
}