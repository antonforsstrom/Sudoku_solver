package SudokuLogic;

public class TestSudoku {
	public static void main(String[] args){
		Sudoku s = new Sudoku();
		
		s.add(0, 2, 8);
		s.add(0, 5, 9);
		s.add(0, 7, 6);
		s.add(0, 8, 2);
		
		s.add(1, 8, 5);
		
		s.add(2, 0, 1);
		s.add(2, 2, 2);
		s.add(2, 3, 5);
		
		s.add(3, 3, 2);
		s.add(3, 4, 1);
		s.add(3, 7, 9);
		
		s.add(4, 1, 5);
		s.add(4, 6, 6);
		
		s.add(5, 0, 6);
		s.add(5, 7, 2);
		s.add(5, 8, 8);
		
		s.add(6, 0, 4);
		s.add(6, 1, 1);
		s.add(6, 3, 6);
		s.add(6, 5, 8);
		
		s.add(7, 0, 8);
		s.add(7, 1, 6);
		s.add(7, 4, 3);
		s.add(7, 6, 1);
		
		s.add(8, 6, 4);
		

//		System.out.println(s.add(0, 0, 1));
//		System.out.println(s.add(1, 1, 1));
//		System.out.println(s.add(3, 3, 3));
//		System.out.println(s.add(1, 2, 1));
//		System.out.println(s.add(4, 4, 3));
		
		if(s.solve()){
			System.out.println("Systemet har lösning:");
			System.out.print(s);
		} else {
			System.out.println("Systemet har ingen lösning");
		}
		
		
	}
}
