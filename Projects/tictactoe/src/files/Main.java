package files;

import java.util.Scanner;

class TicTacToeGame{
    Board board;
    Player player1;
    Player player2;
    Player currentPlayer;
    GameContext gameContext;

    public TicTacToeGame(String player1Name,String player2Name){
        board=new Board(3,3);
        player1=new HumanPlayer(player1Name);
        player2=new HumanPlayer(player2Name);
        currentPlayer=player1;
        gameContext=new GameContext(new XState());
    }
    void play(){
        System.out.println("Game is Starting");
        while (!gameContext.getGameState().isGameEnded()){
            if(currentPlayer==player1) {
                Position position ;
                do{
                    position=player1.chooseMove();
                }while (!board.isValidMove(position));
                board.makeMove(gameContext,position,Symbol.X);
                currentPlayer=player2;
            }
            else{
                Position position ;
                do{
                    position=player2.chooseMove();
                }while (!board.isValidMove(position));
                board.makeMove(gameContext,position,Symbol.O);
                currentPlayer=player1;

            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        String player1Name,player2Name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of Player 1: ");
        player1Name=sc.next();
        System.out.println("Enter the name of Player 2: ");
        player2Name=sc.next();
        TicTacToeGame ticTacToeGame = new TicTacToeGame(player1Name,player2Name);
        ticTacToeGame.play();
    }
}