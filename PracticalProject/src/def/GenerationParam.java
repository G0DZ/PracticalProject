package def;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class GenerationParam extends JDialog implements ActionListener {
	private boolean resultParam; // ��������� ������ ���� (true - ������� ������ OK, false - ������� ������ ������);
	JPanel p1;
	JPanel p2;
	JPanel allP;
	JLabel label1;
	JLabel label2;
	JSpinner spin;
	private JTextField displayField;
    JButton button_OK;
    JButton button_cancel;
    Data dataGen;
    final int const_max = 50;
    String forArray;

    public void setDisplayValue(String val){
        displayField.setText(val);
    }

    public String getDisplayValue() {
        return displayField.getText();
    } 
    
    ChangeListener listener = new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
            //JSpinner js = (JSpinner) e.getSource();
           // Object val = js.getValue();
        	Object val = spin.getValue();
            if (val instanceof Integer) {
            	  int result = (int) val;
            	  if (result > const_max) {
            		Component c = spin.getEditor().getComponent(0);
              		c.setBackground(Color.RED);
            	  }
            	  else {
            		Component c = spin.getEditor().getComponent(0);
              		c.setBackground(Color.WHITE);
            	  }
            		  
            }
        }       
    };
    
	public GenerationParam(Generation parent, Data data) {

		super(parent, true); 
		dataGen = data;
		
    	// ������� �������� ���� � 2 ��������
		// ������� ��������� ���� �������� � 50 ��������
		label1 = new JLabel("������� ������ �������");
		SpinnerModel model =
		        new SpinnerNumberModel(1, //initial value
		                               1, //min
		                               const_max, //max
		                               1); //step
		spin = new JSpinner(model);
		spin.addChangeListener(listener);			
		
		label2 = new JLabel("������� �������� ������� ����� ������");		
	    displayField = new JTextField(50);
	    button_OK = new JButton(data.b_OK_txt);
	    button_cancel = new JButton(data.b_cancel_txt);
     	
        // ��������� ��������� ����������
    	button_cancel.addActionListener(this);
    	button_OK .addActionListener(this);

    	// ��������� �������� �� ������ � �������� ���� ���� �������-��
    	p1 = new JPanel();
    	GroupLayout grl = new GroupLayout(p1);
    	p1.setLayout(grl);
    	grl.setHorizontalGroup(
    			grl.createSequentialGroup()
    			      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
    			    		.addComponent(label1)
    	    			    .addComponent(spin)
    	    			    .addComponent(label2)
    	    			    .addComponent(displayField))
    			);
    	grl.setVerticalGroup(
    			grl.createSequentialGroup()
    						.addComponent(label1)
    	    			    .addComponent(spin)
    	    			    .addComponent(label2)
    	    			    .addComponent(displayField)
    				  
    			);  	
    	
    	p2 = new JPanel();
    	FlowLayout fl2 = new FlowLayout();
    	p2.setLayout(fl2);
    	p2.add(button_OK);
    	p2.add(button_cancel);
    	
    	allP = new JPanel();
    	BorderLayout allL = new BorderLayout();
    	allP.setLayout(allL);
    	allP.add("North",p1);
    	allP.add("Center",p2);   	
    	
      	this.add(allP);
    		
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
	
	public boolean executeParam() { // ����� ��� "�������" � ������������ �����
		this.setVisible(true); // ����������� �������� ����; � ������ ����� ���������� ��������� ��������������, ������ ��������� ������ ������������ (� ����� ������ - ������� dispose())
        return this.resultParam; // ������� � �������� ���������� �������� �������� ������� ������
	}
		
	 public void actionPerformed(ActionEvent e) {		 
		// ��������� ��������� �������
	    JButton clickedButton =  (JButton) e.getSource();
	    String actioncommand = clickedButton.getActionCommand();
	    if (actioncommand == dataGen.b_OK_txt) {
	    	// �������������� �����
	    	displayField.setBackground(Color.WHITE);
	    	// ��������� ������ �������    	
	    	Object val = spin.getValue();
	    	int result = 0;
	    	if (val instanceof Integer) {
            	result = (int) val;            		           
	            dataGen.array = new int[result];	            
	            // � ������ ������� ������ ������
		    	forArray = displayField.getText();
		    	File file = FileWorker.write("forArray.txt", forArray);	    	
		    	try {
				   	Scanner in = new Scanner(file);
				   	int real_length = 0;
				   	if (in.hasNextInt()) {
						while ((in.hasNextInt()) && (dataGen.array.length > real_length)) {
							dataGen.array[real_length] = in.nextInt();	
							real_length++;				
						}
					   	if ((dataGen.array.length == real_length) && (!in.hasNextInt())) {
					   		in.close();
					   		this.resultParam = true; 
							this.dispose(); // ���������� ����	
					   	}
					   	else {
					   		in.close();
					   		JOptionPane.showMessageDialog(this, "������ ������� �� ������������� ���������� ���������, �������� � ������",
					   				"",
					   			    JOptionPane.WARNING_MESSAGE);
					   		Component c = spin.getEditor().getComponent(0);
		              		c.setBackground(Color.RED);
					   	}
				   	}
				   	else {
				   		in.close();
				   		JOptionPane.showMessageDialog(this, "������ �����!", " ", JOptionPane.ERROR_MESSAGE);
				   		displayField.setBackground(Color.RED);
				   	}
			    }
			    catch (FileNotFoundException ex) {
			    	JOptionPane.showMessageDialog(this, "��� ������ �������� ������ ��������� ������", " ", JOptionPane.ERROR_MESSAGE);
			    }
	    	}
	    	else 
	    		JOptionPane.showMessageDialog(this, "������������ ������ �������", " ", JOptionPane.ERROR_MESSAGE);
	    }	    	  	 
	    if (actioncommand == dataGen.b_cancel_txt) {
	    	this.resultParam = false; // ������������ ����� ������
			this.dispose(); // ���������� ����
	    }
	} 
}

