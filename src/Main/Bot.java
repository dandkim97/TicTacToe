package Main;

public class Bot {
    // Main.Bot is always Player 2
    private int botR;               // setBlock helper
    private int botC;               // variables

    public char[][] addPhase(GameBoard ttt) {
        char[][] board = ttt.getBoard();
        char[][] newBoard = new char[3][3];
        if (canWin(board)) {
            newBoard = setBlockOrWin(board);
        }
        else if (canBlock(board)) {
            newBoard = setBlockOrWin(board);
        }
        else if (canFork(board)){
            newBoard = setFork(board);
        }
        else if (canBlockFork(board)){
            newBoard = setEmptySide(board);               // to block fork, prevent corner placement by skipping to empty side placement.
        }
        else if (canSetCenter(board)) {
            newBoard = setCenter(board);
        }
        else if (canSetOppositeCorner(board)) {
            newBoard = setOppositeCorner(board);
        }
        else if (canSetEmptyCorner(board)) {
            newBoard = setEmptyCorner(board);
        }
        else if (canSetEmptySide(board)) {
            newBoard = setEmptySide(board);
        }
        return newBoard;
    }

    private char[][] setBlockOrWin(char[][] board){
        board[botR][botC] = 'O';
        return board;
    }

    private boolean canWin(char[][] board){
        return (winRow(board) || winColumn(board) || winDiagonal(board));
    }

    private boolean winRow(char[][] board) {
        for(int r = 0; r < board.length; r++){
            int numOfO = 0, numOfEmpty = 0;
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == 'O'){
                    numOfO++;
                }
                else if (board[r][c] == 0) {
                    botR = r;
                    botC = c;
                    numOfEmpty++;
                }
            }
            if((numOfO == 2) && (numOfEmpty == 1) ) {
                return true;
            }
        }
        return false;
    }

    private boolean winColumn(char[][] board){
        for(int c = 0; c < board[0].length; c++){
            int numOfO = 0, numOfEmpty = 0;
            for(int r = 0; r < board.length; r++){
                if(board[r][c] == 'O'){
                    numOfO++;
                }
                else if (board[r][c] == 0) {
                    botR = r;
                    botC = c;
                    numOfEmpty++;
                }
            }
            if((numOfO == 2) && (numOfEmpty == 1) ) {
                return true;
            }
        }
        return false;
    }

    private boolean winDiagonal(char[][] board){
        String leftDiagonal = ("" + board[0][0] + board[1][1] + board[2][2]).replace("\0", "");
        String rightDiagonal = ("" + board[0][2] + board[1][1] + board[2][0]).replace("\0", "");
        if(leftDiagonal.equals("OO")){
            if(board[0][0] == 0){
                botR = 0; botC = 0;
            }
            else if(board[1][1] == 0){
                botR = 1; botC = 1;
            }
            else{
                botR = 2; botC = 2;
            }
            return true;
        }
        else if(rightDiagonal.equals("OO")){
            if(board[0][2] == 0){
                botR = 0; botC = 2;
            }
            else if(board[1][1] == 0){
                botR = 1; botC = 1;
            }
            else{
                botR = 2; botC = 0;
            }
            return true;
        }
        return false;
    }

    private boolean canBlock(char[][] board){
        return (stopRows(board) || stopColumns(board) || stopDiagonals(board));
    }

    private boolean stopRows(char[][] board){
        for(int r = 0; r < board.length; r++){
            int numOfX = 0, numOfEmpty = 0;
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == 'X'){
                    numOfX++;
                }
                else if (board[r][c] == 0) {
                    botR = r;
                    botC = c;
                    numOfEmpty++;
                }
            }
            if((numOfX == 2) && (numOfEmpty == 1) ) {
                return true;
            }
        }
        return false;
    }

    private boolean stopColumns(char[][] board){
        for(int c = 0; c < board[0].length; c++){
            int numOfX = 0, numOfEmpty = 0;
            for(int r = 0; r < board.length; r++){
                if(board[r][c] == 'X'){
                    numOfX++;
                }
                else if (board[r][c] == 0) {
                    botR = r;
                    botC = c;
                    numOfEmpty++;
                }
            }
            if((numOfX == 2) && (numOfEmpty == 1) ) {
                return true;
            }
        }
        return false;
    }

    private boolean stopDiagonals(char[][] board){
        String leftDiagonal = ("" + board[0][0] + board[1][1] + board[2][2]).replace("\0", "");
        String rightDiagonal = ("" + board[0][2] + board[1][1] + board[2][0]).replace("\0", "");
        if(leftDiagonal.equals("XX")){
            if(board[0][0] == 0){
                botR = 0; botC = 0;
            }
            else if(board[1][1] == 0){
                botR = 1; botC = 1;
            }
            else{
                botR = 2; botC = 2;
            }
            return true;
        }
        else if(rightDiagonal.equals("XX")){
            if(board[0][2] == 0){
                botR = 0; botC = 2;
            }
            else if(board[1][1] == 0){
                botR = 1; botC = 1;
            }
            else{
                botR = 2; botC = 0;
            }
            return true;
        }
        return false;
    }

    private char[][] setFork(char[][] board){
        if(isO(board[0][0]) && isEmpty(board[2][2]) ){
            board[2][2] = 'O';
        }
        else if(isO(board[2][2]) && isEmpty(board[0][0]) ){
            board[0][0] = 'O';
        }
        else if(isO(board[0][2]) && isEmpty(board[2][0]) ){
            board[2][0] = 'O';
        }
        else if(isO(board[2][0]) && isEmpty(board[0][2]) ){
            board[0][2] = 'O';
        }
        return board;
    }

    private boolean canFork(char[][] board){
        return( (isO(board[0][0]) && isEmpty(board[2][2]) )
            || (isO(board[2][2]) && isEmpty(board[0][0]) )
            || (isO(board[0][2]) && isEmpty(board[2][0]) )
            || (isO(board[2][0]) && isEmpty(board[0][2]) ) );
    }

    private boolean canBlockFork(char[][] board){
        return( isX(board[0][0]) && isX(board[2][2])
                || isX(board[0][2]) && isX(board[2][0]) );
    }

    private char[][] setCenter(char[][] board){
        board[1][1] = 'O';
        return board;
    }

    private boolean canSetCenter(char[][] board){
        return (isEmpty(board[1][1]));
    }

    private char[][] setOppositeCorner(char[][] board){
        if(!isEmpty(board[0][0]) && isEmpty(board[2][2]))
            board[2][2] = 'O';
        else if(!isEmpty(board[0][2]) && isEmpty(board[2][0]))
            board[2][0] = 'O';
        else if(!isEmpty(board[2][2]) && isEmpty(board[0][0]))
            board[0][0] = 'O';
        else if(!isEmpty(board[2][0]) && isEmpty(board[0][2]))
            board[0][2] = 'O';
        return board;
    }

    private boolean canSetOppositeCorner(char[][] board){
        return (!isEmpty(board[0][0]) && isEmpty(board[2][2])
                || !isEmpty(board[0][2]) && isEmpty(board[2][0])
                || !isEmpty(board[2][2]) && isEmpty(board[0][0])
                || !isEmpty(board[2][0]) && isEmpty(board[0][2]) );
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

    private boolean isX(char c){
        return (c == 'X');
    }

    private boolean isO(char c){
        return (c == 'O');
    }
}


