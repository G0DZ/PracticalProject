package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class GenerationParam extends JDialog implements ActionListener {
	private boolean resultParam; // результат работы окна (true - нажатие кнопки OK, false - нажатие кнопки Отмена);
	JPanel p1;
	JPanel p2;
	JPanel allP;
	private JTextField displayField;
    JButton button_OK;
    JButton button_cancel;
    Data dataGen;

    public void setDisplayValue(String val){
        displayField.setText(val);
    }

    public String getDisplayValue() {
        return displayField.getText();
    } 

	public GenerationParam(Generation parent, Data data) {

		super(parent, true); 
		dataGen = data;
		
    	// Создаем тектовое поле и 2 кнопочки
		// Создаем текстовое поле размером в 50 колоннок
	    displayField = new JTextField(50);
	    button_OK = new JButton(data.b_OK_txt);
	    button_cancel = new JButton(data.b_cancel_txt);
     	
        // Назначаем кнопочкам слушателей
    	button_cancel.addActionListener(this);
    	button_OK .addActionListener(this);

    	// Добавляем кнопочки на панель и тектовое поле тоже добавим-ка
    	p1 = new JPanel();
    	FlowLayout fl1 = new FlowLayout();
    	p1.setLayout(fl1);
    	p1.add(displayField);
    	
    	p2 = new JPanel();
    	FlowLayout fl2 = new FlowLayout();
    	p2.setLayout(fl2);
    	p2.add(button_OK);
    	p2.add(button_cancel);
    	
    	allP = new JPanel();
    	BorderLayout allL = new BorderLayout();
    	allP.setLayout(allL);
    	allP.add("North",p1);
    	allP.add("Center",p2);
      	this.add(allP);
    		
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
	
	public boolean executeParam() { // метод для "общения" с родительским окном
		this.setVisible(true); // прорисовать дочернее окно; в данном месте выполнение программы приостановится, ожидая окончания работы пользователя (в нашем случае - функции dispose())
        return this.resultParam; // вернуть в качестве результата условное значение нажатой кнопки
	}
	
	 
	 public void actionPerformed(ActionEvent e) {
		 
		// Получение источника события
	    JButton clickedButton =  (JButton) e.getSource();
	    String actioncommand = clickedButton.getActionCommand();

	    if (actioncommand == dataGen.b_OK_txt) { 
	    	
	    	

/*

	    	String str = displayField.getText();
	    	char[] arrayChars = str.toCharArray();
	    	for (int j = 0; j < arrayChars.length; j++)
	    		dataGen.array[j] = Character.getNumericValue(arrayChars[j]);*/

	    	
	    	
	    	
	    	this.resultParam = true; 
			this.dispose(); // уничтожить окно	    	
	    }
	    if (actioncommand == dataGen.b_cancel_txt) {
	    	this.resultParam = false; // пользователь нажал Отмена
			this.dispose(); // уничтожить окно
	    }
	} 
}
