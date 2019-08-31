package Testing;

import Main.Bot;
import Main.GameBoard;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BotTest {

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