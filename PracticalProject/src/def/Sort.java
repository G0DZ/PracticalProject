package def;
import javax.swing.*;

import java.awt.*;

public class Sort extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Объявление компонент
	//JPanel windowContent;
	JPanel p1;
	VisPanel vpanel;
	// 1. Кнопки
	JButton button_input;
	JButton button_start_sort;
	JButton button_make_step;
	static JButton button_check;
	JButton button_save;
	JButton button_revival;


    // Конструктор нам все нарисует как надо
    Sort(Data data){
       
        vpanel = new VisPanel();
        vpanel.setPreferredSize(new Dimension(1000, 380));
        vpanel.setBackground(Color.CYAN);       
        
        // Создаем кнопочки (с помощью конструктора им можно задать имя)
    	button_input = new JButton(data.b_input_txt);
    	button_start_sort = new JButton(data.b_start_sort_txt);
    	button_make_step = new JButton(data.b_make_step_txt);
    	button_check = new JButton(data.b_check_txt);
    	button_save = new JButton(data.b_save_txt);
    	button_revival = new JButton(data.b_revival_txt);
    		
    	// Добавляем кнопочки на панель
		p1 = new JPanel();
		p1 .setLayout(null);
		
		vpanel.setBounds(20, 20, 1100, 400);
		button_input.setBounds(20, 460, 180, 80);
		
		button_start_sort.setBounds(510, 440, 150, 30);
		button_make_step.setBounds(510, 500, 150, 30);
		
		button_check.setBounds(700, 440, 150, 30);
		button_save.setBounds(700, 500, 150, 30);
		button_revival.setBounds(700, 550, 150, 30);
		
		p1.add(vpanel);
		p1.add(button_input);
		p1.add(button_start_sort);
		p1.add(button_make_step);
		p1.add(button_check);
		p1.add(button_save);
		p1.add(button_revival);
		
		
		
		
		
		
		
		
			
		getContentPane().add(p1);
		setPreferredSize(new Dimension(1145, 610));
    	 	
		// Тут подключаем движок
		SortEngine sEngine = new SortEngine(this, data);
		button_input.addActionListener(sEngine);
		button_start_sort.addActionListener(sEngine);
		button_check.addActionListener(sEngine);
		button_make_step.addActionListener(sEngine);
		button_revival.addActionListener(sEngine);
           
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // Устанавливаем размер окна достаточно большим, чтобы разместить на нем все нужные объекты
		this.pack(); 
        // Запрет на изменение размера экрана
		this.setResizable(false);                   
        //Точка размещения экрана
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int w = this.getWidth();
        int h = this.getHeight();
        center.x = center.x - w/2; 
        center.y = center.y - h/2;
        this.setLocation(center);
		// Отображаю окно 
        this.setVisible(true);
     }
       
}
