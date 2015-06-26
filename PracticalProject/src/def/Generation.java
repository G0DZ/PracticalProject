package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Generation extends JDialog implements ActionListener {
	
	JPanel windowGeneration;
	JButton button_file;
    JButton button_string;
    JButton button_auto;
    JButton button_cancel;
    Data dataGen;
	private boolean result; // ��������� ������ ���� (true - ������� ������ OK, false - ������� ������ ������);
	
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
	
	 public void actionPerformed(ActionEvent e) {
		 
		// ��������� ��������� �������
	    JButton clickedButton =  (JButton) e.getSource();
	    String actioncommand = clickedButton.getActionCommand();
	    if (actioncommand == dataGen.b_file_txt) {
	    	
	    	this.result = true; 
			this.dispose(); // ���������� ����		    		
	    }
	    if (actioncommand == dataGen.b_string_txt) {
	    	
	    	
	    	
	    	this.result = true; 
			this.dispose(); // ���������� ����	    	
	    }
	    if (actioncommand == dataGen.b_auto_txt) { 
	    	
	    	
	    	
	    	this.result = true; 
			this.dispose(); // ���������� ����	    	
	    }
	    if (actioncommand == dataGen.b_cancel_txt) {
	    	this.result = false; // ������������ ����� ������
			this.dispose(); // ���������� ����
	    }
	} 

}