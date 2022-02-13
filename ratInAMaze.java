package com.dhas;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        int[][] maze= {{1,1,0,1},
                        {0,1,1,1},
                        {0,1,0,1},
                        {1,1,1,1}};

        int[][] visited= {{0,0,0,0},
                              {0,0,0,0},
                              {0,0,0,0},
                              {0,0,0,0}};
        visited[0][0]=1;
        findPath(maze,visited,0,0,3,3);

    }

    static int[] pathrow={0,0,1,-1};  //combinations of all movement
    static int[] pathcol={1,-1,0,0};

    public static void findPath(int[][] maze, int[][] visited, int row, int col, int desRow,int desCol){
     if (row==desRow && col==desCol){  //after reaching end print all
         for (int i=0;i<maze.length;i++){
             for (int j=0;j<maze[0].length;j++){
                 System.out.print(visited[i][j]+" ");
             }
             System.out.println();
         }
         System.out.println("---------------------------------------------------------");
     }else{
         for (int i=0;i<pathrow.length;i++){
             int newrow=row+pathrow[i];
             int newCol=col+pathcol[i];

             if(isValid(maze,visited,newrow,newCol)){
                 visited[newrow][newCol]=1;
                 findPath(maze,visited,newrow,newCol,desRow,desCol);
                 visited[newrow][newCol]=0;
             }
         }
     }
    }

    public static boolean isValid(int[][] maze,int[][] visited,int newRow,int newCol){
        if(newRow>=0 && newCol>=0 && newRow<maze.length && newCol<maze[0].length && visited[newRow][newCol]==0  && maze[newRow][newCol]==1){
            return true;
        }else {
            return false;
        }
    }
}


