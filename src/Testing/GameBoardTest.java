package Testing;

import Main.GameBoard;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

/*========================================================
* =================== ROWS CHECK =========================
* ========================================================*/
    @Test
    void checkRow0WorksTest() {
        GameBoard gb = new GameBoard();
        char[][] testBoard = gb.getBoard();
        testBoard[0][0] = 'X';
        testBoard[0][1] = 'X';
        testBoard[0][2] = 'X';
        assertTrue(gb.gameOver());
        testBoard[0][0] = 'X';
        testBoard[0][1] = 'O';
        testBoard[0][2] = 'X';
        assertFalse(gb.gameOver());
        testBoard[0][0] = 'O';
        testBoard[0][1] = 'O';
        testBoard[0][2] = 'O';
        assertTrue(gb.gameOver());
        testBoard[0][0] = 'O';
        testBoard[0][1] = 'O';
        testBoard[0][2] = 'X';
        assertFalse(gb.gameOver());
    }
    @Test
    void checkRow1WorksTest() {
        GameBoard gb = new GameBoard();
        char[][] testBoard = gb.getBoard();
        testBoard[1][0] = 'X';
        testBoard[1][1] = 'X';
        testBoard[1][2] = 'X';
        assertTrue(gb.gameOver());
        testBoard[1][0] = 'X';
        testBoard[1][1] = 'O';
        testBoard[1][2] = 'X';
        assertFalse(gb.gameOver());
        testBoard[1][0] = 'O';
        testBoard[1][1] = 'O';
        testBoard[1][2] = 'O';
        assertTrue(gb.gameOver());
        testBoard[1][0] = 'O';
        testBoard[1][1] = 'O';
        testBoard[1][2] = 'X';
        assertFalse(gb.gameOver());
    }
    @Test
    void checkRow2WorksTest() {
        GameBoard gb = new GameBoard();
        char[][] testBoard = gb.getBoard();
        testBoard[2][0] = 'X';
        testBoard[2][1] = 'X';
        testBoard[2][2] = 'X';
        assertTrue(gb.gameOver());
        testBoard[2][0] = 'X';
        testBoard[2][1] = 'O';
        testBoard[2][2] = 'X';
        assertFalse(gb.gameOver());
        testBoard[2][0] = 'O';
        testBoard[2][1] = 'O';
        testBoard[2][2] = 'O';
        assertTrue(gb.gameOver());
        testBoard[2][0] = 'O';
        testBoard[2][1] = 'O';
        testBoard[2][2] = 'X';
        assertFalse(gb.gameOver());
    }
/*========================================================
* =================== COLUMNS CHECK ======================
* ========================================================*/
    @Test
    void checkColumn0WorksTest() {
        GameBoard gb = new GameBoard();
        char[][] testBoard = gb.getBoard();
        testBoard[0][0] = 'X';
        testBoard[1][0] = 'X';
        testBoard[2][0] = 'X';
        assertTrue(gb.gameOver());
        testBoard[0][0] = 'X';
        testBoard[1][0] = 'O';
        testBoard[2][0] = 'X';
        assertFalse(gb.gameOver());
        testBoard[0][0] = 'O';
        testBoard[1][0] = 'O';
        testBoard[2][0] = 'O';
        assertTrue(gb.gameOver());
        testBoard[0][0] = 'O';
        testBoard[1][0] = 'O';
        testBoard[2][0] = 'X';
        assertFalse(gb.gameOver());
    }
    @Test
    void checkColumn1WorksTest() {
        GameBoard gb = new GameBoard();
        char[][] testBoard = gb.getBoard();
        testBoard[0][1] = 'X';
        testBoard[1][1] = 'X';
        testBoard[2][1] = 'X';
        assertTrue(gb.gameOver());
        testBoard[0][1] = 'X';
        testBoard[1][1] = 'O';
        testBoard[2][1] = 'X';
        assertFalse(gb.gameOver());
        testBoard[0][1] = 'O';
        testBoard[1][1] = 'O';
        testBoard[2][1] = 'O';
        assertTrue(gb.gameOver());
        testBoard[0][1] = 'O';
        testBoard[1][1] = 'O';
        testBoard[2][1] = 'X';
        assertFalse(gb.gameOver());
    }
    @Test
    void checkColumn2WorksTest() {
        GameBoard gb = new GameBoard();
        char[][] testBoard = gb.getBoard();
        testBoard[0][2] = 'X';
        testBoard[1][2] = 'X';
        testBoard[2][2] = 'X';
        assertTrue(gb.gameOver());
        testBoard[0][2] = 'X';
        testBoard[1][2] = 'O';
        testBoard[2][2] = 'X';
        assertFalse(gb.gameOver());
        testBoard[0][2] = 'O';
        testBoard[1][2] = 'O';
        testBoard[2][2] = 'O';
        assertTrue(gb.gameOver());
        testBoard[0][2] = 'O';
        testBoard[1][2] = 'O';
        testBoard[2][2] = 'X';
        assertFalse(gb.gameOver());
    }
/*========================================================
* =================== DIAGONALS CHECK ====================
* ========================================================*/
    @Test
    void checkDiagonalTopLeftToBottomRightTest() {
        GameBoard gb = new GameBoard();
        char[][] testBoard = gb.getBoard();
        testBoard[0][0] = 'X';
        testBoard[1][1] = 'X';
        testBoard[2][2] = 'X';
        assertTrue(gb.gameOver());
        testBoard[0][0] = 'X';
        testBoard[1][1] = 'O';
        testBoard[2][2] = 'X';
        assertFalse(gb.gameOver());
        testBoard[0][0] = 'O';
        testBoard[1][1] = 'O';
        testBoard[2][2] = 'O';
        assertTrue(gb.gameOver());
        testBoard[0][0] = 'O';
        testBoard[1][1] = 'O';
        testBoard[2][2] = 'X';
        assertFalse(gb.gameOver());
    }
    @Test
    void checkDiagonalTopRightToBottomLeftTest() {
        GameBoard gb = new GameBoard();
        char[][] testBoard = gb.getBoard();
        testBoard[2][2] = 'X';
        testBoard[1][1] = 'X';
        testBoard[0][0] = 'X';
        assertTrue(gb.gameOver());
        testBoard[2][2] = 'X';
        testBoard[1][1] = 'O';
        testBoard[0][0] = 'X';
        assertFalse(gb.gameOver());
        testBoard[2][2] = 'O';
        testBoard[1][1] = 'O';
        testBoard[0][0] = 'O';
        assertTrue(gb.gameOver());
        testBoard[2][2] = 'O';
        testBoard[1][1] = 'O';
        testBoard[0][0] = 'X';
        assertFalse(gb.gameOver());
    }
}