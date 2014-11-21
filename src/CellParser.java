
public class CellParser {
	public static Cell parseCell(String input) throws Exception{
		if(Character.toString(input.charAt(0))=="\"" && Character.toString(input.charAt(input.length-1))=="\"")
			return new StringCell(input);
	}
}
