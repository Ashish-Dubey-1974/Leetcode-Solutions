class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left=0,right=s.length()-1;
        while(left<right){
            while(left<right&&(sb.charAt(left)!='a'&&sb.charAt(left)!='e'&&sb.charAt(left)!='i'&&sb.charAt(left)!='o'&&sb.charAt(left)!='u'&&sb.charAt(left)!='A'&&sb.charAt(left)!='E'&&sb.charAt(left)!='I'&&sb.charAt(left)!='O'&&sb.charAt(left)!='U'))left++;
            // System.out.println("left = "+left);
            while(left<right&&(sb.charAt(right)!='a'&&sb.charAt(right)!='e'&&sb.charAt(right)!='i'&&sb.charAt(right)!='o'&&sb.charAt(right)!='u'&&sb.charAt(right)!='A'&&sb.charAt(right)!='E'&&sb.charAt(right)!='I'&&sb.charAt(right)!='O'&&sb.charAt(right)!='U'))right--;
            // System.out.println("right = "+right);
            if(left>=right)return sb.toString();
            char l = sb.charAt(left);
            char r = sb.charAt(right);
            sb.setCharAt(right,l);
            sb.setCharAt(left,r);
            left++;
            right--;
        }return sb.toString();
    }
}