package def;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortEngine implements ActionListener {
 
	Sort parent; // ������ �� Sort
	
    // ����������� ��������� ������ � Sort window � ���������� ������ parent
    SortEngine(Sort parent){
    	this.parent = parent;
    }
       	   
    public static boolean algorithm(String fileName) {
    	
    	try {
	    	Scanner in = new Scanner(new File(fileName));
			int i = 0;
			while(in.hasNextInt()){
				i++;
				Data.array[i] = in.nextInt();		
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
    	if (clickedButton.getActionCommand() == "���� �������� ������") {
    		// ������� �������� ������ � ������ array[];
    		boolean inforWasRead = algorithm("input1.txt");		
    		
    		if (inforWasRead) {
    			parent.setDisplayValue("������ ������ �������!");    			
    		}
    		else {
    			parent.setDisplayValue("���� �� ������!");
    		}
    		// ���������, ��� � ��� ���� � displayField - ������ ������ JTextField
    		//String dispFieldText = parent.getDisplayValue();
    		//String clickedButtonLabel = clickedButton.getText();
    	}
    } 
    
}

