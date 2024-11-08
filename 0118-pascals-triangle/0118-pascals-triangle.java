class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> ls = new ArrayList<>(i);
            ls.add(1);
            for(int j=1;j<i;j++){
                ls.add(list.get(i-1).get(j)+list.get(i-1).get(j-1));
            }
            if(i!=0)
            ls.add(1);
            list.add(ls);
        }return list;
    }
}