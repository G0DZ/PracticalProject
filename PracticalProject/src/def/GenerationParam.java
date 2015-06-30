package def;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.Random;
import java.io.File;

public class GenerationParam extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean resultParam; // ��������� ������ ���� (true - ������� ������ OK, false - ������� ������ ������);
	int mode; // ����� ������ ���������������� ����
	// ������ ��� �������
	JPanel p1;
	JPanel p2;
	JPanel allP;
	JLabel label1;
	JLabel label2;
	JLabel label_space;
	JSpinner spin;
	JSpinner spin1;
	JSpinner spin2;
	private JTextField displayField;
    JButton button_OK;
    JButton button_cancel;
    Data dataGen;
    String forArray;
    
    public void setDisplayValue(String val){
        displayField.setText(val);
    }

    public String getDisplayValue() {
        return displayField.getText();
    } 
    
    ChangeListener listener = new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        	Object val = spin.getValue();
            if (val instanceof Integer) {
            	  int result = (int) val;
            	  if (result > Data.const_max) {
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
    
	public GenerationParam(Generation parent, Data data, int md) {

		super(parent, true); 
		dataGen = data;
		mode= md;
// ����� 1
		if (mode == 1) {
			// ����� � ����
			label1 = new JLabel("������� ������ �������");
			SpinnerModel model =
			        new SpinnerNumberModel(1, //initial value
			                               1, //min
			                               Data.const_max, //max
			                               1); //step
			spin = new JSpinner(model);
			spin.addChangeListener(listener);			
			
			// ����� + ������ ����� + 2 ������
			label2 = new JLabel("������� �������� ������� ����� ������");		
		    displayField = new JTextField(100);
		    button_OK = new JButton(data.b_OK_txt);
		    button_cancel = new JButton(data.b_cancel_txt);
		    
		    label_space = new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	     	
	        // ��������� ��������� ����������
	    	button_cancel.addActionListener(this);
	    	button_OK .addActionListener(this);
	
	    	// ��������� �������� �� ������
			p1 = new JPanel();
			p1.setLayout(null);
			label1.setBounds(20, 20, 150, 20);
			spin.setBounds(200, 20, 50, 30);
			label2.setBounds(20, 50, 250, 30);
			displayField.setBounds(20, 90, 400, 30);
			label_space.setBounds(20, 125, 400, 20);
			button_OK.setBounds(40, 150, 150, 30);
			button_cancel.setBounds(250, 150, 150, 30);
			
			p1.add(label1);
			p1.add(spin);
			p1.add(label2);
			p1.add(displayField);
			p1.add(label_space);
			p1.add(button_OK);
			p1.add(button_cancel);
			
			getContentPane().add(p1);
			setPreferredSize(new Dimension(440, 220));
	    	
	      	this.add(p1); 		
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
// ����� 2
		if (mode == 2) {
			label_space = new JLabel("                                                                                         ");
			// ������� ����� + ����
			label1 = new JLabel("������� ������ �������");
			SpinnerModel model =
			        new SpinnerNumberModel(100, //initial value
			                               1, //min
			                               Data.const_max, //max
			                               1); //step
			spin = new JSpinner(model);
			spin.addChangeListener(listener);			
			// ������� ����� + ���� + ���� 
			label2 = new JLabel("������� ����������� � ������������ �������� ���������");	
			SpinnerModel model1 =
			        new SpinnerNumberModel(1, //initial value
			                               1, //min
			                               Integer.MAX_VALUE, //max
			                               1); //step
			spin1 = new JSpinner(model1);
			//spin.addChangeListener(listener);			
			SpinnerModel model2 =
			        new SpinnerNumberModel(300, //initial value
			                               1, //min
			                               Integer.MAX_VALUE, //max
			                               1); //step
			spin2 = new JSpinner(model2);
			//spin.addChangeListener(listener);
						
		  	// ������� 2 ��������									
			button_OK = new JButton(data.b_OK_txt);
			button_cancel = new JButton(data.b_cancel_txt); 	
			// ��������� ��������� ����������
			button_cancel.addActionListener(this);
			button_OK .addActionListener(this);
			
			 label_space = new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
			// ��������� �������� �� ������
			p1 = new JPanel();
			p1.setLayout(null);
			label1.setBounds(20, 20, 150, 20);
			spin.setBounds(200, 20, 50, 30);
			label2.setBounds(20, 50, 400, 30);
			spin1.setBounds(200, 90, 50, 30);
			spin2.setBounds(270, 90, 50, 30);
			label_space.setBounds(20, 130, 400, 20);
			button_OK.setBounds(40, 155, 150, 30);
			button_cancel.setBounds(250, 155, 150, 30);
					
			p1.add(label1);
			p1.add(spin);
			p1.add(label2);
			p1.add(spin1);
			p1.add(spin2);
			p1.add(label_space);
			p1.add(button_OK);
			p1.add(button_cancel);
						
			getContentPane().add(p1);
			setPreferredSize(new Dimension(440, 225));

			/*			
			// ��������� �������� �� ������ � �������� ���� ���� �������-��
			p1 = new JPanel();
			GroupLayout grl = new GroupLayout(p1);
			p1.setLayout(grl);
			grl.setHorizontalGroup(
					grl.createSequentialGroup()
					      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
					    		.addComponent(label1)
					    		.addComponent(label2))
			    	      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
			    	    		.addComponent(spin)
						    	.addComponent(spin1)
						    	.addComponent(label_space))
			    	      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
			    	    		  .addComponent(spin2))
					);
			grl.setVerticalGroup(
					grl.createSequentialGroup()
					      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
					    		.addComponent(label1)
					    		.addComponent(spin))
					      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
					            .addComponent(label_space))
			    	      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
			    	    		.addComponent(label2)
			    	    		.addComponent(spin1)
						    	.addComponent(spin2))					  
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
			    allP.add("Center",p2);  */ 	
			    
			    this.add(p1);
			    		
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
	}
	
	public boolean executeParam() { // ����� ��� "�������" � ������������ �����
		this.setVisible(true); // ����������� �������� ����; � ������ ����� ���������� ��������� ��������������, ������ ��������� ������ ������������ (� ����� ������ - ������� dispose())
        return this.resultParam; // ������� � �������� ���������� �������� �������� ������� ������
	}
		
	 public void actionPerformed(ActionEvent e) {		 
		// ��������� ��������� �������
	    JButton clickedButton =  (JButton) e.getSource();
	    String actioncommand = clickedButton.getActionCommand();
// ������ "��"
	    if (actioncommand == dataGen.b_OK_txt) {
// ����� 1
	    	if (mode == 1) {	    	
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
// ����� 2
	    	if (mode == 2) {	    	
		    	// ��������� ������ �������    	
		    	Object val = spin.getValue();
		    	int result = 0;
		    	if (val instanceof Integer) {
	            	result = (int) val;            		           
		            dataGen.array = new int[result];
		            
		            // ��������� ����������� ��������    	
			    	val = spin1.getValue();
			    	int param_min = 1;
			    	if (val instanceof Integer) {
			    		param_min = (int) val;  
			    		
			    		// ��������� ������������ ��������    	
				    	val = spin2.getValue();
				    	int param_max = Integer.MAX_VALUE;
				    	if (val instanceof Integer) {
				    		param_max = (int) val; 				           
				            // � ������ ������� ������������ �������� � ������
				            Random r = new Random();
			    	    	for(int j = 0; j < dataGen.array.length; j++)
			    	    		dataGen.array[j] = r.nextInt(param_max)+param_min;
			    	    	this.resultParam = true; // ������������ ����� ��
			    			this.dispose(); // ���������� ����
				    	}	
			    	}   		            
		    	}
	    	}
		} 
// ������ "������"
		if (actioncommand == dataGen.b_cancel_txt) {
			this.resultParam = false; // ������������ ����� ������
			this.dispose(); // ���������� ����
		}
	 }
}

