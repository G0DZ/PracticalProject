package def;

public class AlgorithmOfSort {
	
	public static void insertionSort(int[] arr) {
	    for(int i = 1; i < arr.length; i++){
	        int currElem = arr[i];
	        int prevKey = i - 1;
	            while(prevKey >= 0 && arr[prevKey] > currElem){
	                arr[prevKey+1] = arr[prevKey];
	                arr[prevKey] = currElem;
	                prevKey--;
	            }
	    }
	}	
}
