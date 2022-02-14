public static void main(String args[]){

        int[][] visited= {{0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0}};

        visited[0][0]=1;
        findPath(visited,0,0,1);
    }

    static int[] pathrow={2,1,-1,-2,-2,-1,1,2};  //combinations of all movement
    static int[] pathcol={1,2,2,1,-1,-2,-2,-1};

    public static boolean findPath( int[][] visited, int row, int col, int move){
     if (move==64){
         for (int i=0;i<8;i++){   //8 rows and columns
             for (int j=0;j<8;j++){
                 System.out.print(visited[i][j]+" ");
             }
             System.out.println();
         }
         return true;
     }else{
         for (int i=0;i<pathrow.length;i++){
             int newrow=row+pathrow[i];
             int newCol=col+pathcol[i];

             if(isValid(visited,newrow,newCol)){
                 move++;
                 visited[newrow][newCol]=move;
                 if(findPath(visited,newrow,newCol,move)){
                     return true;
                 }
                 visited[newrow][newCol]=0;
                 move--;
             }
         }
     }
     return false;
    }

    public static boolean isValid(int[][] visited,int newRow,int newCol){
        if(newRow>=0 && newCol>=0 && newCol<8 && newRow<8 && visited[newRow][newCol]==0 ){
            return true;
        }else {
            return false;
        }
    }
