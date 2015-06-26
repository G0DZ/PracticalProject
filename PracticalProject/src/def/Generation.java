package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Generation extends JDialog implements ActionListener {
	
	JPanel windowGeneration;
	JPanel cancelOKPanel;
	JPanel radioPanel;
	JRadioButton radio_file;
    JRadioButton radio_string;
    JRadioButton radio_auto;
    JButton button_opt_for;
    JButton button_OK;
    JButton button_cancel;
	private boolean result; // результат работы окна (true - нажатие кнопки OK, false - нажатие кнопки Отмена);
	
	public Generation(java.awt.Frame parent, Data data) {

		super(parent, true); 
		
		// Создаем панель (как бы главную панель)
		windowGeneration = new JPanel();
    	// Говорим, что этой панелью будет управлять BorderLayout 
    	BorderLayout blG = new BorderLayout(); 
    	windowGeneration.setLayout(blG);

        //Create the radio buttons.
        radio_file = new JRadioButton(data.rb_file_txt);
        radio_file.setSelected(true);
        radio_string = new JRadioButton(data.rb_string_txt);
        radio_auto = new JRadioButton(data.rb_auto_txt);
        button_opt_for = new JButton(data.b_opt_for_txt);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
	    group.add(radio_file);
	    group.add(radio_string);
	    group.add(radio_auto);

	    //Register a listener for the radio buttons.
	    radio_file.addActionListener(this);
	    radio_string.addActionListener(this);
	    radio_auto.addActionListener(this);

	    //Put the radio buttons in a column in a panel.
	    radioPanel = new JPanel(new GridLayout(0, 1));
	    radioPanel.add(radio_file);
	    radioPanel.add(radio_string);
	    radioPanel.add(radio_auto);
	    
	    button_OK = new JButton(data.b_OK_txt);
	    button_cancel = new JButton(data.b_cancel_txt);
	    cancelOKPanel = new JPanel();
	    FlowLayout fL = new FlowLayout(); 
    	windowGeneration.setLayout(fL);
    	cancelOKPanel.add(button_OK);
 	    cancelOKPanel.add(button_cancel);

		windowGeneration.add("North",radioPanel);
	    button_opt_for.setPreferredSize(new Dimension(15, 10));
	    windowGeneration.add("Center",button_opt_for);
	    windowGeneration.add("South",cancelOKPanel);
	    
	    
	          
	    // Создаем фрейм, задаем ему название и размещаем там нашу главную панель          
	    JFrame frame = new JFrame(data.f_Generation_txt);
		frame.setContentPane(windowGeneration);
		   
        //Display the window.
        frame.pack();
	    // Запрет на изменение размера экрана
	    frame.setResizable(false);
	        
	    //Точка размещения экрана
	    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    int w = frame.getWidth();
	    int h = frame.getHeight();
	    center.x = center.x - w/2; 
	    center.y = center.y - h/2;
	    frame.setLocation(center);
	    
	    frame.setVisible(true);
	}
	
	
	 public void actionPerformed(ActionEvent e) {
		 
		 
		 
		 
		 
		 /*
			 * 
			
			    private void jButtonOKMouseClicked(java.awt.event.MouseEvent evt) { // обработка нажатия клавиши ОК
					this.result = true; // пользователь нажал ОК
					this.dispose(); // уничтожить окно
			    }
			 
				private void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt) {
					this.result = false; // пользователь нажал Отмена
					this.dispose(); // уничтожить окно
				}
			       
			        public boolean execute() { // метод для "общения" с родительским окном
			                this.setVisible(true); // прорисовать дочернее окно; в данном месте выполнение программы приостановится, ожидая окончания работы пользователя (в нашем случае - функции dispose())
					return this.result; // вернуть в качестве результата условное значение нажатой кнопки
			         }
			*/
		 
		 
	    
	    } 

}