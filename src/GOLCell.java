import java.util.ArrayList;

import static java.lang.Math.abs;

public class GOLCell {

    private final Integer row;
    private final Integer column;

    public GOLCell(Integer xPosition, Integer yPosition) {
        this.row = xPosition;
        this.column = yPosition;
    }

    public Boolean isNeighborOf(GOLCell cell) {
        return abs(cell.row - this.row)<=1 && abs(cell.column - this.column)<=1 && !((cell.row - this.row)==0 && (cell.column - this.column)==0);
    }

    public ArrayList<GOLCell> getAdyacentCells(){
        ArrayList<GOLCell> adyacents = new ArrayList<>();
        for (int i=row-1; i<=row+1;i++){
            for (int j=column-1; j<=column+1;j++){
                adyacents.add(new GOLCell(i,j));   
            }
        }
        return adyacents;
    }

	public Integer getRow() {
		return row;
	}

	public Integer getColumn() {
		return column;
	}
	
	public Boolean sameCell(GOLCell cell){
		return row==cell.getRow() && column==cell.getColumn();
	}
}
