package Testing;

import Main.Bot;
import Main.GameBoard;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    @Test
    void testIfBotPlacesOnEmptyCorner(){
        Bot testBot = new Bot();
        char[][] topLeftMarked = new char[3][3];
        topLeftMarked[0][0] = 'O';
        GameBoard testBoard = new GameBoard();
        char[][] test = testBot.addPhase(testBoard);
        assertEquals(test[0][0], topLeftMarked[0][0]);
    }
}