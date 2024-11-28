class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){if(goal.charAt(i)==s.charAt(s.length()-1))list.add(i);}
        for(int i=0;i<list.size();i++){if(s.contains(goal.substring(0,list.get(i)+1))&&s.contains(goal.substring(list.get(i)+1,goal.length())))return true;}return false;
    }
}