package def;
import def.SortAlgorithms.InsertionSort;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JButton;

public class SortEngine extends JFrame implements ActionListener {
 
	Sort parent; // ������ �� Sort
	private Generation dialog = null; //������, ���� ������, �� ������ ��������� ����
	Data dataEngine;
	boolean haveBeenLoad;
	
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
    		this.dialog = new Generation(this, dataEngine);
    		if (this.dialog.execute()) {
		        // �������� ��� ������� ������� ��
 		        // ����� �� ������������� ���������� ������ �����������, �������� �������������, ��������� ������� get, ��������������� ����������� ���� � ����� ��������� ����
    			haveBeenLoad = true;
    		}
  		    else {
   		        // �������� ��� ������� �� ������� ������
  		    	haveBeenLoad = false;
   		    }	 		 
    		 
    	}
    	if(actioncommand == dataEngine.b_start_sort_txt)
    	{ //���� ��� ������ "������ ����������"
    		if (haveBeenLoad) {
	    		if ((dataEngine.array == null) || (dataEngine.array.length == 0)){
	    			JOptionPane.showMessageDialog(null, "������������ �������� ������", " ", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		else {
					parent.vpanel.PanelArray = new int[dataEngine.array.length];
					for (int i = 0; i < dataEngine.array.length; i++) {
						parent.vpanel.PanelArray[i] = dataEngine.array[i];
					}
		    		Thread is1 = new InsertionSort(parent);
		    		is1.start();
	    		}
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "�������� ������ �� ���������", " ", JOptionPane.WARNING_MESSAGE);
    			return;
    		}
    	}
    }
    
}

