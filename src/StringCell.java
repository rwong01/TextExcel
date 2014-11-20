
public class StringCell {
	private String data;
	public StringCell(){
		setCell("");
	}
	public StringCell(String arg){
		setCell(arg);
	}
	public void setCell(String arg){
		data=arg;
	}
	public void setCell(char arg){
		setCell(Character.toString(arg));
	}
	private String get(){
		return data;
	}
	public String getCell(){
		return get();
	}
}
