

// The java.lang.NumberFormatException occurs because the input string is too large to be parsed as a long or int. In Java:

// Integer.parseInt() can only handle numbers within the range of a 32-bit signed integer (-2^31 to 2^31 - 1).
// Long.parseLong() can handle numbers within the range of a 64-bit signed integer (-2^63 to 2^63 - 1).
// The number in your string exceeds the maximum limit of long, which is 9,223,372,036,854,775,807.

// Solutions:
// 1. Use BigInteger for Large Numbers
// If the input number can exceed long's range, use BigInteger to handle arbitrary-sized integers.

// Here's the updated code using BigInteger:

// java
// Copy code
import java.math.BigInteger;
class Solution {
    public String removeDigit(String s, char digit) {
        StringBuilder sb = new StringBuilder(s);
        BigInteger num=BigInteger.ZERO;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==digit){
                sb.deleteCharAt(i);
                BigInteger curr = new BigInteger(sb.toString());
                num = num.max(curr);
                sb.insert(i,digit);
            }
        }return num+"";
    }
}