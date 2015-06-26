package def;

import def.SortAlgorithms.InsertionSort;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortEngine extends JFrame implements ActionListener {
 
	Sort parent; // ������ �� Sort
	private Generation dialog = null; //������, ���� ������, �� ������ ��������� ����
	Data dataEngine;
	
    // ����������� ��������� ������ � Sort window � ���������� ������ parent
    SortEngine(Sort parent, Data data){
    	this.parent = parent;
    	dataEngine = data;
    }
     /*  	    
    // ���������� ������� �� ������, ������� �� ������ ������ �������� �������� ����
    private void jButtonAddMouseClicked(MouseEvent evt) {
    	 // ������ ������ ��������� ����, ��������� � ����������� this-������ - �.�., ������ ��� ���� ���������� ��� ������ ������������
        this.dialog = new Generation(this, dataEngine);
        
        /*  if (this.dialog.execute()) {
        // �������� ��� ������� ������� ��
        // ����� �� ������������� ���������� ������ �����������, �������� �������������, ��������� ������� get, ��������������� ����������� ���� � ����� ��������� ����
        }
        else {
            // �������� ��� ������� �� ������� ������	
        }*/
   // }*/

 
    
    public boolean readArray(String fileName, int real_length) {
    	
    	try {
	    	Scanner in = new Scanner(new File(fileName));
	    	real_length = 0;
	    	int size =  in.nextInt();
	    	dataEngine.array = new int[size];
			while(in.hasNextInt()){
				dataEngine.array[real_length] = in.nextInt();	
				real_length++;
			}
			in.close();	
	    	return true;
    	}
    	catch (FileNotFoundException ex) {
       		return false;
    	}
    }
    	
    public void actionPerformed(ActionEvent e) {
    	
    	// ��������� ��������� �������
    	JButton clickedButton =  (JButton) e.getSource();
    	// ���� ��� ������ "���� �������� ������"
    	String actioncommand = clickedButton.getActionCommand();
    	if (actioncommand == dataEngine.b_input_txt) {
    	
    		 this.dialog = new Generation(this, dataEngine); 	
    	
    	
    	}
    	if(actioncommand == dataEngine.b_start_sort_txt)
    	{ //���� ��� ������ "������ ����������"
    		int real_length = 0;
    		boolean inforWasRead = readArray("input1.txt", real_length);	
    		if (dataEngine.array == null)
    		{ //���� ������ ������, �����
    			JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
    			return;
    		}	
			parent.vpanel.PanelArray = new int[dataEngine.array.length];
			for (int i = 0; i < dataEngine.array.length; i++) {
				parent.vpanel.PanelArray[i] = dataEngine.array[i];
			}
    		Thread is1 = new InsertionSort(parent);
    		is1.start();
    	}
    }
    
}

