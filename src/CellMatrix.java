public class CellMatrix {
	int rows;
	int columns;
	Cell[][] data;
public CellMatrix(){
	this(10,7);
}
public CellMatrix(int r, int c) { 
	rows=r+1;
	columns=c+1;
	data=new Cell[rows][columns]; //initialize array of Cells
	for(int i=0;i<rows;i++){
		for(int j=0;j<columns;j++){
			data[i][j]= new Cell(); //initialize each Cell
		}
	}
	fillTableHeader();
}
private void fillTableHeader(){
	String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	if(columns>27) 
		columns=27; //display max 26 columns usable columns
	for(int i=1;i<columns;i++){
		data[0][i].setCell(alpha.charAt(i-1)); //fill first row with alphabet
	}
	for(int i=1;i<rows;i++){
		data[i][0].setCell(Integer.toString(i)); //fill first column with integers
	}
}
private static void print(CellMatrix matrix){
	for (int i=0;i<matrix.rows;i++){
		for(int j=0;j<matrix.columns;j++){
			System.out.print(matrix.[i][j].get());
			System.out.print("|");
		}
			System.out.println();
		for(int j=0;j<matrix.columns;j++){
			for(int k=0;k<12;k++){
				System.out.print("-");
			}
				System.out.print("+");
		}
			System.out.println();
	}
}
public static void printSheet(CellMatrix matrix){
	print(matrix);
}
private static void clear(CellMatrix matrix){
	for (int i=1;i<matrix.rows;i++){
		for(int j=1;j<matrix.columns;j++){
			matrix.data[i][j].clearCell();
		}
	}	
}
public static void clearAll(CellMatrix matrix){
	clear(matrix);
}
private void set(int row, int column, String data){
	data[row][column+1].setCell(data);
}
public void setCell(int row, int column, String data){
	set(row, column, data);
}
public void setCell(int row, char column, String data){
	setCell(row,column-'A',data);
}
}

