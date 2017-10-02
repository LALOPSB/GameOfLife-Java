import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public ArrayList<GOLCell> getAdjacentCells(){
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
	
	@Override
	public boolean equals(Object cell){
		return row==((GOLCell) cell).getRow() && column==((GOLCell) cell).getColumn();
	}

}
