package def;

public class Data {
	
	final static int sizeOfArray = 20;	
	int[] array;
	
	Data() {
		array = new int[sizeOfArray];
	}
	
	public static void main(String[] args) {
		
		Data data =  new Data();
		new Sort(data);		
		
	}
}