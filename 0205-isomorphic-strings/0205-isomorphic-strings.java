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
        // int[] sa = new int[26];
        // int[] ta = new int[26];
        // Arrays.fill(sa,-1);
        // Arrays.fill(ta,-1);
        // for(int i=0;i<s.length();i++){
        //     char cs = s.charAt(i);
        //     char ct = t.charAt(i);
        //     if(sa[cs-'a'+0]!=-1){if(sa[cs-'a'+0]!=ct-'a'+0)return false;}
        //     else sa[cs-'a'+0]=ct-'a'+0;
        //     if(ta[ct-'a'+0]!=-1){if(ta[ct-'a'+0]!=cs-'a'+0)return false;}
        //     else ta[ct-'a'+0]=cs-'a'+0;
            

        // }return true;
    }
}