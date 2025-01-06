class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
    int n = s.length();
    int[] shiftEffect = new int[n + 1];
    for (int[] shift : shifts) {
        int start = shift[0];
        int end = shift[1];
        int direction = shift[2] == 1 ? 1 : -1;

        shiftEffect[start] += direction;
        shiftEffect[end + 1] -= direction;
    }
    int netShift = 0;
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < n; i++) {
        netShift += shiftEffect[i];
        int effectiveShift = (netShift % 26 + 26) % 26; 
        char newChar = (char) ((s.charAt(i) - 'a' + effectiveShift) % 26 + 'a');
        result.append(newChar);
    }

    return result.toString();
}

}