import java.util.ArrayList;


public class GameOfLife {

    private ArrayList<GOLCell> liveCells;

    public GameOfLife(){
        this.liveCells = new ArrayList<GOLCell>();
    }


    public void tick(){
        ArrayList<GOLCell> afterTickCells = new ArrayList<>();
        for (GOLCell c : liveCells){
            if (shouldBeKeptAlive(c)) afterTickCells.add(c);
            }
        liveCells=afterTickCells;
    }



    private boolean shouldBeKeptAlive(GOLCell cell) {
        return getNeighbors(cell)==2 || getNeighbors(cell)==3;
    }



    public  Integer getNeighbors(GOLCell cell) {
        ArrayList<GOLCell> neighbors = new ArrayList<>();
        for (GOLCell c : liveCells){
            if (cell.isNeighborOf(c)) neighbors.add(c);
        }
        return neighbors.size();

    }

    public ArrayList<GOLCell> getLiveCells() {
        return liveCells;
    }

    public void addLiveCell(GOLCell newCell) {
        this.liveCells.add(newCell);
    }
}
