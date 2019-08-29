import java.util.Scanner;

public class MainApp {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to tic tac toe! \n" +
                "Here is a table to indicate x and y locations: \n" +
                "-----------------------------");
        printInfo();
        System.out.println("-----------------------------");

        GameBoard ttt = new GameBoard();
        do{
            System.out.println("Player " + ttt.getPlayer() + ", enter x (space) y coordinates: ");
            int x = scan.nextInt();
            int y = scan.nextInt();
            ttt.add(x, y);
            System.out.println("----------------");
            printBoard(ttt.getBoard());
            System.out.println("----------------");
        }while(!ttt.gameOver() );

        System.out.println("Thanks for playing!");
    }

    private static void printBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0)
                    System.out.print("|" + " " );
                else
                    System.out.print("|" + board[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    private static void printInfo(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("|" + "(" + i + "," + j + ")");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
