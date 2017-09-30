import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CellTest {

    @Before
    public void setUp(){

    }

    @Test
    public void testTwoCellsAdyacentInTheSameRowAreNeighbors(){
        GOLCell cellOne = new GOLCell(1,0);
        GOLCell cellTwo = new GOLCell(1,1);
        assertTrue(cellOne.isNeighborOf(cellTwo));
    }

    @Test
    public void testTwoCellsNotAdyacentInTheSameRowAreNotNeighbors(){
        GOLCell cellOne = new GOLCell(1,0);
        GOLCell cellTwo = new GOLCell(1,2);
        assertFalse(cellOne.isNeighborOf(cellTwo));
    }

    @Test
    public void testTwoCellsAdyacentInTheSameColumnAreNeighbors(){
        GOLCell cellOne = new GOLCell(1,0);
        GOLCell cellTwo = new GOLCell(2,0);
        assertTrue(cellOne.isNeighborOf(cellTwo));
    }

    @Test
    public void testTwoCellsNotAdyacentInTheSameColumnAreNotNeighbors(){
        GOLCell cellOne = new GOLCell(1,0);
        GOLCell cellTwo = new GOLCell(3,0);
        assertFalse(cellOne.isNeighborOf(cellTwo));
    }

    @Test
    public void testTwoCellsAdyacentInDiagonalAreNeighbors(){
        GOLCell cellOne = new GOLCell(1,0);
        GOLCell cellTwo = new GOLCell(2,1);
        assertTrue(cellOne.isNeighborOf(cellTwo));
    }

    @Test
    public void testTwoCellsNotAdyacentInDiagonalAreNotNeighbors(){
        GOLCell cellOne = new GOLCell(1,0);
        GOLCell cellTwo = new GOLCell(3,2);
        assertFalse(cellOne.isNeighborOf(cellTwo));
    }

    @Test
    public void testWhenACellGetsAskedAboutItsAdyacentsItReturnsAllItsAdyacents(){
        GOLCell newCell = new GOLCell(1,1);
        assertEquals(9,newCell.getAdyacentCells().size());
    }
}
