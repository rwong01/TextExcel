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
		Scanner scanIn=new Scanner(System.in);
		System.out.println("Welcome to TextExcel!");
//		System.out.print("Enter rows:");
//		int rows=input.nextInt();
//		System.out.print("Enter columns (up to 26):");
//		int columns=input.nextInt();
		CellMatrix matrix=new CellMatrix();
		System.out.print("Enter command:");
		String userInput=scanIn.nextLine();
		while(!userInput.equals("exit")){
			checkInput(userInput, matrix);
			System.out.print("Enter command:");
			userInput=scanIn.nextLine();
		}
		System.out.println("Exiting TextExcel");
		scanIn.close();
	}

	private static void checkInput(String input, CellMatrix matrix) {
		// TODO Auto-generated method stub
		String cellIdRegex="[A-G](10|[1-9])";
		if(input.equals("print"))
			CellMatrix.printSheet(matrix);
		else if(input.matches(cellIdRegex)){
			char cellAddrColumn=input.charAt(0);
			int cellAddrRow=Character.getNumericValue(input.charAt(1));
			System.out.println(input+" = "+matrix.getCell(cellAddrRow, cellAddrColumn));
		}
		else if(input.length()>5 && input.substring(0, 5).matches(cellIdRegex+" = ")){
			String[] command=input.split(" ");
			char cellAddrColumn=command[0].charAt(0);
			int cellAddrRow=Character.getNumericValue(command[0].charAt(1));
			String data=command[2];
			System.out.println(Arrays.toString(command));
			matrix.setCell(cellAddrRow, cellAddrColumn, data);
		}
		else
			System.out.println("Not Valid Input");
	}
	
}

