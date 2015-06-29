package def;
import javax.swing.*;

import java.awt.*;

public class Sort extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Объявление компонент
	JPanel p1;
	VisPanel vpanel;
	JButton button_input;
	JButton button_start_sort;
	JButton button_make_step;
	static JButton button_check;
	JButton button_save;
	JButton button_revival;
	static JRadioButton r_demo_mode;
	static JRadioButton r_step_mode;
	JLabel label_opt_for_mode;
	static JRadioButton r_ins_s;
	static JRadioButton r_mer_s;
	JLabel label_opt_for_sort;


    // Конструктор нам все нарисует как надо
    @SuppressWarnings("deprecation")
	Sort(Data data) {
       
        vpanel = new VisPanel();
        vpanel.setPreferredSize(new Dimension(1000, 380));
        vpanel.setBackground(Color.PINK);       
        
        // Создаем кнопочки (с помощью конструктора им можно задать имя)
    	button_input = new JButton("Cursor.HAND_CURSOR");    	
    	button_start_sort = new JButton("Cursor.HAND_CURSOR");
    	button_make_step = new JButton("Cursor.HAND_CURSOR");
    	button_check = new JButton("Cursor.HAND_CURSOR");
    	button_save = new JButton("Cursor.HAND_CURSOR");
    	button_revival = new JButton("Cursor.HAND_CURSOR");
    	
    	button_input.setLabel(data.b_input_txt);
		button_input.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_start_sort.setLabel(data.b_start_sort_txt);
		button_start_sort.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		button_make_step.setLabel(data.b_make_step_txt);
		button_make_step.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_check.setLabel(data.b_check_txt);
		button_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_save.setLabel(data.b_save_txt);
		button_save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_revival.setLabel(data.b_revival_txt);
		button_revival.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
		r_demo_mode = new JRadioButton("Демонстрация");
		r_demo_mode.setActionCommand("Демонстрация");
		r_demo_mode.setSelected(true);
		r_step_mode = new JRadioButton("Пошаговый");
		r_step_mode.setActionCommand("Пошаговый");		
		ButtonGroup group = new ButtonGroup();
        group.add(r_demo_mode);
        group.add(r_step_mode);		
        label_opt_for_mode = new JLabel("Выбор режима работы программы");
        
    	r_ins_s = new JRadioButton("Вставками");
    	r_ins_s.setActionCommand("Вставками");
    	r_ins_s.setSelected(true);
		r_mer_s = new JRadioButton("Слиянием");
		r_mer_s.setActionCommand("Слиянием");		
		ButtonGroup group_s = new ButtonGroup();
        group_s.add(r_ins_s);
        group_s.add(r_mer_s);		
        label_opt_for_sort = new JLabel("Выбор сортировки");
        
    	// Добавляем кнопочки на панель
		p1 = new JPanel();
		p1 .setLayout(null);
		
		vpanel.setBounds(20, 20, 1100, 400);
		button_input.setBounds(20, 460, 180, 80);	
		label_opt_for_mode.setBounds(220,  425,  250,  25);
		r_demo_mode.setBounds(220, 450, 150, 25);
		r_step_mode.setBounds(220, 470, 150, 25);			
		label_opt_for_sort.setBounds(220,  505,  250,  25);
		r_ins_s.setBounds(220, 530, 150, 25);
		r_mer_s.setBounds(220, 550, 150, 25);		
		button_start_sort.setBounds(510, 440, 150, 30);
		button_make_step.setBounds(510, 500, 150, 30);		
		button_check.setBounds(700, 440, 150, 30);
		button_save.setBounds(700, 500, 150, 30);
		button_revival.setBounds(700, 550, 150, 30);
			
		p1.add(vpanel);
		p1.add(button_input);
		p1.add(label_opt_for_mode);
		p1.add(r_demo_mode);
		p1.add(r_step_mode);			
		p1.add(label_opt_for_sort);
		p1.add(r_ins_s);
		p1.add(r_mer_s);		
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
