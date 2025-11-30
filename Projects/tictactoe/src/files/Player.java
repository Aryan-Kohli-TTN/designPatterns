package files;

import java.util.Scanner;

interface Player {
    Position chooseMove();
}
class HumanPlayer implements Player{
    Scanner scanner;
    String playerName = "";
    public HumanPlayer(String name){
        scanner=new Scanner(System.in);
        playerName=name;
    }
    @Override
    public Position chooseMove(){
        System.out.println("--------------------------------------------");
        System.out.println(playerName+" Choose a MOVE");
        System.out.println("--------------------------------------------");
        int row,col;
        System.out.print("Enter row between 0-2 : ");
        row=scanner.nextInt();
        System.out.println("--------------------------------------------");
        System.out.print("Enter col between 0-2 : ");
        col=scanner.nextInt();
        System.out.println("--------------------------------------------");
        return new Position(row,col);
    }
}