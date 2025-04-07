class Solution {
    public String maximumOddBinaryNumber(String s) {
        int countOnes = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOnes++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        while (countOnes != 0) {
            if (countOnes == 1) {
                sb.append("1");
            } else {
                sb.insert(0, "1");
            }
            countOnes--;
        }
        
        return sb.toString();
    }
}
