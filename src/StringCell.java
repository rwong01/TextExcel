
public class StringCell extends Cell {
	private String input;
	private StringCell(){
		StringCell("");
	}
	StringCell(String input){
		this.input=input;
	}
	public void setCell(String arg){
		input=arg;
	}
	public void setCell(char arg){
		setCell(Character.toString(arg));
	}
	public String getInputValue(){
		return input;
	}
	
}
