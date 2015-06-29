package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChooseSorting extends JDialog implements ActionListener{

		private int resultSort = 0; // результат работы окна (true - нажатие кнопки OK, false - нажатие кнопки Отмена);
		Data dataGen;
	    JButton button_Insertion;
	    JButton button_Merge;
	    JButton button_Insertion_Step;
	    JButton button_Merge_Step;
		JPanel panel;
	    
		public ChooseSorting(SortEngine parent, Data data) {

			super(parent, true); 
			dataGen = data;
			
			//Описание окна
	    	// Создаем тектовое поле и 2 кнопочки
			// Создаем текстовое поле размером в 50 колоннок
		    button_Insertion = new JButton(data.b_Insertion_txt);
		    button_Merge = new JButton(data.b_Merge_txt);
		    button_Insertion_Step = new JButton(data.b_Insertion_step_txt);
		    button_Merge_Step = new JButton(data.b_Merge_step_txt);
	        // Назначаем кнопочкам слушателей
	    	button_Insertion.addActionListener(this);
	    	button_Insertion_Step.addActionListener(this);
	    	button_Merge.addActionListener(this);
	    	button_Merge_Step.addActionListener(this);
	    	
	    	// Добавляем кнопочки на панель и тектовое поле тоже добавим-ка
	    	panel = new JPanel();
	    	BoxLayout bl = new BoxLayout(panel, BoxLayout.Y_AXIS);
	    	panel.setLayout(bl);
	    	panel.add(button_Insertion);
	    	panel.add(button_Insertion_Step);
	    	panel.add(button_Merge);
	    	panel.add(button_Merge_Step);
	    	
	      	this.add(panel);
	    	// Сделать размер окна подходящим
	        this.pack();
	    	// Запрет на изменение размера экрана
	    	this.setResizable(false);		
			this.setTitle("Выбор способа сортировкии");
	    	//Точка размещения экрана
	    	Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    	int w = this.getWidth();
	    	int h = this.getHeight();
	    	center.x = center.x - w/2; 
	    	center.y = center.y - h/2;
	    	this.setLocation(center);
		}
		
		public int executeSort() { // метод для "общения" с родительским окном
			this.setVisible(true); // прорисовать дочернее окно; в данном месте выполнение программы приостановится, ожидая окончания работы пользователя (в нашем случае - функции dispose())
	        return this.resultSort; // вернуть в качестве результата условное значение нажатой кнопки
		}
				 
		 public void actionPerformed(ActionEvent e) {
			 
			// Получение источника события
		    JButton clickedButton =  (JButton) e.getSource();
		    String actioncommand = clickedButton.getActionCommand();

		    if (actioncommand == dataGen.b_Insertion_txt) 
		    {
		    	this.resultSort = 1; 
				this.dispose(); // уничтожить окно	    	
		    }
		    if (actioncommand == dataGen.b_Insertion_step_txt) 
		    {
		    	this.resultSort = 11; // пользователь нажал Отмена
				this.dispose(); // уничтожить окно
		    }
		    if (actioncommand == dataGen.b_Merge_txt) 
		    {
		    	this.resultSort = 2; // пользователь нажал Отмена
				this.dispose(); // уничтожить окно
		    }
		    if (actioncommand == dataGen.b_Merge_step_txt) 
		    {
		    	this.resultSort = 22; // пользователь нажал Отмена
				this.dispose(); // уничтожить окно
		    }
		} 
	}
