package def;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Sort {

	// ���������� ���������
	JPanel windowContent;
	JPanel p1;
	// 1. ������
	JButton button_input;
	JButton button_start_sort;
	JButton button_make_step;
	JButton button_check;
	JButton button_save;
	JButton button_revival;
	// 2. ��������� ���� (��������� - ��� �������� ������������ ������)
	private JTextField displayField;

    public void setDisplayValue(String val){
        displayField.setText(val);
    }

    public String getDisplayValue() {
        return displayField.getText();
    } 

    // ����������� ��� ��� �������� ��� ����
    Sort(){

    	// ������� ������ (��� �� ������� ������)
    	windowContent= new JPanel();
    	// �������, ��� ���� ������� ����� ��������� BorderLayout 
    	BorderLayout bl = new BorderLayout(); 
        windowContent.setLayout(bl);
        
        // ������� ��������� ���� �������� � 30 ��������
        displayField = new JTextField(30);
        // ��������� ��� � ������� ����� ������
        windowContent.add("North",displayField);
        
        // ������� �������� (� ������� ������������ �� ����� ������ ���)
    	button_input = new JButton("���� �������� ������");
    	button_start_sort = new JButton("������ ����������");
    	button_make_step = new JButton("���");
    	button_check = new JButton("��������");
    	button_save = new JButton("����������");
    	button_revival = new JButton("��������������");

    	
    	// ������� ������ p1
    	p1 = new JPanel();
    	
    	// �������, ��� ���� ������� ����� ��������� GridLayout � �������1 2*3
    	//GridLayout gl =new GridLayout(2,3);
    	//p1.setLayout(gl);
    	
    	// �������, ��� ���� ������� ����� ��������� GroupLayout
    	GroupLayout grl = new GroupLayout(p1);
    	p1.setLayout(grl);
    	
    	// Automatic gap insertion:
    	grl.setAutoCreateGaps(true);
    	grl.setAutoCreateContainerGaps(true);
    	
    	grl.setHorizontalGroup(
    			grl.createSequentialGroup()
    			      .addComponent(button_input)
    			      .addComponent(button_start_sort)
    			      .addComponent(button_make_step)
    			      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.LEADING)
    			           .addComponent(button_check)
    			           .addComponent(button_save)
    			           .addComponent(button_revival))
    			);
    	grl.setVerticalGroup(
    			grl.createSequentialGroup()
    			      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.BASELINE)
    			           .addComponent(button_input)
    			           .addComponent(button_start_sort)
    			           .addComponent(button_make_step)
    			           .addComponent(button_check))
    			      .addComponent(button_save)
    			      .addComponent(button_revival)
    			);
    	
    	
    	
    	
    	
    	
    	/*
    	// ��������� �������� �� ������ p1
    	p1.add(button_input);
		p1.add(button_start_sort);
		p1.add(button_check);
		p1.add(button_save);
		p1.add(button_revival);*/
 
		/*  
		// ��� ���������� ������
		CalculatorEngine calcEngine = new CalculatorEngine(this);
  		button0.addActionListener(calcEngine);
		button1.addActionListener(calcEngine);
		button2.addActionListener(calcEngine);
		button3.addActionListener(calcEngine);
		button4.addActionListener(calcEngine);*/

		// ��������� ������ p1 �� ������ ������ (������� ������)
        windowContent.add("Center",p1);
        
        // ������� �����, ������ ��� �������� � ��������� ��� ���� ������� ������          
		JFrame frame = new JFrame("Sort");
	    frame.setContentPane(windowContent);

	    // ������������� ������ ���� ���������� �������, ����� ���������� �� ��� ��� ������ �������
        frame.pack(); 
        // ������ �� ��������� ������� ������
        frame.setResizable(false);
		// ��������� ���� 
		frame.setVisible(true);
     }
  
	public static void main(String[] args) {
		
		new Sort();
	}

}
