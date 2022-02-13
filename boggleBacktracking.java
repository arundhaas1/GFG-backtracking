 public static void main(String args[]){
        char[][] board= {{'G','I','Z'},
                           {'U','E','K'},
                           {'Q','S','E'}};

        boolean[][] visited= {{false,false,false},
                              {false,false,false},
                              {false,false,false}};

        ArrayList<String> dictionary=new ArrayList<>();
        dictionary.add("GEEKS");
        dictionary.add("QUIZ");
        dictionary.add("FOR");
        dictionary.add("GO");
        dictionary.add("SEQ");

        String word="";


        for (int i=0;i<3;i++){  //to start from all the char in the board
            for (int j=0;j<3;j++){
                visited[i][j]=true;
                findWord(board,visited,0,0,word+board[i][j],dictionary);
                visited[i][j]=false;
            }
        }
    }

    static int[] pathrow={0,0,1,1,-1,1,-1,-1};  //combinations of all movement
    static int[] pathcol={1,-1,-1,1,1,0,0,-1};

    public static void findWord(char[][] board, boolean[][] visited, int row, int col, String word, ArrayList<String> dictionary){
        if(dictionary.contains(word)){
            System.out.println(word);
        }
        if(board.length*board[0].length==word.length()){    //b.length and b[0].length for 3*3 and gives 9
            return;
        }
        for (int i=0;i<pathrow.length;i++){  //to run all the combinations
            int newRow=row+pathrow[i];
            int newCol=col+pathcol[i];
            if(isValid(newRow,newCol,visited)==true){  //to check if already visited and if out of the box
                visited[newRow][newCol]=true;

                findWord(board,visited,newRow,newCol,word+board[newRow][newCol],dictionary);
                visited[newRow][newCol]=false;
            }

        }
    }

    public static boolean isValid(int newRow,int newCol,boolean[][] visited){
        if(newRow>=0 && newCol>=0 && newRow<3 && newCol<3 && visited[newRow][newCol]==false){
            return true;
        }else {
            return false;
        }
    }
