package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Generation extends JDialog implements ActionListener {
	
	JPanel windowGeneration;
	JButton button_file;
    JButton button_string;
    JButton button_auto;
    JButton button_cancel;
    Data dataGen;
	private boolean result; // результат работы окна (true - нажатие кнопки OK, false - нажатие кнопки Отмена);
	// А это для дочернего процесса дочернего
	private GenerationParam dialog = null; //сслыка, пока пустая, на объект дочернего окна
	
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
	
	 public boolean readArray(File file, int real_length) {
	    	
	    try {
		   	Scanner in = new Scanner(file);
		   	real_length = 0;
		   	int size = 0;
		   	if (in.hasNextInt()) 
		   		size =  in.nextInt();
		   	else 
		   		return false;
		   	dataGen.array = new int[size];
		   	if (in.hasNextInt()) {
				while(in.hasNextInt()){
					dataGen.array[real_length] = in.nextInt();	
					real_length++;				
				}
				in.close();
				return true;
		   	}
		   	else
		   		return false;
	    }
	    catch (FileNotFoundException ex) {
	    	return false;
	    }
	 }
	 
	 public void actionPerformed(ActionEvent e) {
		 
		// Получение источника события
	    JButton clickedButton =  (JButton) e.getSource();
	    String actioncommand = clickedButton.getActionCommand();
	    if (actioncommand == dataGen.b_file_txt) {
	    	// Создаем новый объект
	    	// Отображаем диалог пользователю
	    	// В ret заносится значение, по которому мы можем понять, что хочет пользователь
	    	JFileChooser fileopen = new JFileChooser();             
	    	int ret = fileopen.showDialog(null, "Открыть файл");
	    	if (ret == JFileChooser.APPROVE_OPTION) {
	    	    File file = fileopen.getSelectedFile();
	    	    int real_length = 0;
	    	    // Считываем массив тут
	    	    boolean inforWasRead = readArray(file, real_length);   	    
	    		if ((dataGen.array == null) || (!inforWasRead))
	    		{ //если массив пустой, тогда
	    			JOptionPane.showMessageDialog(null, "При чтении с файла произошла ошибка", " ", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		else {
	    			//custom title, no icon
	    			JOptionPane.showMessageDialog(this, "Данные считаны успешно!"," ", JOptionPane.PLAIN_MESSAGE);	    		}
	    		}
	    	this.result = true; 
			this.dispose(); // уничтожить окно		    		
	    }
	    if (actioncommand == dataGen.b_string_txt) {
	    	
	    	
	    	this.dialog = new GenerationParam(this, dataGen);
    		if (this.dialog.executeParam()) {
		        // действия при нажатии клавиши ОК
 		        // здесь же прописывается считывание нужных результатов, введённых пользователем, используя функции get, заблаговременно прописанные вами в класе дочернего окна
 		    }
  		    else {
   		           // действия при нажатии на клавишу отмены	
   		    }  	
	    	
	    	
	    	
	    	this.result = true; 
			this.dispose(); // уничтожить окно	    	
	    }
	    if (actioncommand == dataGen.b_auto_txt) { 
	    	
	    	
	 
	    	  	    		    		    	
	    	
	    	
	    	Random r = new Random();
	    	dataGen.array = new int[48];
	    	for(int j = 0; j < dataGen.array.length; j++)
	    		dataGen.array[j] = r.nextInt(70);	    	
	    	this.result = true; 
			this.dispose(); // уничтожить окно	    	
	    }
	    if (actioncommand == dataGen.b_cancel_txt) {
	    	this.result = false; // пользователь нажал Отмена
			this.dispose(); // уничтожить окно
	    }
	} 

}