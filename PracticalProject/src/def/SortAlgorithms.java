package def;

import java.awt.Color;

import javax.swing.JOptionPane;

public class SortAlgorithms
{
	public static class Check extends Thread
	{
		Sort parent;
		Data dataEngine;
		Check(Sort S, Data D)
		{
			parent = S;
			dataEngine = D;
		}
		
		public void run()
		{
    		if(parent.vpanel.PanelArray == null)
    		{
    			parent.vpanel.PanelArray = new ColorInt[dataEngine.array.length];
    			for (int i = 0; i < dataEngine.array.length; i++)
    			{
    				parent.vpanel.PanelArray[i] = new ColorInt();
					parent.vpanel.PanelArray[i].I = dataEngine.array[i];
    			}
    		}
    		boolean checkbool = true;
    		//��������� ������ �����: ����� ����������.
    		Color[] ColorArray = new Color[parent.vpanel.PanelArray.length];
    		for (int i = 0; i < parent.vpanel.PanelArray.length; i++)
			{
    			ColorArray[i] = new Color(0);
				ColorArray[i] = parent.vpanel.PanelArray[i].InColor;
			}
    		//
    		parent.vpanel.PanelArray[0].InColor = Color.GREEN;
    		
    		for (int i = 1; i < parent.vpanel.PanelArray.length; i++)
    		{
				if(parent.vpanel.PanelArray[i-1].I > parent.vpanel.PanelArray[i].I)
				{
					JOptionPane.showMessageDialog(parent, "������ �� ����������!"," ", JOptionPane.INFORMATION_MESSAGE);
					checkbool = false;
					break;
				}
				parent.vpanel.PanelArray[i].InColor = Color.GREEN;
				try {
	    			sleep(10);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
				parent.vpanel.repaint();
    		}
    		if(checkbool)
    			JOptionPane.showMessageDialog(parent, "������ ����������!"," ", JOptionPane.INFORMATION_MESSAGE);
			//���������� ���������� �����.
			for (int i = 0; i < parent.vpanel.PanelArray.length; i++)
				parent.vpanel.PanelArray[i].InColor = ColorArray[i];
			//
    		parent.vpanel.repaint();
	    }
		
	}
	
	public static class InsertionSort extends Thread
	{
		Sort parent;
		boolean isForce;
		InsertionSort(Sort S, boolean method)
		{
			parent = S;
			isForce = method;
		}
		
		public void run()
	    {
	    	int i, j, temp;
	    	//��������� ������ � ����������.
			parent.vpanel.reInitComponents(); //�������� ��������
			parent.vpanel.SortName = " ���������"; //���� ���������� ��������.
	    	for (i = 1; i < parent.vpanel.PanelArray.length; i++)
	    	{
	    		synchronized (this)
	    		{
		    		temp = parent.vpanel.PanelArray[i].I;
		    		for (j = i - 1; j >= 0; j--)
		    		{
	    				parent.vpanel.ACInt+=2; //2 ������� � �������
		    			parent.vpanel.CompInt+=1; //���� ���������
		    			if (parent.vpanel.PanelArray[j].I < temp)
		    				break;
		    			parent.vpanel.PanelArray[j + 1].I = parent.vpanel.PanelArray[j].I;
		    			parent.vpanel.PanelArray[j].I = temp;
		    			parent.vpanel.ACInt+=3; //��� 3 �������.
		    		}
		    		parent.vpanel.repaint();
		        	try {
		    			sleep(10);
		    		} catch (InterruptedException e) {
		    			e.printStackTrace();
		    		}
		        	if(!isForce)
		        	{
		        		sleepSort();
		        	}
	    		}
	    	}
	    }
		
		public void sleepSort()
		{
			synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
			}
		}
		
		public void wakeSort()
		{
			synchronized (this) {
				this.notify();
			}
		}
	}
	
	
	public static class MergeSort extends Thread
	{
		Sort parent;
		boolean isForce;
		MergeSort(Sort S, boolean method)
		{
			parent = S;
			isForce = method;
		}
		
		public void run()
	    {
	    	//��������� ������ � ����������.
			parent.vpanel.reInitComponents(); //�������� ��������
			parent.vpanel.SortName = " ��������"; //���� ���������� ��������.
			parent.vpanel.repaint();
			MergeSorting(parent.vpanel.PanelArray,0,parent.vpanel.PanelArray.length-1);
	    }
		
		void MergeSorting(ColorInt[] arr, int l, int r)
		{	
			synchronized (this) 
			{
		    //! ������� ������ �� ��������
		    if(l >= r) return;
		    int m = (l + r)/2;
		    //! ����������� ���������� ���������� ��������
		    MergeSorting(arr, l, m);
		    MergeSorting(arr, m+1, r);
		    MergeS(arr, l, r, m);
			if(!isForce)
			{
				sleepSort();
			}
		}
		}
		
		void MergeS(ColorInt[] arr, int l, int r, int m)
		{

		    int j, start, fin;
		    int[] mas = new int[1001];
		    start=l; //������ ����� �����
		    fin=m+1; //������ ������ �����
		    for(j=l; j<=r; j++) //��������� �� ������ �� �����
		        if ((start<=m) && ((fin>r) || (arr[start].I<arr[fin].I)))
		            mas[j]=arr[start++].I;
		        else
		            mas[j]=arr[fin++].I;
		    //����������� ���������� � ������
		    for(j=l; j<=r; j++)
		    {
		        arr[j].I=mas[j];
				parent.vpanel.ACInt++; //������ � �������
		    }
			parent.vpanel.ACInt+=3; //3 ������� � �������
			parent.vpanel.CompInt+=3; // 3 ���������
		    parent.vpanel.repaint();
        	try {
    			sleep(10);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
		
		public void sleepSort()
		{
			synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
			}
		}
		
		public void wakeSort()
		{
			synchronized (this) {
				this.notify();
			}
		}
		
	}
	
}
