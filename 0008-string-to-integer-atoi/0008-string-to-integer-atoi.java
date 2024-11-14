class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        int index = 0;
        int sign = 1;
        int result = 0;
        
        // Ignore leading whitespace
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        
        // Check for sign
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        
        // Convert digits
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        return result * sign;
    }
}