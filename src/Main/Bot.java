package Main;

public class Bot {
    // Main.Bot is always Player 2
    public char[][] addPhase(GameBoard ttt) {
        // return board with optimal move added in.
        char[][] board = ttt.getBoard();
        char[][] newBoard = new char[3][3];
//        if (canWin()){
//
//        } else if (canBlock()){
//
//        } else if (canFork()){
//
//        } else if (canBlockFork()){
//
//        } else if (canSetCenter()) {
//
//        if (canSetOppositeCorner()) {
//
//        }
        if (canSetEmptyCorner(board)) {
            newBoard = setEmptyCorner(board);
        }
        else if (canSetEmptySide(board)) {
            newBoard = setEmptySide(board);
        }
        return newBoard;
    }






    private char[][] setEmptyCorner(char[][] board){
        if(isEmpty(board[0][0]) ){
            board[0][0] = 'O';
        } else if(isEmpty(board[0][2]) ){
            board[0][2] = 'O';
        } else if(isEmpty(board[2][2]) ){
            board[2][2] = 'O';
        } else if(isEmpty(board[2][0]) ){
            board[2][0] = 'O';
        }
        return board;
    }

    private boolean canSetEmptyCorner(char[][] board){
        return ( isEmpty(board[0][0])
                || isEmpty(board[2][0])
                || isEmpty(board[0][2])
                || isEmpty(board[2][2]) );
    }

    private char[][] setEmptySide(char[][] board){
        if(isEmpty(board[0][1]) ){
            board[0][1] = 'O';
        } else if(isEmpty(board[1][2]) ){
            board[1][2] = 'O';
        } else if(isEmpty(board[2][1]) ){
            board[2][1] = 'O';
        } else if(isEmpty(board[1][0]) ){
            board[1][0] = 'O';
        }
        return board;
    }

    private boolean canSetEmptySide(char[][] board){
        return ( isEmpty(board[0][1])
                || isEmpty(board[1][0])
                || isEmpty(board[2][1])
                || isEmpty(board[1][2]) );
    }

    private boolean isEmpty(char c){
        return (c == 0);
    }
}


