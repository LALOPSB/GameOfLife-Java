import java.util.ArrayList;
import java.util.stream.Collectors;



public class GameOfLife {

    private ArrayList<GOLCell> liveCells;

    public GameOfLife(){
        this.liveCells = new ArrayList<GOLCell>();
    }

    public void tick(){
    ArrayList<GOLCell> cellsKeptAlive = keptAliveAfterTick();
    ArrayList<GOLCell> newLiveSet2 = liveAdjacentsAfterTick(adjacentCells());
    cellsKeptAlive.addAll(newLiveSet2);
    liveCells = cellsKeptAlive;
    }

	private ArrayList<GOLCell> keptAliveAfterTick(){
		return (ArrayList<GOLCell>) liveCells
				.stream()
				.filter(c -> shouldBeKeptAlive(c)).collect(Collectors.toList());
	}
	
	private ArrayList<GOLCell> adjacentCells(){
		ArrayList<GOLCell> adyacents = new ArrayList<>();
		liveCells.forEach((c) -> adyacents.addAll(c.getAdjacentCells()));
		return adyacents;
	}
	
    private ArrayList<GOLCell> liveAdjacentsAfterTick(ArrayList<GOLCell> adyacents){
    	ArrayList<GOLCell> finalAlive = new ArrayList<>();
    	for (GOLCell c : adyacents){
    		if (getNumberOfNeighbors(c)==3){
    			addIfItDoesntExist(c, finalAlive);
    		}
    	}
    	return finalAlive;
    }
    

    private boolean shouldBeKeptAlive(GOLCell cell) {
        return getNumberOfNeighbors(cell)==2 || getNumberOfNeighbors(cell)==3;
    }


    private Integer getNumberOfNeighbors(GOLCell cell){
		return ((ArrayList<GOLCell>) liveCells
				.stream()
				.filter(c -> cell.isNeighborOf(c)).collect(Collectors.toList()))
				.size();
	}
    
    public ArrayList<GOLCell> getLiveCells() {
        return liveCells;
    }

    public void addLiveCell(GOLCell newCell) {
    	addIfItDoesntExist(newCell, liveCells);
    }  
    
    private ArrayList<GOLCell> addIfItDoesntExist(GOLCell newCell, ArrayList<GOLCell> cells){
    	if (!cells.contains(newCell)) cells.add(newCell);
    	return cells;
    }
}
