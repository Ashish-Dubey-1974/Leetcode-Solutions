class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        int row = arr.length;
        int col = arr[0].length;
        int leftcol=0,rightcol=col-1,bottomrow=row-1,toprow=0,total=0;
        while(total<row*col){
            for(int i=leftcol;i<=rightcol&&total<row*col;i++){list.add(arr[toprow][i]);total++;}
            toprow++;
            for(int i=toprow;i<=bottomrow&&total<row*col;i++){list.add(arr[i][rightcol]);total++;}
            rightcol--;
            for(int i=rightcol;i>=leftcol&&total<row*col;i--){list.add(arr[bottomrow][i]);total++;}
            bottomrow--;
            for(int i=bottomrow;i>=toprow&&total<row*col;i--){list.add(arr[i][leftcol]);total++;}
            leftcol++;
        }return list;
    }
}