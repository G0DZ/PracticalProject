package def;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Sort {

	// Объявление компонент
	JPanel windowContent;
	JPanel p1;
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
    Sort(){

    	// Создаем панель (как бы главную панель)
    	windowContent= new JPanel();
    	// Говорим, что этой панелью будет управлять BorderLayout 
    	BorderLayout bl = new BorderLayout(); 
        windowContent.setLayout(bl);
        
        // Создаем текстовое поле размером в 30 колоннок
        displayField = new JTextField(30);
        // Размещаем его в верхней части экрана
        windowContent.add("North",displayField);
        
        // Создаем кнопочки (с помощью конструктора им можно задать имя)
    	button_input = new JButton("Ввод исходных данных");
    	button_start_sort = new JButton("Запуск сортировки");
    	button_make_step = new JButton("Шаг");
    	button_check = new JButton("Проверка");
    	button_save = new JButton("Сохранение");
    	button_revival = new JButton("Восстановление");

    	
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
		SortEngine sEngine = new SortEngine(this);
		button_input.addActionListener(sEngine);
		button_start_sort.addActionListener(sEngine);
		button_check.addActionListener(sEngine);
		button_make_step.addActionListener(sEngine);
		button_revival.addActionListener(sEngine);

		// Размещаем панель p1 по центру экрана (главной панели)
        windowContent.add("Center",p1);
        
        // Создаем фрейм, задаем ему название и размещаем там нашу главную панель          
		JFrame frame = new JFrame("Sort");
	    frame.setContentPane(windowContent);

	    // Устанавливаем размер окна достаточно большим, чтобы разместить на нем все нужные объекты
        frame.pack(); 
        // Запрет на изменение размера экрана
        frame.setResizable(false);
		// Отображаю окно 
		frame.setVisible(true);
     }
  
	public static void main(String[] args) {
		
		Data data =  new Data();
		new Sort();
		
	}

}
