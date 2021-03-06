package def;
import def.SortAlgorithms.InsertionSort;
import def.SortAlgorithms.MergeSort;
import def.SortAlgorithms.Check;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.io.File;

public class SortEngine extends JFrame implements ActionListener, ChangeListener {
 
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
	boolean typeofsort;
	
    // ����������� ��������� ������ � Sort window � ���������� ������ parent
    SortEngine(Sort parent, Data data){
    	this.parent = parent;
    	dataEngine = data;
    }
    
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            parent.SleepTime = (int)source.getValue();
        }
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
    			int x = 0;
				parent.StrLog = " ";
				parent.L = null;
    			//if(parent.L != null)
    			//{
    			//	parent.L.ta.setText("");
    			//	parent.StrLog = " ";
    			//}
    			Sort.button_logic.setEnabled(true);
    			if ((Sort.r_demo_mode.isSelected()) && (Sort.r_ins_s.isSelected()))
    				x = 1;
    			if ((Sort.r_step_mode.isSelected()) && (Sort.r_ins_s.isSelected())) {
    				x = 11;
    				Sort.button_make_step.setEnabled(true);
    				Sort.button_start_sort.setEnabled(false);
    				//parent.typeOfSort = true;
    			}
    			if ((Sort.r_demo_mode.isSelected()) && (Sort.r_mer_s.isSelected()))
    				x = 2;
    			if ((Sort.r_step_mode.isSelected()) && (Sort.r_mer_s.isSelected())) {
    				x = 22;	
    				Sort.button_make_step.setEnabled(true);
    				Sort.button_start_sort.setEnabled(false);
    				//parent.typeOfSort = false;
    			}
	    		switch(x)
	    			{
	    			case 1:
	    				IS = new InsertionSort(parent, true);
			    		IS.start();
			    		typeofsort = true;
	    				break;
	    			case 11:
	    				IS = new InsertionSort(parent, false);
			    		IS.start();
			    		typeofsort = true;
	    				break;
	    			case 2:
	    				MS = new MergeSort(parent, true);
			    		MS.start();
			    		typeofsort = false;
			    		break;
	    			case 22:
	    				MS = new MergeSort(parent, false);
			    		MS.start();
			    		typeofsort = false;
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
    	if(actioncommand == dataEngine.b_save_txt)
    	{	    		
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Save file"); 
			int userSelection = fileChooser.showSaveDialog(this);			 
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    File fileToSave = fileChooser.getSelectedFile();
			    String str_temp = "";
			    for (int schet = 0; schet < parent.vpanel.PanelArray.length; schet++) {
			    	str_temp = str_temp + parent.vpanel.PanelArray[schet].I + " "; 
			    }
			    str_temp = parent.vpanel.PanelArray.length + "\n" + str_temp;
			    fileToSave = FileWorker.write(fileToSave, str_temp);
			} 			      	
    	}
    	if(actioncommand == dataEngine.b_logic_txt)
    	{
    		if(parent.L == null)
    			parent.L = new LogicIns(parent,typeofsort);
    		parent.L.setVisible(true);
    		
    	}
    	if(actioncommand == dataEngine.b_about_prog_txt)
    	{
    		JOptionPane.showMessageDialog(null, "<HTML><h2>������ \"������������ ����������\"</h2>"
    				+ "<p>��������, 2� ����, 4� �������. "
    				+ "<p>\"����\", ��������� ���, ������� �����"
    				+ "<p><p>��� �������� �������� �������� ������ 3304:"
    				+ "<p>   ����� �����, ��������� ����."
    				+ "<p>��������: john.lurye@gmail.com , 166_yulia@mail.ru"
    				+ "<p><p>Copyright &copy; 01.07.2015", "� ���������...", JOptionPane.INFORMATION_MESSAGE);		
    	}
    	
    }
    
}

