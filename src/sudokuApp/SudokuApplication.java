package sudokuApp;

import SudokuLogic.Sudoku;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SudokuApplication extends Application {
	private Sudoku sudokuBoard;
	
	/**
	 * Creates the user interface from which the sudoku is inserted and solved
	 */
	@Override
	public void start(Stage stage) throws Exception {
		sudokuBoard = new Sudoku();
		SudokuGUI s = new SudokuGUI(sudokuBoard);
		
		Scene scene = new Scene(s.getRoot());
		stage.setTitle("Sudoku");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[]args) {
		launch(args);
	}

}
