package org.unioulu.tol.sqatlab.gameoflife;

import java.util.HashSet;
import java.util.Set;

public class Grid {
	public Set<Cell> cells;
	
	public Grid(){
		
		cells = new HashSet<>();
	}

	
	public int getNumNeighbors(Cell cell) {
		int numNeighbors = 0;
	
		for (int dx=-1; dx<=1; dx ++) {
			for (int dy=-1; dy<=1; dy ++) {
				Cell neighbor = new Cell("Alive",cell.x + dx, cell.y + dy);
				if (cells.contains(neighbor)) {
					numNeighbors++;
				} 
			}
		}
		
		if(cell.getState().equals("Alive")){
			return numNeighbors-1;
		}
		return numNeighbors;
	}
	public void addCell(Cell cell) {
		cells.add(cell);		
	}


	public void fillGrid(int gridSize) {
		int counter = 0;
		Cell[] cellArray = new Cell[gridSize*gridSize];
		for(int i = 0; i < gridSize; i++){
			for(int j = 0; j < gridSize; j++){
				cellArray[counter] = new Cell("Alive", i, j);
				addCell(cellArray[counter]);
				counter++;
			}
		}
		if(checkPercentageOfAliveCells()) fillGrid(gridSize);
	}


	public int getNumAliveCells() {
		int numAliveCells = 0;
		
		for(int i = 0; i < cells.size(); i++){
			for(int j = 0; j < cells.size(); j++){
				Cell aliveCell = new Cell("Alive", i, j);
				if (cells.contains(aliveCell)) 
					numAliveCells++;
			}
		}
		return numAliveCells;
	}


	public boolean checkPercentageOfAliveCells() {
		double percentageOfAliveCells = 0;
		percentageOfAliveCells = getNumAliveCells()*100/cells.size();
		//System.out.println(getNumAliveCells() + " " + cells.size() + " = " + percentageOfAliveCells);
		if(percentageOfAliveCells>60 || percentageOfAliveCells<40)return false;
		else return true;
	}

}
