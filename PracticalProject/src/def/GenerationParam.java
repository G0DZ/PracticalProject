package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class GenerationParam extends JDialog {
	private boolean resultParam; // ��������� ������ ���� (true - ������� ������ OK, false - ������� ������ ������);
	JPanel p;
	private JTextField displayField;
    JButton button_OK;
    JButton button_cancel;

    public void setDisplayValue(String val){
        displayField.setText(val);
    }

    public String getDisplayValue() {
        return displayField.getText();
    } 

	public GenerationParam(Generation parent) {

		super(parent, true); 
   /*
		p = new JPanel();
       // ������� ��������� ���� �������� � 30 ��������
       displayField = new JTextField(30);
       // ��������� ��� � ������� ����� ������
       p.add("Center",displayField);
       this.add(p);
       
       
       
    	// ������� �������� ���� � 2 ��������
     

    		
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
    	    this.setLocation(center);*/
	    
	    
	    
	}
	
	public boolean executeParam() { // ����� ��� "�������" � ������������ �����
		this.setVisible(true); // ����������� �������� ����; � ������ ����� ���������� ��������� ��������������, ������ ��������� ������ ������������ (� ����� ������ - ������� dispose())
        return this.resultParam; // ������� � �������� ���������� �������� �������� ������� ������
	}
		
	
	
	
	 
	 public void actionPerformed(ActionEvent e) {
		 
		// ��������� ��������� �������
	   // JButton clickedButton =  (JButton) e.getSource();
	    //String actioncommand = clickedButton.getActionCommand();

	    /*if (actioncommand == dataGen.b_auto_txt) { 
	    	
	    	this.result = true; 
			this.dispose(); // ���������� ����	    	
	    }
	    if (actioncommand == dataGen.b_cancel_txt) {
	    	this.result = false; // ������������ ����� ������
			this.dispose(); // ���������� ����
	    }*/
	} 
}
