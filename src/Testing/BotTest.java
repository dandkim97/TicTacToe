package Testing;

import Main.Bot;
import Main.GameBoard;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    @Test
    void testIfBotWins(){
        Bot testBot = new Bot();
        char[][] winExpected = new char[3][3];
        winExpected[1][2] = 'O';
        GameBoard testBoard = new GameBoard();
        testBoard.add(0,0);
        testBoard.add(1,1);
        testBoard.add(2,2);
        testBoard.add(1,0);
        testBoard.add(2,0);
        testBoard.setBoard(testBot.addPhase(testBoard));
        char[][] test = testBoard.getBoard();
        assertEquals(test[1][2], winExpected[1][2]);
    }

    @Test
    void testIfBotBlocksDiagonals(){
        Bot testBot = new Bot();
        char[][] blockExpected = new char[3][3];
        blockExpected[2][2] = 'O';
        GameBoard testBoard = new GameBoard();
        testBoard.add(0,0);
        testBoard.add(0,1);
        testBoard.add(1,1);
        testBoard.setBoard(testBot.addPhase(testBoard));
        char[][] test = testBoard.getBoard();
        assertEquals(test[2][2], blockExpected[2][2]);
    }

    @Test
    void testIfBotForks(){
        Bot testBot = new Bot();
        char[][] forkExpected = new char[3][3];
        forkExpected[2][2] = 'O';
        GameBoard testBoard = new GameBoard();
        testBoard.add(0,1);
        testBoard.add(0,0);
        testBoard.add(2,0);
        testBoard.setBoard(testBot.addPhase(testBoard));
        char[][] test = testBoard.getBoard();
        assertEquals(test[2][2], forkExpected[2][2]);
    }


    @Test
    void testIfBotBlocksFork(){
        Bot testBot = new Bot();
        char[][] blockForkExpected = new char[3][3];
        blockForkExpected[0][1] = 'O';
        GameBoard testBoard = new GameBoard();
        testBoard.add(0,0);
        testBoard.add(1,1);                     // the bot will place center.
        testBoard.add(2,2);
        testBoard.setBoard(testBot.addPhase(testBoard));
        char[][] test = testBoard.getBoard();
        assertEquals(test[0][1], blockForkExpected[0][1]);
    }

    @Test
    void testIfBotPlacesOnCenter(){
        Bot testBot = new Bot();
        char[][] centerExpected = new char[3][3];
        centerExpected[1][1] = 'O';
        GameBoard testBoard = new GameBoard();
        testBoard.add(0,0);
        char[][] test = testBot.addPhase(testBoard);
        assertEquals(test[1][1], centerExpected[1][1]);
    }

    @Test
    void testIfBotPlacesOnOppositeCorner(){
        Bot testBot = new Bot();
        char[][] botRightExpected = new char[3][3];
        botRightExpected[2][2] = 'O';
        GameBoard testBoard = new GameBoard();
        testBoard.add(0,0);
        char[][] test = testBot.addPhase(testBoard);
        assertEquals(test[2][2], botRightExpected[2][2]);
    }

    @Test
    void testIfBotPlacesOnEmptyCorner(){
        Bot testBot = new Bot();
        char[][] topLeftExpected = new char[3][3];
        topLeftExpected[0][0] = 'O';
        GameBoard testBoard = new GameBoard();
        char[][] test = testBot.addPhase(testBoard);
        assertEquals(test[0][0], topLeftExpected[0][0]);
    }
}