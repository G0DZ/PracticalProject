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
	static JButton button_logic;
	static JButton button_help;
	static JButton button_about_prog;
	static JRadioButton r_demo_mode;
	static JRadioButton r_step_mode;
	static JLabel label_opt_for_mode;
	static JRadioButton r_ins_s;
	static JRadioButton r_mer_s;
	static JLabel label_opt_for_sort;
	static JLabel label_posib;
	static JLabel label_option_step;
	static JLabel label_help;
	JProgressBar progressBar;
	JSlider slider;
	JCheckBox needToPaint;
	public LogicIns L = null;
	public boolean typeOfSort;
	public int SleepTime = 50;
	
    // Конструктор нам все нарисует как надо
    @SuppressWarnings("deprecation")
	Sort(Data data) {
       
        vpanel = new VisPanel(this);
        vpanel.setPreferredSize(new Dimension(1100, 445));
        vpanel.setBackground(Color.PINK);       
        
        // Создаем кнопочки (с помощью конструктора им можно задать имя)
    	button_input = new JButton("Cursor.HAND_CURSOR");    	
    	button_start_sort = new JButton("Cursor.HAND_CURSOR");
    	button_make_step = new JButton("Cursor.HAND_CURSOR");
    	button_check = new JButton("Cursor.HAND_CURSOR");
    	button_save = new JButton("Cursor.HAND_CURSOR");
    	button_revival = new JButton("Cursor.HAND_CURSOR");
    	button_logic = new JButton("Cursor.HAND_CURSOR");
    	button_help = new JButton("Cursor.HAND_CURSOR");
    	button_about_prog = new JButton("Cursor.HAND_CURSOR");
    	
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
		button_logic.setLabel(data.b_logic_txt);
		button_logic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_help.setLabel(data.b_help_txt);
		button_help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_about_prog.setLabel(data.b_about_prog_txt);
		button_about_prog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
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
        label_help = new JLabel("Справка");
       
        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);
		
        slider = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        Font font = new Font("Calibri", Font.PLAIN, 14);
        slider.setFont(font);
        
        needToPaint = new JCheckBox("<HTML>Вкл./Выкл. отображение <br>логики алгоритма");
        needToPaint.setSelected(true);
         
    	// Добавляем кнопочки на панель
		p1 = new JPanel();
		p1 .setLayout(null);
		
		vpanel.setBounds(0, 0, 1100, 445);
		progressBar.setBounds(0, 445, 1100, 25);	
		button_input.setBounds(10, 495, 200,30);
		label_opt_for_mode.setBounds(220,  472,  250,  25);
		r_demo_mode.setBounds(270, 492, 150, 25);
		r_step_mode.setBounds(270, 512, 150, 25);			
		label_opt_for_sort.setBounds(265,  535,  250,  25);
		r_ins_s.setBounds(270, 555, 150, 25);
		r_mer_s.setBounds(270, 575, 150, 25);		
		button_start_sort.setBounds(10, 530, 200,30);
		button_make_step.setBounds(440, 495, 200, 30);
		button_logic.setBounds(440, 530, 200, 30);
		slider.setBounds(428, 565, 226, 50);
		button_check.setBounds(660, 495, 200, 30);
		button_save.setBounds(660, 565, 200, 30);
		button_revival.setBounds(660, 530, 200, 30);
		label_posib.setBounds(670, 470, 200, 30);
		label_option_step.setBounds(453, 470, 200, 30);	
		label_help.setBounds(950, 470, 200, 30);	
		needToPaint.setBounds(25, 570, 180,30);
		//button_help.setBounds(880, 495, 200, 30);
		button_about_prog.setBounds(880, 530, 200, 30);
		
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
		p1.add(button_logic);
		p1.add(slider);
		p1.add(button_check);
		p1.add(button_save);
		p1.add(button_revival);
		p1.add(label_posib);
		p1.add(label_option_step);
		p1.add(label_help);
		p1.add(needToPaint);
		p1.add(button_help);
		p1.add(button_about_prog);
		
		// В начале блокируем все кнопки, кроме одной 
		button_start_sort.setEnabled(false);
    	button_make_step.setEnabled(false);
    	button_check.setEnabled(false);
    	button_save.setEnabled(false);
    	button_revival.setEnabled(false);
    	button_logic.setEnabled(false);
		
		getContentPane().add(p1);
		setPreferredSize(new Dimension(1100, 640));
    	 	
		// Тут подключаем движок
		SortEngine sEngine = new SortEngine(this, data);
		button_input.addActionListener(sEngine);
		button_start_sort.addActionListener(sEngine);
		button_check.addActionListener(sEngine);
		button_make_step.addActionListener(sEngine);
		button_revival.addActionListener(sEngine);
		button_save.addActionListener(sEngine);
		button_logic.addActionListener(sEngine);
		slider.addChangeListener(sEngine);
		button_help.addActionListener(sEngine);
		button_about_prog.addActionListener(sEngine);
		
		// Подключаем всплывающие подсказки
		vpanel.setToolTipText("Визуализация сортировки");
		progressBar.setToolTipText("Прогресс сортировки");
		slider.setToolTipText("Задержка отрисовки");
		button_input.setToolTipText("<HTML>Нажми для ввода исходных данных <br>из файла, строки ввода или автоматически <br>с заданием параметров генерации");
		button_start_sort.setToolTipText("<HTML>Нажми для запуска сортировки (кнопка <br>доступна при наличии исходных данных)");
		button_make_step.setToolTipText("<HTML>Нажми, чтобы сделать шаг алгоритма (кнопка <br>доступна только в пошаговом режиме)");		
		button_check.setToolTipText("<HTML>Нажми для проверки массива <br>на упорядоченность по неубыванию");
		button_save.setToolTipText("<HTML>Нажми для сохранения отсортированного <br>массива ");
		button_revival.setToolTipText("<HTML>Нажми для восстановления <br>исходных данных");
		button_logic.setToolTipText("<HTML>Нажми для получения объяснения <br>работы алгоритма");
		button_help.setToolTipText("Нажми для получения помощи");
		button_about_prog.setToolTipText("<HTML>Нажми для получения общей информации <br>о программе");
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
        
        L = new LogicIns(this);
		L.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);      
     } 
       
}
