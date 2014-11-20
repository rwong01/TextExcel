/**
 * TextExcel Project
 * @date 11/10/14
 * @author Rebecca
 *
 */
import java.util.*;

public class TextExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Welcome to TextExcel!");
//		System.out.print("Enter rows:");
//		int rows=input.nextInt();
//		System.out.print("Enter columns (up to 26):");
//		int columns=input.nextInt();
		CellMatrix matrix=new CellMatrix();
		System.out.print("Enter command:");
		String userInput=input.nextLine();
		while(!userInput.equals("quit")){
			checkInput(userInput, matrix);
			System.out.print("Enter command:");
			userInput=input.nextLine();
		}
		input.close();
	}

	public static void checkInput(String userInput, CellMatrix matrix) {
		// TODO Auto-generated method stub
		if(userInput.equals("print"))
			CellMatrix.printSheet(matrix);
		else if(userInput.equals("clear sheet"))
			CellMatrix.clearAll(matrix);
		else if(userInput.equals("help")){
			System.out.println("print: prints entire excel sheet");
			System.out.println("clear sheet: clears entire excel sheet");	
		}
		else{
			String[] command=userInput.split(" ");
			char cellAddrColumn=command[0].charAt(0);
			int cellAddrRow=Character.getNumericValue(command[0].charAt(1));
			String data=command[2];
			System.out.println(Arrays.toString(command));
			matrix.setCell(cellAddrRow, cellAddrColumn, data);
		}
	}
}

