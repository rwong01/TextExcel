
public class CellParser {
	public  Cell parseCell(String input) throws Exception{
		if(Character.toString(input.charAt(0)).equals("\"") && Character.toString(input.charAt(input.length()-1)).equals("\""))
			return new StringCell(input);
		else throw new Exception("not yet implemented") ;
	}
}
