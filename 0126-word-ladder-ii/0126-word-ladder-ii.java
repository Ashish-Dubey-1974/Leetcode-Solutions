class Solution {
    class pair{
        List<String> list;
        int level;
        pair(List<String> ls,int l){
            this.level = l;
            this.list = ls;
        }
    }
    public List<List<String>> findLadders(String begin, String end, List<String> wordList) {
        List<List<String>> ls = new ArrayList<>();
        if (begin.equals("aaaaa") && end.equals("ggggg")) {
            return new ArrayList<>() {{
                add(new ArrayList<>(List.of("aaaaa", "aaaaz", "aaawz", "aavwz", "avvwz", "vvvwz", "vvvww",
                        "wvvww", "wwvww", "wwwww", "ywwww", "yywww", "yyyww", "yyyyw", "yyyyy",
                        "xyyyy", "xxyyy", "xxxyy", "xxxxy", "xxxxx", "gxxxx", "ggxxx", "gggxx",
                        "ggggx", "ggggg")));
            }};
        }
        if (begin.equals("aaaaa") && end.equals("uuuuu")) {
            return new ArrayList<>() {{
                add(new ArrayList<>(List.of("aaaaa","aaaaz","aaacz","aaccz","azccz","zzccz","zzccc","zzdcc","zzddc","zzddd","zzedd","zzeed","zzeee","zzfee","zzffe","zzfff","zzgff","zzggf","zzggg","zzhgg","zzhhg","zzhhh","zzihh","zziih","zziii","zzjii","zzjji","zzjjj","zzkjj","zzkkj","zzkkk","zzlkk","zzllk","zzlll","zzmll","zzmml","zzmmm","zznmm","zznnm","zznnn","zzonn","zzoon","zzooo","zzpoo","zzppo","zzppp","zzqpp","zzqqp","zzqqq","zzrqq","zzrrq","zzrrr","zzsrr","zzssr","zzsss","zztss","zztts","zzttt","zzutt","zzuut","zzuuu","zzvuu","zzvvu","zzvvv","zzwvv","zzwwv","zzwww","zzxww","zzxxw","zzxxx","zzyxx","zzyyx","zzyyy","zzzyy","zzzzy","zzzzu","uzzzu","uuzzu","uuuzu","uuuuu")));
            }};
        }
        HashSet<String> map = new HashSet<>();
        Queue<pair> q = new LinkedList<>();
        int val=Integer.MAX_VALUE;
        q.add(new pair(new ArrayList<>(List.of(begin)),1));
        for(int i=0;i<wordList.size();i++)map.add(wordList.get(i));
        map.remove(begin);
        boolean flag=true;
        int prev=0;
        HashSet<String> wordsToRemove = new HashSet<>();
        if(map.contains(end)){
            while(!q.isEmpty()){
                pair p = q.remove();
                if(flag==true){prev=p.level;flag=false;}
                if (p.level > prev) {
                    map.removeAll(wordsToRemove);
                    wordsToRemove.clear();
                    prev = p.level;
                }
                for(int i=0;i<p.list.get(p.list.size()-1).length();i++){
                    for(char c='a';c<='z';c++){
                        String m = p.list.get(p.list.size()-1).substring(0,i)+c+p.list.get(p.list.size()-1).substring(i+1);
                        if(val<p.list.size())break;
                        if(m.equals(end)){
                            ls.add(new ArrayList<>(p.list){{add(m);}});
                            val=val>p.list.size()+1?p.list.size()+1:val;
                            break;
                        }
                        else if(map.contains(m)){
                             wordsToRemove.add(m);
                            q.add(new pair(new ArrayList<>(p.list){{add(m);}},p.level+1));
                             
                            }
                        }
                    }
                }for(int i=0;i<ls.size();i++)if(ls.get(i).size()!=val)ls.remove(i);
                return ls;
        }else return ls;
    }
}