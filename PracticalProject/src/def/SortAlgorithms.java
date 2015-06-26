package def;

import java.util.Arrays;

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
	
	
	public static class MergeSort extends Thread
	{
		Sort parent;
		MergeSort(Sort S)
		{
			parent = S;
		}
		
		public void run()
	    {
			
			parent.vpanel.repaint();
			MergeSort(parent.vpanel.PanelArray,0,parent.vpanel.PanelArray.length-1);
	    }
		
		void MergeSort(int[] arr, int l, int r)
		{
		    //! Условие выхода из рекурсии
		    if(l >= r) return;
		    int m = (l + r)/2;
		    //! Рекурсивная сортировка полученных массивов
		    MergeSort(arr, l, m);
		    MergeSort(arr, m+1, r);
		    MergeS(arr, l, r, m);
		}
		
		void MergeS(int[] arr, int l, int r, int m)
		{
		    int j, start, fin;
		    int[] mas = new int[1001];
		    start=l; //начало левой части
		    fin=m+1; //начало правой части
		    for(j=l; j<=r; j++) //выполнять от начала до конца
		        if ((start<=m) && ((fin>r) || (arr[start]<arr[fin])))
		            mas[j]=arr[start++];
		        else
		            mas[j]=arr[fin++];
		    //возвращение результата в список
		    for(j=l; j<=r; j++)
		    {
		        arr[j]=mas[j];

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
