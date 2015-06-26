package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Generation extends JDialog implements ActionListener {
	
	JPanel windowGeneration;
	JButton button_file;
    JButton button_string;
    JButton button_auto;
    JButton button_cancel;
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
		
	    // ��������� ��������� ����������
		button_file.addActionListener(this);
		button_string.addActionListener(this);
		button_auto.addActionListener(this);
		button_cancel.addActionListener(this);

				
		// ��������� �������� �� ������
		windowGeneration = new JPanel();
		GroupLayout grl = new GroupLayout(windowGeneration);
		windowGeneration.setLayout(grl);
		// Automatic gap insertion:
		grl.setAutoCreateGaps(true);
    	grl.setAutoCreateContainerGaps(true); 	
    	grl.setHorizontalGroup(
    			grl.createSequentialGroup()
    			      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
    			    		.addComponent(button_file)
    	    			    .addComponent(button_string)
    	    			    .addComponent(button_auto)
    	    			    .addComponent(button_cancel))
    			);
    	grl.setVerticalGroup(
    			grl.createSequentialGroup()
    				  .addComponent(button_file)
    	    		  .addComponent(button_string)
    	    		  .addComponent(button_auto)
    	    		  .addComponent(button_cancel)
    			);

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
		   	if (in.hasNextInt()) 
		   		size =  in.nextInt();
		   	else 
		   		return false;
		   	dataGen.array = new int[size];
		   	if (in.hasNextInt()) {
				while(in.hasNextInt()){
					dataGen.array[real_length] = in.nextInt();	
					real_length++;				
				}
				in.close();
				return true;
		   	}
		   	else
		   		return false;
	    }
	    catch (FileNotFoundException ex) {
	    	return false;
	    }
	 }
	 
	 public void actionPerformed(ActionEvent e) {
		 
		// ��������� ��������� �������
	    JButton clickedButton =  (JButton) e.getSource();
	    String actioncommand = clickedButton.getActionCommand();
	    if (actioncommand == dataGen.b_file_txt) {
	    	// ������� ����� ������
	    	// ���������� ������ ������������
	    	// � ret ��������� ��������, �� �������� �� ����� ������, ��� ����� ������������
	    	JFileChooser fileopen = new JFileChooser();             
	    	int ret = fileopen.showDialog(null, "������� ����");
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
	    			JOptionPane.showMessageDialog(this, "������ ������� �������!"," ", JOptionPane.PLAIN_MESSAGE);	    		}
	    		}
	    	this.result = true; 
			this.dispose(); // ���������� ����		    		
	    }
	    if (actioncommand == dataGen.b_string_txt) {
	    	
	    	
	    	this.dialog = new GenerationParam(this, dataGen);
    		if (this.dialog.executeParam()) {
		        // �������� ��� ������� ������� ��
 		        // ����� �� ������������� ���������� ������ �����������, �������� �������������, ��������� ������� get, ��������������� ����������� ���� � ����� ��������� ����
 		    }
  		    else {
   		           // �������� ��� ������� �� ������� ������	
   		    }  	
	    	
	    	
	    	
	    	this.result = true; 
			this.dispose(); // ���������� ����	    	
	    }
	    if (actioncommand == dataGen.b_auto_txt) { 
	    	
	    	
	 
	    	  	    		    		    	
	    	
	    	
	    	Random r = new Random();
	    	dataGen.array = new int[48];
	    	for(int j = 0; j < dataGen.array.length; j++)
	    		dataGen.array[j] = r.nextInt(70);	    	
	    	this.result = true; 
			this.dispose(); // ���������� ����	    	
	    }
	    if (actioncommand == dataGen.b_cancel_txt) {
	    	this.result = false; // ������������ ����� ������
			this.dispose(); // ���������� ����
	    }
	} 

}