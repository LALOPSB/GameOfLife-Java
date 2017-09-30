import java.util.ArrayList;
import java.util.stream.Collectors;



public class GameOfLife {

    private ArrayList<GOLCell> liveCells;

    public GameOfLife(){
        this.liveCells = new ArrayList<GOLCell>();
    }


    public void tick(){
    ArrayList<GOLCell> cellsKeptAlive = keptAliveAfterTick();
    ArrayList<GOLCell> newLiveSet2 = liveAdyacentsAfterTick(adyacentCells());
    cellsKeptAlive.addAll(newLiveSet2);
    setLiveCells(cellsKeptAlive);
    }


	private void setLiveCells(ArrayList<GOLCell> cellsKeptAlive) {
		this.liveCells=cellsKeptAlive;
	}

	private ArrayList<GOLCell> keptAliveAfterTick(){
		return (ArrayList<GOLCell>) liveCells
				.stream()
				.filter(c -> shouldBeKeptAlive(c)).collect(Collectors.toList());
	}
	
	private ArrayList<GOLCell> adyacentCells(){
		ArrayList<GOLCell> adyacents = new ArrayList<>();
		liveCells.forEach((c) -> adyacents.addAll(c.getAdyacentCells()));
		return adyacents;
	}
	
    private ArrayList<GOLCell> liveAdyacentsAfterTick(ArrayList<GOLCell> adyacents){
    	ArrayList<GOLCell> finalAlive = new ArrayList<>();
    	for (GOLCell c : adyacents){
    		if (getNeighbors(c)==3){
    			addIfItDoesntExist(c, finalAlive);
    		}
    	}
    	return finalAlive;
    }

    private boolean shouldBeKeptAlive(GOLCell cell) {
        return getNeighbors(cell)==2 || getNeighbors(cell)==3;
    }


    private Integer getNeighbors(GOLCell cell){
		return ((ArrayList<GOLCell>) liveCells
				.stream()
				.filter(c -> cell.isNeighborOf(c)).collect(Collectors.toList()))
				.size();
	}

    private ArrayList<GOLCell> addIfItDoesntExist(GOLCell newCell, ArrayList<GOLCell> cells){
    	cells.removeIf(c -> c.sameCell(newCell));
    	cells.add(newCell);
    	return cells;
    }
    
    public ArrayList<GOLCell> getLiveCells() {
        return liveCells;
    }

    public void addLiveCell(GOLCell newCell) {
    	addIfItDoesntExist(newCell, liveCells);
    }
    
    /*private ArrayList<GOLCell> keptAliveAfterTick() {
	ArrayList<GOLCell> afterTickCells = new ArrayList<>();
    for (GOLCell c : liveCells){
        if (shouldBeKeptAlive(c)) afterTickCells.add(c);
        }
	return afterTickCells;
	}
    
    private ArrayList<GOLCell> adyacentCells(){
	ArrayList<GOLCell> adyacents = new ArrayList<>();
	for (GOLCell c : liveCells){
		adyacents.addAll(c.getAdyacentCells());
	}
	return adyacents;
	}
    
    private  Integer getNeighbors(GOLCell cell) {
    ArrayList<GOLCell> neighbors = new ArrayList<>();
    for (GOLCell c : liveCells){
        if (cell.isNeighborOf(c)) neighbors.add(c);
    }
    return neighbors.size();

	}
    
    private ArrayList<GOLCell> addIfItDoesntExist(GOLCell newCell, ArrayList<GOLCell> cells){
	for (GOLCell c : cells){
		if (c.sameCell(newCell)) {
			cells.remove(c);
			break;
		}
	}
	cells.add(newCell);
	return cells;
    }*/


    
}
