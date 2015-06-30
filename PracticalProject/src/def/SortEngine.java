package def;
import def.SortAlgorithms.InsertionSort;
import def.SortAlgorithms.MergeSort;
import def.SortAlgorithms.Check;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import javax.swing.*;

public class SortEngine extends JFrame implements ActionListener {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Sort parent; // ссылка на Sort
	private Generation dialogGen = null; //сслыка, пока пустая, на объект дочернего окна
	//private ChooseSorting dialogChSort = null; //сслыка, пока пустая, на объект дочернего окна
	Data dataEngine;
	boolean haveBeenLoad;
	InsertionSort IS;
	MergeSort MS;
	Check Ch;
	
    // Конструктор сохраняет ссылку к Sort window в переменной класса parent
    SortEngine(Sort parent, Data data){
    	this.parent = parent;
    	dataEngine = data;
    }
        	
    public void actionPerformed(ActionEvent e) {
    	
    	// Получение источника события
    	JButton clickedButton =  (JButton) e.getSource();
    	// Если это кнопка "Ввод исходных данных"
    	String actioncommand = clickedButton.getActionCommand();
    	if (actioncommand == dataEngine.b_input_txt) {
    		// обработчик нажатия на кнопку, которая по логике должна вызывать дочернее окно
    	    // создаём объект дочернего окна, передавая в конструктор this-ссылку - т.о., именно это окно становится для нового родительским
    		this.dialogGen = new Generation(this, dataEngine);
    		if (this.dialogGen.execute()) {
		        // действия при нажатии клавиши ОК
 		        // здесь же прописывается считывание нужных результатов, введённых пользователем, используя функции get, заблаговременно прописанные вами в класе дочернего окна
    			haveBeenLoad = true;
	    		if ((dataEngine.array == null) || (dataEngine.array.length == 0))
	    		{
	    			haveBeenLoad = false;
	    			JOptionPane.showMessageDialog(null, "Некорректные исходные данные", " ", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		else 
	    		{
	    			Sort.button_start_sort.setEnabled(true);
	    			Sort.button_check.setEnabled(true);
	    			Sort.button_save.setEnabled(true);
	    			parent.vpanel.PanelArray = new ColorInt[dataEngine.array.length];
	    			for (int i = 0; i < dataEngine.array.length; i++)
	    			{
	    				parent.vpanel.PanelArray[i] = new ColorInt();
						parent.vpanel.PanelArray[i].I = dataEngine.array[i];
	    			}
					parent.vpanel.SortName = null; //главное - не забыть, что сортировки нет, и убрать ее имя.
	    			parent.vpanel.repaint();
	    		}
    		}
  		    else {
   		        // действия при нажатии на клавишу отмены
  		    	haveBeenLoad = false;
   		    }	 		 
    		 
    	}
    	if(actioncommand == dataEngine.b_start_sort_txt)
    	{ //если это кнопка "Запуск сортировки"   		
    		if (haveBeenLoad)
    		{
    			Sort.button_start_sort.setEnabled(false);
    			Sort.button_check.setEnabled(false);
    			Sort.button_save.setEnabled(false);
    			Sort.button_revival.setEnabled(false);
    			Sort.button_input.setEnabled(false);
    			parent.vpanel.PanelArray = new ColorInt[dataEngine.array.length];
    			for (int i = 0; i < dataEngine.array.length; i++)
    			{
    				parent.vpanel.PanelArray[i] = new ColorInt();
					parent.vpanel.PanelArray[i].I = dataEngine.array[i];
    			}
	    		//this.dialogChSort = new ChooseSorting(this, dataEngine);
    			//int x = this.dialogChSort.executeSort();
    			int x = 0;
    			if ((Sort.r_demo_mode.isSelected()) && (Sort.r_ins_s.isSelected()))
    				x = 1;
    			if ((Sort.r_step_mode.isSelected()) && (Sort.r_ins_s.isSelected())) {
    				x = 11;
    				Sort.button_make_step.setEnabled(true);
    				Sort.button_start_sort.setEnabled(false);
    			}
    			if ((Sort.r_demo_mode.isSelected()) && (Sort.r_mer_s.isSelected()))
    				x = 2;
    			if ((Sort.r_step_mode.isSelected()) && (Sort.r_mer_s.isSelected())) {
    				x = 22;	
    				Sort.button_make_step.setEnabled(true);
    				Sort.button_start_sort.setEnabled(false);
    			}
	    		switch(x)
	    			{
	    			case 1:
	    				IS = new InsertionSort(parent, true);
			    		IS.start();
	    				break;
	    			case 11:
	    				IS = new InsertionSort(parent, false);
			    		IS.start();
	    				break;
	    			case 2:
	    				MS = new MergeSort(parent, true);
			    		MS.start();
			    		break;
	    			case 22:
	    				MS = new MergeSort(parent, false);
			    		MS.start();
			    		break;
	    			case 0:
	    				break;
	    		}
	    	}
    		else 
    		{
    			JOptionPane.showMessageDialog(null, "Исходные данные не загружены", " ", JOptionPane.WARNING_MESSAGE);
    			return;
    		}
    	}
    	if(actioncommand == dataEngine.b_revival_txt)
    	{ //если это кнопка "Восстановить"
    		if (haveBeenLoad) 
    		{ //если данные были загружены
    			parent.vpanel.PanelArray = new ColorInt[dataEngine.array.length];
    			for (int i = 0; i < dataEngine.array.length; i++)
    			{
    				parent.vpanel.PanelArray[i] = new ColorInt();
					parent.vpanel.PanelArray[i].I = dataEngine.array[i];
    			}
				parent.vpanel.SortName = null; //главное - не забыть, что сортировки нет, и убрать ее имя.
				parent.vpanel.repaint();
				JOptionPane.showMessageDialog(this, "Исходный массив восстановлен!"," ", JOptionPane.INFORMATION_MESSAGE);
				Sort.button_start_sort.setEnabled(true);
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "Исходные данные не загружены", " ", JOptionPane.WARNING_MESSAGE);
    			return;
    		}	
    	}
    	if(actioncommand == dataEngine.b_check_txt)
    	{ //если это кнопка "Проверка"
    		if (haveBeenLoad) 
    		{ //если данные были загружены
    			Ch = new Check(parent, dataEngine);
    			Ch.start();
	    	}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "Исходные данные не загружены", " ", JOptionPane.WARNING_MESSAGE);
    			return;
    		}	
    	}
    	if(actioncommand == dataEngine.b_make_step_txt)
    	{
    		if(IS != null)
    			IS.wakeSort();
    		if(MS != null)
    			MS.wakeSort();
    	}
    }
    
}

