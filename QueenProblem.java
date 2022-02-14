 public static void main(String args[]){

        boolean[][] board={{false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false}};
        NQueen(board,8,-1);


    }

    public static boolean NQueen(boolean[][] board, int size, int row){
        if (row == size - 1){  //upto reaching last row of the board
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return true;
        }else{
            for (int i = 0; i < size; i++){
                int rowNew = row + 1;
                int newCol=i;
                
                if (IFValidCell(board, rowNew, newCol, size)){
                    board[rowNew][newCol] = true;
                    if (NQueen(board, size, rowNew)){
                        return true;
                    }
                    board[rowNew][newCol] = false;
                }
            }
            return false;
        }
    }

    static boolean IFValidCell(boolean[][] board, int newRow, int newCol, int size){
        boolean valid = true;
        for (int i = 0; i < size; i++){
            if (board[i][newCol]){
                valid = false;
            }
        }
        for (int i = newRow, j = newCol; i >= 0 && j >= 0; i--, j--){  //in cross way checking of queen
            if (board[i][j]){
                valid = false;
            }
        }
        for (int i = newRow, j = newCol; i >= 0 && j < size; i--, j++){  //in straight way of queen
            if (board[i][j]){
                valid = false;
            }
        }
        return valid;
    }
