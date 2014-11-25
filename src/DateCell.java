import java.text.SimpleDateFormat;
import java.util.*;

public class DateCell extends Cell{
	SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
	private Date input;
	public DateCell(Date input) {
		this.input=input;
		// TODO Auto-generated constructor stub
	}
	public void setCell(Date arg){
		input=arg;
	}
	public String getInputValue(){
		return String.valueOf(formatter.format(input));
	}
	public String getPrintValue(){
		return String.valueOf(formatter.format(input));
	}
}
