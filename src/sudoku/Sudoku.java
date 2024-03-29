package sudoku;
public class Sudoku {
	
	public static Sudoku game;
	
	public SudokuGamefield gamefield;
	
	public boolean automaticUpdate; 
	
	private boolean changed2One;
	
	private int[] rows;
	private int[] cols;
	private int[][] squares;
	private int[][] fields;
	private boolean[][] enteredByUser;
	
	
	public Sudoku() {
		game = this; 
		int i, j;
		
		gamefield = null;
		automaticUpdate = false;
		
		rows = new int[9];
		cols = new int[9];
		for (i = 0; i < 9; i++) {
			rows[i] = 0x1FF;
			cols[i] = 0x1FF;
		}
		
		squares = new int[3][];
		for (i = 0; i < 3; i++) {
			squares[i] = new int[3];
			for (j = 0; j < 3; j++) {
				squares[i][j] = 0x1FF;
			}
		}

		fields = new int[9][];
		enteredByUser = new boolean[9][];
		for (i = 0; i < 9; i++) {
			fields[i] = new int[9];
			enteredByUser[i] = new boolean[9];
			for (j = 0; j < 9; j++) {
				fields[i][j] = 0x1FF;
				enteredByUser[i][j] = false;
			}
		}
	}
	
	
	public boolean loadGame(String filename) {
		In.open(filename);
		if (!In.done()) return false;
		
		for (int i = 0; i < 9*9; i++) {
			int v = In.readInt();
			if (!In.done()) return false;
			fields[i/9][i%9] = v > 0 ? 1 << (v - 1) : 0x1FF;
			enteredByUser[i/9][i%9] = v != 0;
		}
		
		update();
		return true;
	}
	
	public void storeGame() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print("" + getField(i, j) + "\t");
			}
			System.out.println();
		}
	}
	
	
	public int getField(int row, int col){
		return fields[row][col];
	}
	public void setField(int row, int col, int val){
		if (fields[row][col] == val) return;
		
		fields[row][col] = val;
		if (val > 0 && (val & (val-1)) == 0) changed2One = true;
	}
	
	public int getRow(int row){
		return rows[row];
	}
	public void setRow(int row, int val){
		rows[row] = val;
	}

	public int getCol(int col){
		return cols[col];
	}
	public void setCol(int col, int val){
		cols[col] = val;
	}

	public int getSquare(int row, int col){
		return squares[row][col];
	}
	public void setSquare(int row, int col, int val){
		squares[row][col] = val;
	}
	

	public boolean getEnteredByUser(int row, int col){
		return enteredByUser[row][col];
	}
	public void setEnteredByUser(int row, int col, boolean val){
		enteredByUser[row][col] = val;
	}
	
	
	public void update() {
		if (gamefield == null) return;

		int i = 1;
		do {
			changed2One = false;
			doUpdate();
			i++;
		} while (automaticUpdate && changed2One);
		
		gamefield.update();
	}

	public void doUpdate() {
		//wird von Unterklassen �berschrieben
	}

}
