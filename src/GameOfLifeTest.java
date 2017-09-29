
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameOfLifeTest {

    private GameOfLife newGame;

    @Before
    public void setUp() {
        newGame = new GameOfLife();
    }

    @Test
    public void testAGameWithNoLiveCellsStaysThatWayAfterTick(){
        newGame.tick();
        assertEquals(0, newGame.getLiveCells().size());
    }

    @Test
    public void testACellWithNoNeighborsGetsKilledAfterTick(){
        GOLCell firstCell = new GOLCell(1,2);
        newGame.addLiveCell(firstCell);

        newGame.tick();

        assertFalse(newGame.getLiveCells().contains(firstCell));
    }

    @Test
    public void testACellWithJustOneNeighborGetsKilledAfterTick(){
        GOLCell firstCell = new GOLCell(1,2);
        newGame.addLiveCell(firstCell);
        addNewGOLCell(1,3);

        newGame.tick();

        assertFalse(newGame.getLiveCells().contains(firstCell));
    }

    @Test
    public void testACellWithJustTwoNeighborsStaysAliveAfterTick(){
        GOLCell firstCell = new GOLCell(1,3);
        newGame.addLiveCell(firstCell);
        addNewGOLCell(1, 2);
        addNewGOLCell(1, 4);

        newGame.tick();

        assertTrue(newGame.getLiveCells().contains(firstCell));
    }

    @Test
    public void testACellWithJustThreeNeighborsStaysAliveAfterTick(){
        GOLCell firstCell = new GOLCell(1, 1);
        newGame.addLiveCell(firstCell);
        addNewGOLCell(0, 0);
        addNewGOLCell(2, 1);
        addNewGOLCell(0, 2);

        newGame.tick();

        assertTrue(newGame.getLiveCells().contains(firstCell));
    }

    @Test
    public void testACellWithMoreThanThreeNeighborsDiesAfterTick(){
        GOLCell firstCell = new GOLCell(1,1);
        newGame.addLiveCell(firstCell);
        addNewGOLCell(0, 0);
        addNewGOLCell(0, 2);
        addNewGOLCell(2, 0);
        addNewGOLCell(2, 2);

        newGame.tick();

        assertFalse(newGame.getLiveCells().contains(firstCell));
    }


    private void addNewGOLCell(int xPosition, int yPosition) {
        GOLCell fourthCell = new GOLCell(xPosition, yPosition);
        newGame.addLiveCell(fourthCell);
    }


}
