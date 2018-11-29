package sudokuApp;

import SudokuLogic.Sudoku;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;


public class SudokuGUI {
	private Sudoku sudokuBoard;
	private BorderPane root;
	private LetterTextField[][] field; //need this?
	
	/**
	 * Constructs the object SudokuGUI.
	 * @param The sudoku to be used
	 */
	public SudokuGUI (Sudoku s) {
		sudokuBoard = s;
		
		field = new LetterTextField[9][9];
		
		root = new BorderPane();
		root.setCenter(createGrid()); //Creates sudoku fields
		root.setBottom(createButtons()); //Creates solve and clear buttons in buttom
	}
	
	//returns TilePane with TextFields for numbers
	private TilePane createGrid() {
		TilePane board = new TilePane();
		board.setPrefRows(9);
		board.setPrefColumns(9);
		board.setPadding(new Insets(3,3,3,3));
		board.setHgap(3); //Horisontal gap between tiles
		board.setVgap(3); //Vertical gap between tiles
		
		//Creates and colors tiles
		for(int i = 0; i < 9; i++){
			for(int k = 0; k < 9; k++){
				LetterTextField text = new LetterTextField();
				text.setPrefColumnCount(1);
				
				if(!(i/3 == 1 || k/3 == 1) || (i/3 == 1 && k/3 == 1)){
					text.setStyle("-fx-background-color: #daa520;");	
				}
				
				field[i][k] = text;
				board.getChildren().add(text);
			}
		}		
		return board;
	}
	
	//returns a HBox with buttons for solve and clear
	private HBox createButtons() {
		Button solve = new Button("Solve");
		Button clear = new Button("Clear");
		Button quit = new Button("Quit");
		
		solve.setStyle("-fx-font: 12 arial; -fx-base: #336699;");
		clear.setStyle("-fx-font: 12 arial; -fx-base: #336699;");
		quit.setStyle("-fx-font: 12 arial; -fx-base: #336699;");
		
		solve.setOnAction(e -> solve());
		clear.setOnAction(e -> clear());
		quit.setOnAction(e -> quit());
		
		HBox buttons = new HBox();
		buttons.setSpacing(20);
		buttons.setPadding(new Insets(20,20,20,20));
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(solve, clear, quit);
		buttons.setStyle("-fx-background-color: #DCDCDC;");
		
		return buttons;
	}
	
	//Solves the sudoku and presents solution in GUI
	private void solve() {
		//reads values from board
		for(int i = 0; i < 9; i++){
			for(int k = 0; k < 9; k++){
				String value = field[i][k].getText();
				if(value.length() > 0){
					sudokuBoard.add(i, k, Integer.valueOf(value));
				} else {
					sudokuBoard.add(i, k, 0);
				}
			}
		}
		
		if(sudokuBoard.solve()){
			//presents the solution
			for(int i = 0; i < 9; i++){
				for(int k = 0; k < 9; k++){
					field[i][k].setText(String.valueOf(sudokuBoard.getValue(i, k)));
				}
			}
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(null);
			alert.setHeaderText(null);
			alert.setContentText("The entered board has no solution");
			alert.showAndWait();
		}
		
	}
	
	//Clears the sudoku and empties board in GUI
	private void clear() {
		for(int i = 0; i < 9; i++){
			for(int k = 0; k < 9; k++){
				field[i][k].clear();
				sudokuBoard.clear();
			}
		}
	}
	
	//Quits the program
	private void quit() {
		Platform.exit();
	}
	
	/**
	 * returns the root of the Sudoku GUI 
	 * @return BorderPane root
	 */
	public BorderPane getRoot() {
		return root;
	}

}
