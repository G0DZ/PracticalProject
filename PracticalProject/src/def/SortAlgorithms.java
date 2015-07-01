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
	    			sleep(100);
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
		public int SleepTime = 20;
		InsertionSort(Sort S, boolean method)
		{
			parent = S;
			isForce = method;
		}
		
		public void run()
	    {
	    	//��������� ������ � ����������.
			parent.vpanel.reInitComponents(); //�������� ��������
			parent.vpanel.SortName = " ���������"; //���� ���������� ��������.
			InsSort();
			//�������� ����� ������ ������.
			parent.vpanel.reInitComponents(); //�������� ��������
			parent.vpanel.SortName = null; //������� � ���������� ��������
			JOptionPane.showMessageDialog(parent, "���������� ��������� ���������!"," ", JOptionPane.INFORMATION_MESSAGE);
			parent.progressBar.setValue(0);; //�������� ��������
			Sort.button_check.setEnabled(true);
			Sort.button_save.setEnabled(true);
			Sort.button_revival.setEnabled(true);
			Sort.button_input.setEnabled(true);
			Sort.button_start_sort.setEnabled(false);
			Sort.button_make_step.setEnabled(false);
			Sort.button_logic.setEnabled(false);
	    }
		
		private void InsSort()
		{
	    	int i, j;
			ColorInt temp;
			for (i = 1; i < parent.vpanel.PanelArray.length; i++)
	    	{
				float y =  ((i+1)*100/parent.vpanel.PanelArray.length);
				parent.progressBar.setValue((int) y);
				synchronized (this)
	    		{
	    			for (int k=0; k < i; k++)
	    			{
	    				parent.vpanel.PanelArray[k].InColor = Color.WHITE;
	    			}
		    		temp = parent.vpanel.PanelArray[i]; //������� ������� ��� temp
		    		parent.vpanel.PanelArray[i].InColor = Color.yellow; // �� ������������� ���, ������ ������ �� ������� ����.
		    		if(i != parent.vpanel.PanelArray.length-1)
		    			parent.vpanel.PanelArray[i+1].InColor = Color.red;
		    		boolean swapyet = false;
		    		for (j = i - 1; j >= 0; j--)
		    		{ //����� ���������� �� ����� �����������.
	    				parent.vpanel.ACInt+=1; //������ � �������
		    			parent.vpanel.CompInt+=1; //���� ���������
		    			if (parent.vpanel.PanelArray[j].I < temp.I) //���������� ���������� � �������.
		    			{
		    				for (int k=0; k <= j; k++)
			    			{
			    				parent.vpanel.PanelArray[k].InColor = Color.CYAN;
			    			}	    			
		    				break; //� �������, ���� temp ������.
		    			}
		    			if(!swapyet)
		    				swapyet = true;
		    			parent.vpanel.PanelArray[j + 1] = parent.vpanel.PanelArray[j];
		    			parent.vpanel.PanelArray[j] = temp;
		    			parent.vpanel.ACInt+=3; //��� 3 �������.
		    		}
		    		for(int k = i; k > j+1; k--)
		    			parent.vpanel.PanelArray[k].InColor = Color.GREEN;
		    		
    				parent.vpanel.ACInt+=1; //������ � �������
		    		parent.vpanel.repaint();
		    		if (parent.L != null) {
		    			parent.L.strLog = parent.L.strLog + "��� " + i + "\n������� �������, ������� � ������ � �������� " + i + ", ��� ������� � ������\n������� � �������� " + j + ";\n";
		    			parent.L.strLog = parent.L.strLog + "��� ���� ��������� ����� ���� ���������, ������� �������� ��������\n� ������� � ������� � ��������, �������, ��� ������ ��������\n ��������;\n";
		    			parent.L.ta.setText(parent.L.strLog);
		    		}
		    		try {
		    			sleep(parent.SleepTime);
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
		int test = 0;
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
			MergeSorting(parent.vpanel.PanelArray,0,parent.vpanel.PanelArray.length-1,0);
			parent.progressBar.setValue(100); //�������� ��������
			//�������� ����� ������ ������.
			parent.vpanel.reInitComponents(); //�������� ��������
			parent.vpanel.SortName = null; //������� � ���������� ��������
			JOptionPane.showMessageDialog(parent, "���������� �������� ���������!"," ", JOptionPane.INFORMATION_MESSAGE);
			parent.progressBar.setValue(0);; //�������� ��������
			Sort.button_check.setEnabled(true);
			Sort.button_save.setEnabled(true);
			Sort.button_revival.setEnabled(true);
			Sort.button_input.setEnabled(true);
			Sort.button_start_sort.setEnabled(false);
			Sort.button_make_step.setEnabled(false);
			Sort.button_logic.setEnabled(false);
	    }
		
		private void MergeSorting(ColorInt[] arr, int l, int r, int lforprint)
		{	//lforprint - �����������, ������������ � �������� ��� ��������� ����� ����� �������.
			synchronized (this) 
			{
				//! ������� ������ �� ��������
				if(l >= r) 
				{
					test++;
					float y = (test)*100/(2*parent.vpanel.PanelArray.length);
					parent.progressBar.setValue((int) y);
					return;
				}
				int m = (l + r)/2;

				//! ����������� ���������� ���������� ��������
				MergeSorting(arr, l, m,lforprint);
				MergeSorting(arr, m+1, r,l);
					test++;
					float y = (test)*100/(2*parent.vpanel.PanelArray.length);
					parent.progressBar.setValue((int) y);
				MergeS(arr, l, r, m, lforprint);
				if(!isForce)
				{
					sleepSort();
				}
			}
		}
		
		private void MergeS(ColorInt[] arr, int l, int r, int m, int lforprint)
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
		    for (int k=0; k < lforprint; k++) //"�������� ���", �� ����� ����� �������
				parent.vpanel.PanelArray[k].InColor = Color.WHITE;
		    for (int k=lforprint; k < l; k++) //����� ����� �������, ���� ��� ����, �������
		    	parent.vpanel.PanelArray[k].InColor = Color.GREEN; //������ � �������
		    for(int i = l; i <= r; i++)
		    {
		    	if(i <= m) 	//����� ����� � �������
		    		parent.vpanel.PanelArray[i].InColor = Color.CYAN;
		    	else 		//������ � ������.
		    		parent.vpanel.PanelArray[i].InColor = Color.YELLOW;
		    }
			parent.vpanel.ACInt+=3; //3 ������� � �������
			parent.vpanel.CompInt+=3; // 3 ���������
		    parent.vpanel.repaint();
        	try {
    			sleep(parent.SleepTime);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
		
		public void sleepSort()
		{
			synchronized (this) 
			{
				try 
				{
					wait();
				} 
				catch (InterruptedException e) 
				{
				}
			}
		}
		
		public void wakeSort()
		{
			synchronized (this) 
			{
				this.notify();
			}
		}
		
	}
	
}
