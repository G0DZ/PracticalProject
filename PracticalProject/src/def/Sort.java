package def;
import javax.swing.*;
import java.awt.*;

public class Sort {

	// Объявление компонент
	JPanel windowContent;
	JPanel p1;
	VisPanel vpanel;
	// 1. Кнопки
	JButton button_input;
	JButton button_start_sort;
	JButton button_make_step;
	JButton button_check;
	JButton button_save;
	JButton button_revival;
	// 2. Текстовое поле (временное - для проверки корректности работы)
	private JTextField displayField;

    public void setDisplayValue(String val){
        displayField.setText(val);
    }

    public String getDisplayValue() {
        return displayField.getText();
    } 

    // Конструктор нам все нарисует как надо
    Sort(Data data){

    	// Создаем панель (как бы главную панель)
    	windowContent= new JPanel();
    	// Говорим, что этой панелью будет управлять BorderLayout 
    	BorderLayout bl = new BorderLayout(); 
        windowContent.setLayout(bl);
        
        vpanel = new VisPanel();
        vpanel.setPreferredSize(new Dimension(500, 250));
        vpanel.setBackground(Color.PINK);
        windowContent.add("North",vpanel);
       
        
        // Создаем текстовое поле размером в 30 колоннок
        displayField = new JTextField(30);
        // Размещаем его в верхней части экрана
        windowContent.add("Center",displayField);
        
        // Создаем кнопочки (с помощью конструктора им можно задать имя)
    	button_input = new JButton(data.b_input_txt);
    	button_start_sort = new JButton(data.b_start_sort_txt);
    	button_make_step = new JButton(data.b_make_step_txt);
    	button_check = new JButton(data.b_check_txt);
    	button_save = new JButton(data.b_save_txt);
    	button_revival = new JButton(data.b_revival_txt);
    	
    	// Создаем панель p1
    	p1 = new JPanel();
    	
     	// Говорим, что этой панелью будет управлять GroupLayout
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
    	  
		// Тут подключаем движок
		SortEngine sEngine = new SortEngine(this, data);
		button_input.addActionListener(sEngine);
		button_start_sort.addActionListener(sEngine);
		button_check.addActionListener(sEngine);
		button_make_step.addActionListener(sEngine);
		button_revival.addActionListener(sEngine);

		// Размещаем панель p1 по центру экрана (главной панели)
        windowContent.add("South",p1);
        
        
        // Создаем фрейм, задаем ему название и размещаем там нашу главную панель          
		JFrame frameCore = new JFrame(data.f_Sort_txt);
		frameCore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frameCore.setContentPane(windowContent);

	    // Устанавливаем размер окна достаточно большим, чтобы разместить на нем все нужные объекты
        frameCore.pack(); 
        // Запрет на изменение размера экрана
        frameCore.setResizable(false);
		// Отображаю окно 
		frameCore.setVisible(true);
     }
    
}
