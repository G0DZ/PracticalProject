package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Generation extends JDialog implements ActionListener {
	
	JPanel windowGeneration;
	JButton button_file;
    JButton button_string;
    JButton button_auto;
    JButton button_cancel;
    Data dataGen;
	private boolean result; // результат работы окна (true - нажатие кнопки OK, false - нажатие кнопки Отмена);
	
	public Generation(java.awt.Frame parent, Data data) {

		super(parent, true); 
		dataGen = data;		
		
		// Создаем кнопочки
		button_file = new JButton(dataGen.b_file_txt);
		button_string = new JButton(dataGen.b_string_txt);
		button_auto = new JButton(dataGen.b_auto_txt);
		button_cancel = new JButton(dataGen.b_cancel_txt);
		
	    // Назначаем кнопочкам слушателей
		button_file.addActionListener(this);
		button_string.addActionListener(this);
		button_auto.addActionListener(this);
		button_cancel.addActionListener(this);

				
		// Добавляем кнопочки на панель
		windowGeneration = new JPanel();
		GroupLayout grl = new GroupLayout(windowGeneration);
		windowGeneration.setLayout(grl);
		// Automatic gap insertion:
		grl.setAutoCreateGaps(true);
    	grl.setAutoCreateContainerGaps(true); 	
    	
    	grl.setHorizontalGroup(
    			grl.createSequentialGroup()
    			      .addGroup(grl.createParallelGroup(GroupLayout.Alignment.CENTER)
    			    		.addComponent(button_file)
    	    			    .addComponent(button_string)
    	    			    .addComponent(button_auto)
    	    			    .addComponent(button_cancel))
    			);
    	grl.setVerticalGroup(
    			grl.createSequentialGroup()
    				  .addComponent(button_file)
    	    		  .addComponent(button_string)
    	    		  .addComponent(button_auto)
    	    		  .addComponent(button_cancel)
    			);
    	
		this.add(windowGeneration);
		
		// Сделать размер окна подходящим
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
	}
	
	public boolean execute() { // метод для "общения" с родительским окном
		this.setVisible(true); // прорисовать дочернее окно; в данном месте выполнение программы приостановится, ожидая окончания работы пользователя (в нашем случае - функции dispose())
        return this.result; // вернуть в качестве результата условное значение нажатой кнопки
	}
	
	 public void actionPerformed(ActionEvent e) {
		 
		// Получение источника события
	    JButton clickedButton =  (JButton) e.getSource();
	    String actioncommand = clickedButton.getActionCommand();
	    if (actioncommand == dataGen.b_file_txt) {
	    	
	    	this.result = true; 
			this.dispose(); // уничтожить окно		    		
	    }
	    if (actioncommand == dataGen.b_string_txt) {
	    	
	    	
	    	
	    	this.result = true; 
			this.dispose(); // уничтожить окно	    	
	    }
	    if (actioncommand == dataGen.b_auto_txt) { 
	    	
	    	
	    	
	    	this.result = true; 
			this.dispose(); // уничтожить окно	    	
	    }
	    if (actioncommand == dataGen.b_cancel_txt) {
	    	this.result = false; // пользователь нажал Отмена
			this.dispose(); // уничтожить окно
	    }
	} 

}