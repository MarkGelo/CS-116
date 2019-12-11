public class SudokuApp{
	public static void main(String[] args){
		int[][] sudo = new int[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				sudo[i][j] = (int)(Math.random() * (9) + 1);
			}
		}
		Sudoku grid = new Sudoku(sudo);
		if(grid.check()){
			System.out.println("nice");
			System.out.print(grid.print());
		}else{
			System.out.println("no");
		}
	}
}