package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChooseSorting extends JDialog implements ActionListener{

		private int resultSort = 0; // ��������� ������ ���� (true - ������� ������ OK, false - ������� ������ ������);
		Data dataGen;
	    JButton button_Insertion;
	    JButton button_Merge;
	    JButton button_Insertion_Step;
	    JButton button_Merge_Step;
		JPanel panel;
	    
		public ChooseSorting(SortEngine parent, Data data) {

			super(parent, true); 
			dataGen = data;
			
			//�������� ����
	    	// ������� �������� ���� � 2 ��������
			// ������� ��������� ���� �������� � 50 ��������
		    button_Insertion = new JButton(data.b_Insertion_txt);
		    button_Merge = new JButton(data.b_Merge_txt);
		    button_Insertion_Step = new JButton(data.b_Insertion_step_txt);
		    button_Merge_Step = new JButton(data.b_Merge_step_txt);
	        // ��������� ��������� ����������
	    	button_Insertion.addActionListener(this);
	    	button_Insertion_Step.addActionListener(this);
	    	button_Merge.addActionListener(this);
	    	button_Merge_Step.addActionListener(this);
	    	
	    	// ��������� �������� �� ������ � �������� ���� ���� �������-��
	    	panel = new JPanel();
	    	BoxLayout bl = new BoxLayout(panel, BoxLayout.Y_AXIS);
	    	panel.setLayout(bl);
	    	panel.add(button_Insertion);
	    	panel.add(button_Insertion_Step);
	    	panel.add(button_Merge);
	    	panel.add(button_Merge_Step);
	    	
	      	this.add(panel);
	    	// ������� ������ ���� ����������
	        this.pack();
	    	// ������ �� ��������� ������� ������
	    	this.setResizable(false);		
			this.setTitle("����� ������� �����������");
	    	//����� ���������� ������
	    	Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    	int w = this.getWidth();
	    	int h = this.getHeight();
	    	center.x = center.x - w/2; 
	    	center.y = center.y - h/2;
	    	this.setLocation(center);
		}
		
		public int executeSort() { // ����� ��� "�������" � ������������ �����
			this.setVisible(true); // ����������� �������� ����; � ������ ����� ���������� ��������� ��������������, ������ ��������� ������ ������������ (� ����� ������ - ������� dispose())
	        return this.resultSort; // ������� � �������� ���������� �������� �������� ������� ������
		}
				 
		 public void actionPerformed(ActionEvent e) {
			 
			// ��������� ��������� �������
		    JButton clickedButton =  (JButton) e.getSource();
		    String actioncommand = clickedButton.getActionCommand();

		    if (actioncommand == dataGen.b_Insertion_txt) 
		    {
		    	this.resultSort = 1; 
				this.dispose(); // ���������� ����	    	
		    }
		    if (actioncommand == dataGen.b_Insertion_step_txt) 
		    {
		    	this.resultSort = 11; // ������������ ����� ������
				this.dispose(); // ���������� ����
		    }
		    if (actioncommand == dataGen.b_Merge_txt) 
		    {
		    	this.resultSort = 2; // ������������ ����� ������
				this.dispose(); // ���������� ����
		    }
		    if (actioncommand == dataGen.b_Merge_step_txt) 
		    {
		    	this.resultSort = 22; // ������������ ����� ������
				this.dispose(); // ���������� ����
		    }
		} 
	}
