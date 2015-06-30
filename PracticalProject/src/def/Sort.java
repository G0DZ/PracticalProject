package def;

import java.awt.*;

import javax.swing.*;

public class Sort extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int FPS_MIN = 0;
	static final int FPS_MAX = 500;
	static final int FPS_INIT = 50;    //initial frames per second
	// Объявление компонент
	JPanel p1;
	VisPanel vpanel;
	static JButton button_input;
	static JButton button_start_sort;
	static JButton button_make_step;
	static JButton button_check;
	static JButton button_save;
	static JButton button_revival;
	static JRadioButton r_demo_mode;
	static JRadioButton r_step_mode;
	static JLabel label_opt_for_mode;
	static JRadioButton r_ins_s;
	static JRadioButton r_mer_s;
	static JLabel label_opt_for_sort;
	static JLabel label_posib;
	static JLabel label_option_step;
	JProgressBar progressBar;
	JSlider slider;
	
	public int SleepTime = 50;
	
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
        label_posib = new JLabel("Дополнительные возможности");
        label_option_step = new JLabel("Дополнительные параметры");
       
        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);
		//progressBar.setValue(80);
		
        slider = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        Font font = new Font("Calibri", Font.PLAIN, 14);
        slider.setFont(font);
         
    	// Добавляем кнопочки на панель
		p1 = new JPanel();
		p1 .setLayout(null);
		
		vpanel.setBounds(0, 0, 1145, 400);
		progressBar.setBounds(0, 400, 1145, 25);	
		button_input.setBounds(20,440,180,50);
		label_opt_for_mode.setBounds(210,  425,  250,  25);
		r_demo_mode.setBounds(210, 450, 150, 25);
		r_step_mode.setBounds(210, 470, 150, 25);			
		label_opt_for_sort.setBounds(210,  505,  250,  25);
		r_ins_s.setBounds(210, 530, 150, 25);
		r_mer_s.setBounds(210, 550, 150, 25);		
		button_start_sort.setBounds(20,510,180,50);
		button_make_step.setBounds(600, 470, 150, 30);		
		slider.setBounds(480,520, 400, 50);
		button_check.setBounds(945, 460, 150, 30);
		button_save.setBounds(945, 540, 150, 30);
		button_revival.setBounds(945, 500, 150, 30);
		label_posib.setBounds(930, 425, 200, 30);
		label_option_step.setBounds(590, 425, 200, 30);	
		
		p1.add(vpanel);
		p1.add(progressBar);
		p1.add(button_input);
		p1.add(label_opt_for_mode);
		p1.add(r_demo_mode);
		p1.add(r_step_mode);			
		p1.add(label_opt_for_sort);
		p1.add(r_ins_s);
		p1.add(r_mer_s);		
		p1.add(button_start_sort);
		p1.add(button_make_step);
		p1.add(slider);
		p1.add(button_check);
		p1.add(button_save);
		p1.add(button_revival);
		p1.add(label_posib);
		p1.add(label_option_step);
		
		// В начале блокируем все кнопки, кроме одной 
		button_start_sort.setEnabled(false);
    	button_make_step.setEnabled(false);
    	button_check.setEnabled(false);
    	button_save.setEnabled(false);
    	button_revival.setEnabled(false);
		
		getContentPane().add(p1);
		setPreferredSize(new Dimension(1145, 610));
    	 	
		// Тут подключаем движок
		SortEngine sEngine = new SortEngine(this, data);
		button_input.addActionListener(sEngine);
		button_start_sort.addActionListener(sEngine);
		button_check.addActionListener(sEngine);
		button_make_step.addActionListener(sEngine);
		button_revival.addActionListener(sEngine);
		button_save.addActionListener(sEngine);
		slider.addChangeListener(sEngine);
		
		// Подключаем всплывающие подсказки
		

	
	
		
		vpanel.setToolTipText("Визуализация сортировки");
		progressBar.setToolTipText("Прогресс сортировки");
		slider.setToolTipText("Задержка отрисовки");
		button_input.setToolTipText("Нажми для ввода исходных данных из файла, строки ввода или автоматически с заданием параметров генерации");
		button_start_sort.setToolTipText("Нажми для запуска сортировки (кнопка доступна при наличии исходных данных)");
		button_make_step.setToolTipText("Нажми, чтобы сделать шаг алгоритма (кнопка доступна только в пошаговом режиме)");		
		button_check.setToolTipText("Нажми для проверки массива на упорядоченность по неубыванию");
		button_save.setToolTipText("Нажми для сохранения отсортированного массива в файл 'result.txt' ");
		button_revival.setToolTipText("Нажми для восстановления исходных данных");
	    ToolTipManager.sharedInstance().setInitialDelay(0);		
		  
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
