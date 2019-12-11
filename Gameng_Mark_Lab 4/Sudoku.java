public class Sudoku{
	private int[][] grid = new int[9][9];
	
	public Sudoku(){
	}
	public Sudoku(int[][] a){
		grid = a.clone();
	}
	
	public boolean check(){
		//check the box, row, column
		
		//checks the column and row
		for(int i = 0; i < 9; i++){
			
			for(int j = 0; j < 9; j++){
				
				for(int k = j + 1; k < 9; k++){
					
					if(grid[i][j] != grid[i][k]){//checks rows
					}else{
						return false;
					}
				
					if(grid[j][i] != grid[k][i]){//checks columns
					}else{
						return false;
					}
				}
			}
		}
		//check the boxes
		int[] check = new int[9];
		for(int i = 0; i < 9; i += 3){
			
			for(int j = 0; j < 9; j += 3){
				int count = 0;
				for(int f = 0; f < 3; f++){
					
					for(int m = 0; m < 3; m++){//this and the outer for statements results in the boxes, 00,01,02,10,11,12,20,21,22 - etc
						check[count] = grid[i+m][j+f];//puts all values in one square to an array
						count += 1;
					}
				}
				if(squareCheck(check)){//checks if the square contains all the values 1-9
				}else{
					return false;
				}
			}
		}
		
		return true;
	}
	public String print(){
		String out = "";
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				out = out + grid[i][j] + " ";
			}
			out = out + "\n";
		}
		return out;
	}
	
	public boolean squareCheck(int[] box){
		int[] check = {1,1,1,1,1,1,1,1,1};
		
		for(int i = 0; i < box.length; i++){
			switch(box[i]){
				case 1: check[0] = 0; break;
				case 2: check[1] = 0; break;
				case 3: check[2] = 0; break;
				case 4: check[3] = 0; break;
				case 5: check[4] = 0; break;
				case 6: check[5] = 0; break;
				case 7: check[6] = 0; break;
				case 8: check[7] = 0; break;
				case 9: check[8] = 0; break;
			}
		}
		int count = 0;
		
		for(int i = 0; i < check.length; i++){
			count += check[i];
		}
		
		if(count == 0){
			return true;
		}else{
			return false;
		}
	}
}