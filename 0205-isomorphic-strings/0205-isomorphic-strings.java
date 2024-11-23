class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> maps = new HashMap<>();
        HashMap<Character,Character> mapt = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char cs = s.charAt(i);
            char ct  = t.charAt(i);
            if(maps.containsKey(cs)&&maps.get(cs)!=ct){
                return false;
            }
            else{
                maps.put(cs,ct);
            } 
        if(mapt.containsKey(ct)&&mapt.get(ct)!=cs){
            return false;
        }
            else {
                mapt.put(ct,cs);
            }
        }
        return true;
    }
}