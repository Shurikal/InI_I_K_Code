package sudoku;
public class MySudoku extends Sudoku {

	public void doUpdate() {
		// Berechnen Sie fuer jede Zeile, Spalte, Quadrat und Zelle, welche
		// Werte noch zulaessig sind!
		// Arbeiten Sie mit Bit-Operationen!
		// Fuehren Sie bei Bedarf weitere Methoden ein!
		System.out.println("Update!");
		int r, c, sr, sc;
		int v, w;

		// Zeilen
		for (r = 0; r < 9; r++) {
			v = 0x000; //alle M�glichkeiten
			for (c = 0; c < 9; c++) {
				w = getField(r, c);

				v = v | mask(w);
			}

			//todo
			/*for (c = 0; c < 9; c++) {

				setField(r,c,mask1(v));
				System.out.println(String.format("%x",v));
			}*/
			//endtodo

			setRow(r, ~v);
		}

		// Spalten
		for (c = 0; c < 9; c++) {
			v = 0x000; //alle M�glichkeiten
			for (r = 0; r < 9; r++) {
				w = getField(r, c);
				v = v | mask(w);
			}
			setCol(c, ~v);
		}

		// Quadrate
		for(sc = 0; sc <3; sc++){
			for(sr = 0; sr<3;sr++){
				v = 0x000; //alle M�glichkeiten
				for(c = sc*3; c<(sc+1)*3;c++){
					for(r = sr*3; r<(sr+1)*3;r++){
						w = getField(r, c);
						v = v | mask(w);
					}
				}
				setSquare(sr,sc,~v);
			}
		}


	}

	public int mask(int i){
		if(i>=0x1FF){
			return 0;
		}
		return i;

	}

	public int mask1(int i){
		if(i==0){
			return 0x1FF;
		}
		return ~i;
	}
	
	
	public static void main(String[] args) {
		new Application(args, new MySudoku());
	}

}
