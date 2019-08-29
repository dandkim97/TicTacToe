public class GameBoard {
    private char[][] board;
    private int size;
    private int player;

    private String rowO = "OOO";
    private String rowX = "XXX";

    public GameBoard() {
        board = new char[3][3];
        size = 0;
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
            size++;
        }else{
            System.out.println("No cheating!");
        }
    }

    public int getPlayer(){
        return player;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean gameOver() {
        if(checkRows() ){
            return true;
        }
        if(checkColumns() ){
            return true;
        }
        if(checkDiagonals()){
            return true;
        }
        if(size == 9){
            System.out.println("Game is Tied");
            return true;
        }
        return false;
    }

    private boolean checkRows() {
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

    private boolean checkColumns(){
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

    private boolean checkDiagonals(){
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
