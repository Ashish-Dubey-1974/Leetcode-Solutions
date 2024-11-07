class Solution {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    List<Integer> ls1 = new ArrayList<>();
                    ls1.add(i);
                    ls1.add(j);
                    ls.add(ls1);
                }
            }
        }
        for(int i=0;i<ls.size();i++){
            helper(matrix,ls.get(i));
        }
    }
    static int[][] helper(int[][] arr,List<Integer> point){
        for(int i=0;i<arr.length;i++){
            arr[i][point.get(1)]=0;
        }
        for(int i=0;i<arr[0].length;i++){
            arr[point.get(0)][i]=0;
        }
        return arr;
    }
}