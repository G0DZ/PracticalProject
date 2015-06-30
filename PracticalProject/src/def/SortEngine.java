package def;
import def.SortAlgorithms.InsertionSort;
import def.SortAlgorithms.MergeSort;
import def.SortAlgorithms.Check;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import javax.swing.*;

public class SortEngine extends JFrame implements ActionListener {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Sort parent; // ������ �� Sort
	private Generation dialogGen = null; //������, ���� ������, �� ������ ��������� ����
	//private ChooseSorting dialogChSort = null; //������, ���� ������, �� ������ ��������� ����
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
	    			Sort.button_start_sort.setEnabled(true);
	    			Sort.button_check.setEnabled(true);
	    			Sort.button_save.setEnabled(true);
	    			parent.vpanel.PanelArray = new ColorInt[dataEngine.array.length];
	    			for (int i = 0; i < dataEngine.array.length; i++)
	    			{
	    				parent.vpanel.PanelArray[i] = new ColorInt();
						parent.vpanel.PanelArray[i].I = dataEngine.array[i];
	    			}
					parent.vpanel.SortName = null; //������� - �� ������, ��� ���������� ���, � ������ �� ���.
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
    			Sort.button_start_sort.setEnabled(false);
    			Sort.button_check.setEnabled(false);
    			Sort.button_save.setEnabled(false);
    			Sort.button_revival.setEnabled(false);
    			Sort.button_input.setEnabled(false);
    			parent.vpanel.PanelArray = new ColorInt[dataEngine.array.length];
    			for (int i = 0; i < dataEngine.array.length; i++)
    			{
    				parent.vpanel.PanelArray[i] = new ColorInt();
					parent.vpanel.PanelArray[i].I = dataEngine.array[i];
    			}
	    		//this.dialogChSort = new ChooseSorting(this, dataEngine);
    			//int x = this.dialogChSort.executeSort();
    			int x = 0;
    			if ((Sort.r_demo_mode.isSelected()) && (Sort.r_ins_s.isSelected()))
    				x = 1;
    			if ((Sort.r_step_mode.isSelected()) && (Sort.r_ins_s.isSelected())) {
    				x = 11;
    				Sort.button_make_step.setEnabled(true);
    				Sort.button_start_sort.setEnabled(false);
    			}
    			if ((Sort.r_demo_mode.isSelected()) && (Sort.r_mer_s.isSelected()))
    				x = 2;
    			if ((Sort.r_step_mode.isSelected()) && (Sort.r_mer_s.isSelected())) {
    				x = 22;	
    				Sort.button_make_step.setEnabled(true);
    				Sort.button_start_sort.setEnabled(false);
    			}
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
				parent.vpanel.SortName = null; //������� - �� ������, ��� ���������� ���, � ������ �� ���.
				parent.vpanel.repaint();
				JOptionPane.showMessageDialog(this, "�������� ������ ������������!"," ", JOptionPane.INFORMATION_MESSAGE);
				Sort.button_start_sort.setEnabled(true);
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

