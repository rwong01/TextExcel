
public class StringCell extends Cell {
	private String input;
	public StringCell(){
		this("");
	}
	public StringCell(char input){
		this(Character.toString(input));
	}
	public StringCell(String input){
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
	public String getPrintValue(){
		return input.replace("\"", "");
	}
}
