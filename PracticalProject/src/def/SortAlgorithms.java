package def;

public class SortAlgorithms
{
	public static class InsertionSort extends Thread
	{
		Sort parent;
		InsertionSort(Sort S)
		{
			parent = S;
		}
		
		public void run()
	    {
	    	int i, j, temp;
	    	for (i = 1; i < parent.vpanel.PanelArray.length; i++)
	    	{
	    		temp = parent.vpanel.PanelArray[i];
	    		for (j = i - 1; j >= 0; j--)
	    		{
	    			if (parent.vpanel.PanelArray[j] < temp)
	    				break;
	    			parent.vpanel.PanelArray[j + 1] = parent.vpanel.PanelArray[j];
	    			parent.vpanel.PanelArray[j] = temp;
	    		}
	    		parent.vpanel.repaint();
	        	try {
	    			sleep(100);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }    
	}
	
}
