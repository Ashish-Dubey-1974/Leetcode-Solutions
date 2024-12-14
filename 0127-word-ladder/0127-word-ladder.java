class Solution {
    class pair{
        String s;
        int c;
        pair(String s,int c){
            this.s=s;this.c=c;
        }
    }
    public int ladderLength(String begin, String end, List<String> wordList) {
        HashSet<String> map = new HashSet<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(begin,1));
        for(int i=0;i<wordList.size();i++)map.add(wordList.get(i));
        if(map.contains(begin))map.remove(begin);
        if(map.contains(end)){
            while(!q.isEmpty()){
                pair p = q.remove();
                for(int i=0;i<p.s.length();i++){
                    for(char c='a';c<='z';c++){
                        String m = p.s.substring(0,i)+c+p.s.substring(i+1);
                        if(m.equals(end))return p.c+1;
                        else if(map.contains(m)){
                            // System.out.print(m+" "+p.c+"  ");
                            q.add(new pair(m,p.c+1));
                            map.remove(m);
                        }
                    }
                }
            }return 0;
        }
        else return 0;
    }
}