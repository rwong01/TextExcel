public class Cell {
	private String data;
	public Cell(){
		setCell("");
	}
	public void setCell(String arg){
		data=arg;
	}
	public void setCell(char arg){
		setCell(Character.toString(arg));
	}
	private void print(){
		String printData="";
		String rawData=data.substring(1,(data.length()-1));
		if(data.length()>12){ 
			rawData=data.substring(0,12);
		}
		int d=12-rawData.length();
		for(int i=0;i<d/2;i++){
			printData+=" ";
		}
		printData+=rawData;
		for(int i=0;i<d/2+d%2;i++){
			printData+=" ";
			}
		System.out.print(printData);
	}
	public void printCell(){
		print();
	}
	public String getCell(){
		return data;
	}
	public void clearCell(){
		data="";
	}
}
