package files;

class Board {
    int rows;
    int cols;
    Symbol[][] grid;
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Symbol[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j]=Symbol.EMPTY;
            }
        }
    }
    public boolean isValidMove(Position position){
        boolean result=position.row>=0 && position.col>=0 && position.row<rows && position.col<cols
                && (grid[position.row][position.col] == Symbol.EMPTY);
        if(result)
            return result;
        System.out.println("Invalid Move Chosen");
        return false;
    }
    public void makeMove(GameContext gameContext,Position position,Symbol symbol){
        grid[position.row][position.col]=symbol;
        // check for horizontal winning
        for(int i=0;i<rows;i++){
            int count=0;
            for(int j=0;j<cols;j++){
                if(grid[i][j]==symbol){
                    count++;
                }
            }
            if(count==3){
                gameContext.setWinningState(symbol);
                drawBoard();
                return;
            }
        }
        //check for vertical winning
        for(int i=0;i<cols;i++){
            int count=0;
            for(int j=0;j<rows;j++){
                if(grid[j][i]==symbol){
                    count++;
                }
            }
            if(count==3){
                gameContext.setWinningState(symbol);
                drawBoard();
                return;
            }
        }
        // check for diagonal winning
        int c1=0,c2=0,c3=0;
        for(int i=0;i<rows;i++){
            if(grid[i][i]==symbol) c1++;
            if(grid[i][rows-i-1]==symbol) c2++;
        }
        if(c1==3 || c2==3){
            gameContext.setWinningState(symbol);
            drawBoard();
            return;
        }
        //check ifits draw
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]!=Symbol.EMPTY)
                {
                    c3++;
                }
            }
        }
        if(c3==0){
            gameContext.setWinningState(Symbol.EMPTY);
            drawBoard();
            return;
        }

        gameContext.gameState.nextState(gameContext);
        drawBoard();
    }
    public void drawBoard(){
       for (int i=0;i<rows;i++){
           for (int j=0;j<cols;j++){
               System.out.print(grid[i][j].equals(Symbol.X)?" X ":grid[i][j].equals(Symbol.O)?" O ":"___");
           }
           System.out.println();
       }

    }

}
