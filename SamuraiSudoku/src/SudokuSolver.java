


public class SudokuSolver extends Thread{

	private int matris[][];
	int sayac=0,sayac2=0;
	int x;

	
Map2 map2;
	public SudokuSolver(int[][] matris) {
		super();
		this.matris = matris;
	}

	public SudokuSolver(int[][] matris,int x) {
		super();
		this.matris = matris;
		this.x=x;
	}




	public SudokuSolver() {
		super();
	}



	
	
	public void run() {		
	
		Map2 map = new Map2();
		map.dosyaOku();
if (x==1) {
solveSudoku(matris);
}
if (x==2) {
solveSudoku2(matris);
}
	if(solve(matris)&& solve2(matris)) {
printAnswer();
}	}







		/*Map2 map = new Map2();
		map.dosyaOku();
	
		
		if (this.solve(map.getMap1())) {
			  try {
				this.printAnswer(map.getMap1());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	/*	
		if (this.solve(map.getMap2())) {
			  try {
				this.printAnswer(map.getMap2());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		if (this.solve(map.getMap3())) {
			  try {
				this.printAnswer(map.getMap3());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		if (this.solve(map.getMap4())) {
			  try {
				this.printAnswer(map.getMap4());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		if (this.solve(map.getMap5())) {
			  try {
				this.printAnswer(map.getMap5());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }*/
	

	
	/*
public boolean solve(int[][] brd,int row,int col){
	// recrusive function that
//	int row = -1;
//	int col = -1;
	boolean isEmpty = true;
	for (int i = 0; i < brd.length; i++) {
		for (int j = 0; j < brd.length; j++) {
			
			if (brd[i][j] == 0) {
				row = i;
				col = j;
				
				isEmpty = false;
				break;
			}
		}
		
		if (!isEmpty) break;
	}
	
	if(isEmpty) {
		return true;
	}
	int i=0;
	for ( i = 1; i <= 9; i++) {
		
			
			if(isValid(brd, row, col, i)) {
				
				brd[row][col] = i;
				if(solve(brd,1,1)) {
				
					return true;
				}else {
					brd[row][col] = 0;
				}
			}
			
	}
	
	return false;
	
}

public boolean isValid(int[][] brd, int row, int col, int num) {
	//returns if the number passed is a valid solution at the row,column location of brd
	boolean isValid = true;
	for(int i = 0; i < brd.length; i++) {
		if (brd[i][col]==num) {
			isValid = false;
		}
		if (brd[row][i]==num) {
			isValid = false;
		}
	}
	
    int sqrt = (int) Math.sqrt(brd.length); 
    int boxRowStart = row - row % sqrt; 
    int boxColStart = col - col % sqrt; 
  
    for (int r = boxRowStart; 
             r < boxRowStart + sqrt; r++)  
    { 
        for (int d = boxColStart;  
                 d < boxColStart + sqrt; d++)  
        { 
            if (brd[r][d] == num)  
            {
                return false; 
            } 
        } 
    } 
	
	
	
	return isValid;
}

public void printAnswer() throws InterruptedException {
	for(int i = 0; i < 9; i++) {
	//	Thread.sleep(1000);
		System.out.println("");
		for (int j = 0; j < 9; j++) {
			//Thread.sleep(1000);
			System.out.print(matris[i][j] + " ");
		}
		
	}
	
}

public static int[][] getInput(int board[][]) throws FileNotFoundException {
	int[][] boarrd = new int[9][9];
	
	return boarrd;
	
}



public int MapbyIndex(int [][]map,int i,int j) {
	if(solve(map,1,1)) {
		try {
			printAnswer();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	return map[i][j];
}

public boolean kesisimMi(int[][] map1,int[][]map2,int[][] map5,int row, int col) {
	
		if(map1[row][col] == map2[row][col-6]) {
			
			return true;
		}
		else if(map1[row][col] == map5[row][col-3]) {
		
			return true;
		}
		else if(map2[row][col-6] == map5[row][col-3]) {
			
			return true;
		}
		else 
			return false;


}
	*/
	
	
	public int getSayac() {
		return sayac;
	}






	public void setSayac(int sayac) {
		this.sayac = sayac;
	}






	public  void solveSudoku(int [][] board) {
		if(matris == null || matris.length==0) {
			return;
		}
	      solve(board);
	}
	public  void solveSudoku2(int [][] board) {
		if(matris == null || matris.length==0) {
			return;
		}
	      solve2(board);
	}
	
	private boolean solve(int[][] board) {
	
		map2= new Map2();
		map2.dosyaOku();
		for(int i=0 ; i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j] == 0) {
					for(int c = 1; c<=9;c++) {
						if(isValid(board,i,j,c)) {
							board[i][j]=c;
							if(solve(board)) {
						
								return true;
							}
							else {
								board[i][j]=0;
							}					
								
							
						}
					}
					return false;
				}
			}
			
		}
		return true;
}
	
	private boolean solve2(int[][] board) {
		
		map2= new Map2();
		map2.dosyaOku();
		for(int i=8 ; i>=0;i--) {
			for(int j=8;j>=0;j--) {
				if(board[i][j] == 0) {
					for(int c = 1; c<=9;c++) {
						if(isValid(board,i,j,c)) {
							board[i][j]=c;
							if(solve(board)) {
						
								return true;
							}
							else {
								board[i][j]=0;
							}					
								
							
						}
					}
					return false;
				}
			}
			
		}
		return true;
}








	private boolean isValid(int [][] board,int row,int col,int c) {
		for(int i=0;i<9;i++) {
			if(board[i][col]!=0 && board[i][col] == c) {
				return false;
			}
			if(board[row][i] != 0 && board[row][i]==c) {
				return false;
			}
			if(board[3*(row/3)+i/3][3*(col/3)+i%3]!=0 && board[3*(row/3)+i/3][3*(col/3)+i%3]==c) {
				return false;
			}
		}
		return true;
	}
	


	  void printAnswer()  {
	



		for(int i = 0; i < 9; i++) {
		
			//	Thread.sleep(1000);
				System.out.println("");
				for (int j = 0; j < 9; j++) {
					//Thread.sleep(1000);
					System.out.print(matris[i][j] + " ");
				}
				
			
	}
	
		
	}

	
	
	
}
