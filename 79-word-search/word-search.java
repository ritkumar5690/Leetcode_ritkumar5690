class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i =0;i<n;i++){
            for(int j =0 ;j<m;j++){
                if(check(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(char[][] board, String word,int i,int j,int index){
        if(index == word.length()){
            return true;
        }
        if( j <0 || i<0 || j >= board[0].length || i >= board.length || board[i][j] != word.charAt(index)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';
        boolean flag = check(board,word,i+1,j,index +1)||
                      check(board,word,i-1,j,index +1)||
                      check(board,word,i,j+1,index +1)||
                      check(board,word,i,j-1,index +1);

        board[i][j] = temp;
        return flag;              
    }
}