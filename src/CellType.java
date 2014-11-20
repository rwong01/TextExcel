
public class CellType {
	public CellType getType(String input){
		if(input.matches("[ABC]")){
			return StringCell;
		}
	}
}
