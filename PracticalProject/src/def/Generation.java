package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Generation extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel windowGeneration;
	JButton button_file;
    JButton button_string;
    JButton button_auto;
    JButton button_cancel;
    JLabel label_space;
    Data dataGen;
	private boolean result; // ��������� ������ ���� (true - ������� ������ OK, false - ������� ������ ������);
	// � ��� ��� ��������� �������� ���������
	private GenerationParam dialog = null; //������, ���� ������, �� ������ ��������� ����
	
	public Generation(java.awt.Frame parent, Data data) {

		super(parent, true); 
		dataGen = data;		
		
		// ������� ��������
		button_file = new JButton(dataGen.b_file_txt);
		button_string = new JButton(dataGen.b_string_txt);
		button_auto = new JButton(dataGen.b_auto_txt);
		button_cancel = new JButton(dataGen.b_cancel_txt);
		label_space = new JLabel("- - - - - - - - - - - - - - - - - - - - -");		
		
	    // ��������� ��������� ����������
		button_file.addActionListener(this);
		button_string.addActionListener(this);
		button_auto.addActionListener(this);
		button_cancel.addActionListener(this);

		// ��������� �������� �� ������
		windowGeneration = new JPanel();
		windowGeneration.setLayout(null);
		button_file.setBounds(20, 20, 150, 30);
		button_string.setBounds(20, 60, 150, 30);
		button_auto.setBounds(20, 100, 150, 30);
		label_space.setBounds(20, 130, 150, 30);
		button_cancel.setBounds(20, 160, 150, 30);
		
		windowGeneration.add(button_file);
		windowGeneration.add(button_string);
		windowGeneration.add(button_auto);
		windowGeneration.add(label_space);
		windowGeneration.add(button_cancel);
		
		getContentPane().add(windowGeneration);
		setPreferredSize(new Dimension(190, 230));
		
		this.add(windowGeneration);
		// ������� ������ ���� ����������
        this.pack();
	    // ������ �� ��������� ������� ������
	    this.setResizable(false);		
	    //����� ���������� ������
	    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    int w = this.getWidth();
	    int h = this.getHeight();
	    center.x = center.x - w/2; 
	    center.y = center.y - h/2;
	    this.setLocation(center);
	}
	
	public boolean execute() { // ����� ��� "�������" � ������������ �����
		this.setVisible(true); // ����������� �������� ����; � ������ ����� ���������� ��������� ��������������, ������ ��������� ������ ������������ (� ����� ������ - ������� dispose())
        return this.result; // ������� � �������� ���������� �������� �������� ������� ������
	}
	
	 public boolean readArray(File file, int real_length) {
	    	
	    try {
		   	Scanner in = new Scanner(file);
		   	real_length = 0;
		   	int size = 0;
		   	if (in.hasNextInt()) {
		   		size =  in.nextInt();
		   		if (size > Data.const_max) {
		   			in.close();
			   		return false;
		   		}		   			
		   	}
		   	else {
		   		in.close();
		   		return false;
		   	}
		   	dataGen.array = new int[size];
		   	if (in.hasNextInt()) {
				while(in.hasNextInt()){
					int gyg = in.nextInt();
					if (gyg > Data.elem_max) {
			   			in.close();
				   		return false;
			   		}							
					dataGen.array[real_length] = gyg;	
					real_length++;				
				}
				in.close();
				return true;
		   	}
		   	else {
		   		in.close();
		   		return false;
		   	}
	    }
	    catch (FileNotFoundException ex) {
	    	return false;
	    }
	 }
	 
	 public void actionPerformed(ActionEvent e) {
		 
		// ��������� ��������� �������
	    JButton clickedButton =  (JButton) e.getSource();
	    String actioncommand = clickedButton.getActionCommand();
// ������ "����"
	    if (actioncommand == dataGen.b_file_txt) {
	    	// ������� ����� ������
	    	// ���������� ������ ������������
	    	// � ret ��������� ��������, �� �������� �� ����� ������, ��� ����� ������������
	    	JFileChooser fileopen = new JFileChooser();             
	    	fileopen.setDialogTitle("Open file"); 
			int ret = fileopen.showOpenDialog(this);
	    	if (ret == JFileChooser.APPROVE_OPTION) {
	    	    File file = fileopen.getSelectedFile();
	    	    int real_length = 0;
	    	    // ��������� ������ ���
	    	    boolean inforWasRead = readArray(file, real_length);   	    
	    		if ((dataGen.array == null) || (!inforWasRead))
	    		{ //���� ������ ������, �����
	    			JOptionPane.showMessageDialog(null, "��� ������ � ����� ��������� ������", " ", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		else {
	    			//custom title, no icon
	    			JOptionPane.showMessageDialog(this, "������ ������� �������!"," ", JOptionPane.PLAIN_MESSAGE);	
	    		}
	    		this.result = true; 
				this.dispose(); // ���������� ����
	    	}		    		
	    }
// ������ "������ �����"
	    if (actioncommand == dataGen.b_string_txt) { 	   	
	    	this.dialog = new GenerationParam(this, dataGen, 1);
    		if (this.dialog.executeParam()) {
		        // �������� ��� ������� ������� ��
 		        // ����� �� ������������� ���������� ������ �����������, �������� �������������, ��������� ������� get, ��������������� ����������� ���� � ����� ��������� ����
    			JOptionPane.showMessageDialog(this, "������ ������� �������!"," ", JOptionPane.PLAIN_MESSAGE);
    			this.result = true; 
    			this.dispose(); // ���������� ����
    		}
  		    else {
   		           // ������ �� ���������� ^^
   		    }  		    		    	
	    }
// ������ "��������������"
	    if (actioncommand == dataGen.b_auto_txt) {
	    	this.dialog = new GenerationParam(this, dataGen, 2);
    		if (this.dialog.executeParam()) {
		        // �������� ��� ������� ������� ��
 		        // ����� �� ������������� ���������� ������ �����������, �������� �������������, ��������� ������� get, ��������������� ����������� ���� � ����� ��������� ����   		
    			JOptionPane.showMessageDialog(this, "������ ������� �������!"," ", JOptionPane.PLAIN_MESSAGE);
    			this.result = true; 
    			this.dispose(); // ���������� ����
    		}
  		    else {
   		           // ������ �� ���������� ^^
   		    }    	    	
	    }
// ������ "������"
	    if (actioncommand == dataGen.b_cancel_txt) {
	    	this.result = false; // ������������ ����� ������
			this.dispose(); // ���������� ����
	    }
	} 

}

