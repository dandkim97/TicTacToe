package Main;

public class GameBoard {
    private char[][] board;
    private int player;

    private String rowO = "OOO";
    private String rowX = "XXX";

    public GameBoard() {
        board = new char[3][3];
        player = 1;
    }

    public void add(int r, int c) {
        if(board[r][c] == 0) {
            if (player == 1) {
                board[r][c] = 'X';
                player = 2;
            } else {
                board[r][c] = 'O';
                player = 1;
            }
        }else{
            System.out.println("No cheating!");
        }
    }

    public int getPlayer(){
        return player;
    }
    public void setPlayer(int player) { this.player = player; }
    public char[][] getBoard() { return board; }
    public void setBoard(char[][] board) { this.board = board; }

    public boolean gameOver() {
        return (   isThreeInARow()
                || isThreeInAColumn()
                || isThreeInADiagonal()
                || isBoardFull() );

    }

    private boolean isBoardFull(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == 0){
                    return false;
                }
            }
        }
        System.out.println("It is a draw!");
        return true;
    }

    private boolean isThreeInARow() {
        for (int r = 0; r < board.length; r++) {
            String curr = "";
            for (int c = 0; c < board[0].length; c++) {
                curr += board[r][c];
                if (curr.equals(rowO)){
                    System.out.println("O wins");
                    return true;
                }
                else if(curr.equals(rowX)) {
                    System.out.println("X wins");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isThreeInAColumn(){
        for(int c = 0; c < board[0].length; c++){
            String curr = "";
            for(int r = 0; r < board.length; r++){
                curr += board[r][c];
                if(curr.equals(rowO)){
                    System.out.println("O wins");
                    return true;
                }
                else if(curr.equals(rowX)) {
                    System.out.println("X wins");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isThreeInADiagonal(){
        String diag1 = "" + board[0][0] + board[1][1] + board[2][2];
        String diag2 = "" + board[2][0] + board[1][1] + board[0][2];
        if(diag1.equals(rowO) || diag2.equals(rowO)){
            System.out.println("O wins");
            return true;
        }
        else if(diag1.equals(rowX) || diag2.equals(rowX)){
            System.out.println("X wins");
            return true;
        }
        return false;
    }
}
