package SudokuLogic;

public class Sudoku {
	private int[][] board;
	
	public Sudoku(){
		board = new int[9][9]; 
	}
	
	/**
	 * Adds value between 1 and 9 to specified cell i sudoku
	 * @param row index for insert
	 * @param col index for insert 
	 * @param value to be inserted
	 */
	public void add(int row, int col, int value){
		
			board[row][col] = value;
	
	}
	
	
	//Checks that insertion does not violate sudoku constraints.
	private boolean isValid(int row, int col, int value){
		if(rowContains(row, col, value)){
			return false;
		}
		
		if(columnContains(row, col, value)){
			return false;
		}
		
		if(squareContains(row, col, value)){
			return false;
		}
		
		return true;
	}
	
	
	// Checks if row contains value 
	private boolean rowContains(int row, int col, int value){
		for(int i = 0; i < 9; i++){
			if(i != col && value == board[row][i]){
				return true;
			}
		}
		return false; 
	}
	
	
	//Checks if column contains value 
	private boolean columnContains(int row, int col, int value){
		for(int i = 0; i < 9; i++){
			if(i != row && value == board[i][col]){
				return true;
			}
		}
		return false; 
	}
	
	/*
	 * Checks if square contains value
	 */
	private boolean squareContains(int row, int col, int value){
		int startRow = (row/3)*3;
		int startCol = (col/3)*3;
		
		for(int i = startRow; i < startRow + 3; i++){
			for(int k = startCol; k < startCol + 3; k++){
				if(!(i == row && k == col) && value == board[i][k]){
					return true;
				}
			}
		}
		return false; 
	}
	
	//Checks that entered board is allowed
	private boolean isAllowed() {
		for(int i = 0; i < 9; i++){
			for(int k = 0; k < 9; k++){
				int value = board[i][k];
				if(value != 0 && !isValid(i, k, value)){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Gets value of specified index
	 * @param row index of row
	 * @param col index of column
	 * @return
	 */
	public int getValue(int row, int col){
		return board[row][col];
	}
	
	/**
	 * Clears the sudoku
	 */
	public void clear(){
		for(int i = 0; i < 9; i++){
			for(int k = 0; k < 9; k++){
				board[i][k] = 0;
			}
		}
	}
	
	/**
	 * Solves the sudoku using recursive methods
	 */
	public boolean solve(){
		if(isAllowed()){
			return solve(0, 0);
		} else {
			return false; 
		}
		
	}
	
	/**
	 * Recursive help method using backtracking to solve the sudoku
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean solve(int row, int col){
		//Check if we need to switch row or are finished
		if(col > 8){
			col = 0;
			row++;
			if(row > 8){
				return true;
			}
		}
		
		//Check if value in cell already exists
		if(board[row][col] != 0){
			if(isValid(row, col, board[row][col])){
				return solve(row, col + 1);
			} else {
				return false;
			}
		
		//If cell is empty	
		} else {
			
			for(int i = 1; i < 10; i++){	
				if(isValid(row, col, i)){
					board[row][col] = i;
					if(solve(row, col + 1)){
						return true;
					}
				}	
			}
			
//			for(int i = 1; i < 10; i++){	
//				if(add(row, col, i)){
//					if(solve(row, col + 1)){
//						return true;
//					}
//				}	
//			}
			board[row][col] = 0;
			return false;
		}
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++){
			for(int k = 0; k < 9; k++){
				sb.append((board[i][k] + " "));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
		
}
