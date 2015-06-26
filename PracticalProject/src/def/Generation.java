package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Generation extends JDialog implements ActionListener {
	
	
	
	/*
	 * 
	
	    private void jButtonOKMouseClicked(java.awt.event.MouseEvent evt) { // ��������� ������� ������� ��
			this.result = true; // ������������ ����� ��
			this.dispose(); // ���������� ����
	    }
	 
		private void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt) {
			this.result = false; // ������������ ����� ������
			this.dispose(); // ���������� ����
		}
	       
	        public boolean execute() { // ����� ��� "�������" � ������������ �����
	                this.setVisible(true); // ����������� �������� ����; � ������ ����� ���������� ��������� ��������������, ������ ��������� ������ ������������ (� ����� ������ - ������� dispose())
			return this.result; // ������� � �������� ���������� �������� �������� ������� ������
	         }
	*/
	
	JPanel windowGeneration;
	JPanel paramPanel;
	JPanel radioPanel;
	JRadioButton radio_file;
    JRadioButton radio_string;
    JRadioButton radio_auto;
    JButton button_opt_for;
	private boolean result; // ��������� ������ ���� (true - ������� ������ OK, false - ������� ������ ������);
	
	public Generation(java.awt.Frame parent, Data data) {

		super(parent, true); 
		
		// ������� ������ (��� �� ������� ������)
		windowGeneration = new JPanel();
    	// �������, ��� ���� ������� ����� ��������� BorderLayout 
    	BorderLayout blG = new BorderLayout(); 
    	windowGeneration.setLayout(blG);

        //Create the radio buttons.
        radio_file = new JRadioButton(data.rb_file_txt);
        radio_file.setSelected(true);
        radio_string = new JRadioButton(data.rb_string_txt);
        radio_auto = new JRadioButton(data.rb_auto_txt);
        button_opt_for = new JButton(data.b_opt_for_txt);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
	    group.add(radio_file);
	    group.add(radio_string);
	    group.add(radio_auto);

	    //Register a listener for the radio buttons.
	    radio_file.addActionListener(this);
	    radio_string.addActionListener(this);
	    radio_auto.addActionListener(this);

	    //Put the radio buttons in a column in a panel.
	    radioPanel = new JPanel(new GridLayout(0, 1));
	    radioPanel.add(radio_file);
	    radioPanel.add(radio_string);
	    radioPanel.add(radio_auto);

		windowGeneration.add("North",radioPanel);
	    button_opt_for.setPreferredSize(new Dimension(15, 10));
	    windowGeneration.add("Center",button_opt_for);
	    paramPanel = new JPanel();
	    windowGeneration.add("South",paramPanel);
	    
	    
	          
	    // ������� �����, ������ ��� �������� � ��������� ��� ���� ������� ������          
	    JFrame frame = new JFrame(data.f_Generation_txt);
		frame.setContentPane(windowGeneration);
		   
        //Display the window.
        frame.pack();
	    // ������ �� ��������� ������� ������
	    frame.setResizable(false);
	        
	    //����� ���������� ������
	    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    int w = frame.getWidth();
	    int h = frame.getHeight();
	    center.x = center.x - w/2; 
	    center.y = center.y - h/2;
	    frame.setLocation(center);
	    
	    frame.setVisible(true);
	}
	
	
	 public void actionPerformed(ActionEvent e) {
	    	
	    	/*
	    	// ��������� ��������� �������
	    	JButton clickedButton =  (JButton) e.getSource();
	    	// ���� ��� ������ "���� �������� ������"
	    	if (clickedButton.getActionCommand() == dataEngine.b_input_txt) {
	    		// ������� �������� ������ � ������ array[];
	    		int real_length = 0;
	    		boolean inforWasRead = readArray("input1.txt", real_length);		
	    		
	    		if (inforWasRead) { 
	    			AlgorithmOfSort.insertionSort(dataEngine.array);
	    			    			
	    			parent.vpanel.PanelArray = new int[dataEngine.array.length];
	    			for (int i = 0; i < dataEngine.array.length; i++) {
	    				parent.vpanel.PanelArray[i] = dataEngine.array[i];
	    			}
	    			parent.vpanel.repaint();
	    		}
	    		else {
	    			parent.setDisplayValue("���� �� ������!");
	    		}
	    	}*/
	    } 
	 /* public boolean readArray(String fileName, int real_length) {
 	
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
 }*/

}