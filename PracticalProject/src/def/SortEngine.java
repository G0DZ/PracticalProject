package def;
import def.SortAlgorithms.InsertionSort;
import def.SortAlgorithms.MergeSort;
import def.SortAlgorithms.Check;

import java.awt.Color;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import javax.swing.*;

public class SortEngine extends JFrame implements ActionListener {
 
	Sort parent; // ������ �� Sort
	private Generation dialogGen = null; //������, ���� ������, �� ������ ��������� ����
	private ChooseSorting dialogChSort = null; //������, ���� ������, �� ������ ��������� ����
	Data dataEngine;
	boolean haveBeenLoad;
	InsertionSort IS;
	MergeSort MS;
	Check Ch;
	
    // ����������� ��������� ������ � Sort window � ���������� ������ parent
    SortEngine(Sort parent, Data data){
    	this.parent = parent;
    	dataEngine = data;
    }
        	
    public void actionPerformed(ActionEvent e) {
    	
    	// ��������� ��������� �������
    	JButton clickedButton =  (JButton) e.getSource();
    	// ���� ��� ������ "���� �������� ������"
    	String actioncommand = clickedButton.getActionCommand();
    	if (actioncommand == dataEngine.b_input_txt) {
    		// ���������� ������� �� ������, ������� �� ������ ������ �������� �������� ����
    	    // ������ ������ ��������� ����, ��������� � ����������� this-������ - �.�., ������ ��� ���� ���������� ��� ������ ������������
    		this.dialogGen = new Generation(this, dataEngine);
    		if (this.dialogGen.execute()) {
		        // �������� ��� ������� ������� ��
 		        // ����� �� ������������� ���������� ������ �����������, �������� �������������, ��������� ������� get, ��������������� ����������� ���� � ����� ��������� ����
    			haveBeenLoad = true;
	    		if ((dataEngine.array == null) || (dataEngine.array.length == 0))
	    		{
	    			haveBeenLoad = false;
	    			JOptionPane.showMessageDialog(null, "������������ �������� ������", " ", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		else 
	    		{
	    			parent.vpanel.PanelArray = new ColorInt[dataEngine.array.length];
	    			for (int i = 0; i < dataEngine.array.length; i++)
	    			{
	    				parent.vpanel.PanelArray[i] = new ColorInt();
						parent.vpanel.PanelArray[i].I = dataEngine.array[i];
	    			}
	    			parent.vpanel.repaint();
	    		}
    		}
  		    else {
   		        // �������� ��� ������� �� ������� ������
  		    	haveBeenLoad = false;
   		    }	 		 
    		 
    	}
    	if(actioncommand == dataEngine.b_start_sort_txt)
    	{ //���� ��� ������ "������ ����������"
    		if (haveBeenLoad)
    		{
    			parent.vpanel.PanelArray = new ColorInt[dataEngine.array.length];
    			for (int i = 0; i < dataEngine.array.length; i++)
    			{
    				parent.vpanel.PanelArray[i] = new ColorInt();
					parent.vpanel.PanelArray[i].I = dataEngine.array[i];
    			}
	    		this.dialogChSort = new ChooseSorting(this, dataEngine);
	        	int x = this.dialogChSort.executeSort();
	    		switch(x)
	    			{
	    			case 1:
	    				IS = new InsertionSort(parent, true);
			    		IS.start();
	    				break;
	    			case 11:
	    				IS = new InsertionSort(parent, false);
			    		IS.start();
	    				break;
	    			case 2:
	    				MS = new MergeSort(parent, true);
			    		MS.start();
			    		break;
	    			case 22:
	    				MS = new MergeSort(parent, false);
			    		MS.start();
			    		break;
	    			case 0:
	    				break;
	    		}
	    	}
    		else 
    		{
    			JOptionPane.showMessageDialog(null, "�������� ������ �� ���������", " ", JOptionPane.WARNING_MESSAGE);
    			return;
    		}
    	}
    	if(actioncommand == dataEngine.b_revival_txt)
    	{ //���� ��� ������ "������������"
    		if (haveBeenLoad) 
    		{ //���� ������ ���� ���������
    			parent.vpanel.PanelArray = new ColorInt[dataEngine.array.length];
    			for (int i = 0; i < dataEngine.array.length; i++)
    			{
    				parent.vpanel.PanelArray[i] = new ColorInt();
					parent.vpanel.PanelArray[i].I = dataEngine.array[i];
    			}
				parent.vpanel.repaint();
				JOptionPane.showMessageDialog(this, "�������� ������ ������������!"," ", JOptionPane.INFORMATION_MESSAGE);
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "�������� ������ �� ���������", " ", JOptionPane.WARNING_MESSAGE);
    			return;
    		}	
    	}
    	if(actioncommand == dataEngine.b_check_txt)
    	{ //���� ��� ������ "��������"
    		if (haveBeenLoad) 
    		{ //���� ������ ���� ���������
    			Ch = new Check(parent, dataEngine);
    			Ch.start();
	    	}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "�������� ������ �� ���������", " ", JOptionPane.WARNING_MESSAGE);
    			return;
    		}	
    	}
    	if(actioncommand == dataEngine.b_make_step_txt)
    	{
    		if(IS != null)
    			IS.wakeSort();
    		if(MS != null)
    			MS.wakeSort();
    	}
    }
    
}

