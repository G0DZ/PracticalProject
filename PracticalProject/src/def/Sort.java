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
    	
     	// �������, ��� ���� ������� ����� ��������� GroupLayout
    	GroupLayout grl = new GroupLayout(p1);
    	p1.setLayout(grl);
    	
    	// Automatic gap insertion:
    	grl.setAutoCreateGaps(true);
    	grl.setAutoCreateContainerGaps(true);
    	
    	grl.setHorizontalGroup(
    			grl.createSequentialGroup()
    			      .addComponent(button_input, 180, 180, 180)
    			      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
    			    		.addComponent(button_start_sort, 180, 180, 180)
    	    			    .addComponent(button_make_step, 180, 180, 180))
    			   	  .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
    			           .addComponent(button_check, 180, 180, 180)
    			           .addComponent(button_save, 180, 180, 180)
    			           .addComponent(button_revival, 180, 180, 180))
    			);
    	grl.setVerticalGroup(
    			grl.createSequentialGroup()
    				  .addGroup(grl.createParallelGroup(GroupLayout.Alignment.LEADING)     
    					   .addComponent(button_input, 30, 30, 30)
    					   .addComponent(button_start_sort, 30, 30, 30)
    					   .addComponent(button_check, 30, 30, 30)
    			           )
    			      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.LEADING)  
    			           .addComponent(button_make_step, 30, 30, 30)
    			           .addComponent(button_save, 30, 30, 30))    			      
    			      .addComponent(button_revival, 30, 30, 30)
    			);
    	  
		// ��� ���������� ������
		SortEngine sEngine = new SortEngine(this);
		button_input.addActionListener(sEngine);
		button_start_sort.addActionListener(sEngine);
		button_check.addActionListener(sEngine);
		button_make_step.addActionListener(sEngine);
		button_revival.addActionListener(sEngine);

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
		
		Data data =  new Data();
		new Sort();
		
	}

}
