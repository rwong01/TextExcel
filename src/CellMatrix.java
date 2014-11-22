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
		data[0][i]=new StringCell(alpha.charAt(i-1));//fill first row with alphabet
	}
	for(int i=1;i<rows;i++){
		data[i][0]=new StringCell(Integer.toString(i)); //fill first column with integers
	}
}
private static void print(CellMatrix matrix){
	for (int i=0;i<matrix.rows;i++){
		for(int j=0;j<matrix.columns;j++){
			System.out.print(printFormat(matrix.data[i][j].getPrintValue()));
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
private void set(int row, int column, String input){
	CellParser parser=new CellParser();
	try {
		data[row][column+1]=parser.parseCell(input);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void setCell(int row, int column, String data){
	set(row, column, data);
}
public void setCell(int row, char column, String data){
	set(row,column-'A',data);
}
private static String printFormat(String input){
	String cellPrint="";
	if(input.length()>12){
		input=input.substring(0, 12);
	}
	for(int i=0;i<(12-input.length())/2;i++){
		cellPrint+=" ";
	}
	cellPrint+=input;
	for(int i=0;i<(12-input.length()+1)/2;i++){
		cellPrint+=" ";
	}
	return cellPrint;
}
public String getCell(int row, int column){
	return data[row][column+1].getInputValue();
}
public String getCell(int row, char column){
	return getCell(row,column-'A');
}
}

