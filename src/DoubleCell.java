
public class DoubleCell extends Cell{
	private double input;
	public DoubleCell(double input){
		this.input=input;
	}
	public void setCell(double arg){
		input=arg;
	}
	public String getInputValue(){
		return String.valueOf(input);
	}
	public String getPrintValue(){
		return String.valueOf(input);
	}
}
