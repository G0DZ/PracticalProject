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
    	button_check = new JButton("Проверка");
    	button_save = new JButton("Сохранение");
    	button_revival = new JButton("Восстановление");

    	
    	// Создаем панель p1
    	p1 = new JPanel();
    	// Говорим, что этой панелью будет управлять GridLayout с таблице1 2*3
    	GridLayout gl =new GridLayout(2,3);
    	p1.setLayout(gl);

    	// Добавляем кнопочки на панель p1
    	p1.add(button_input);
		p1.add(button_start_sort);
		p1.add(button_check);
		p1.add(button_save);
		p1.add(button_revival);
 
		/*  
		// Тут подключаем движок
		CalculatorEngine calcEngine = new CalculatorEngine(this);
  		button0.addActionListener(calcEngine);
		button1.addActionListener(calcEngine);
		button2.addActionListener(calcEngine);
		button3.addActionListener(calcEngine);
		button4.addActionListener(calcEngine);*/

		// Размещаем панель p1 по центру экрана (главной панели)
        windowContent.add("Center",p1);
        
        // Создаем фрейм, задаем ему название и размещаем там нашу главную панель          
		JFrame frame = new JFrame("Sort");
	    frame.setContentPane(windowContent);

	    // Устанавливаем размер окна достаточно большим, чтобы разместить на нем все нужные объекты
        frame.pack(); 

		// Отображаю окно 
		frame.setVisible(true);
     }
  
	public static void main(String[] args) {
		
		new Sort();
	}

}
