package def;
import def.SortAlgorithms.InsertionSort;
import def.SortAlgorithms.MergeSort;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import javax.swing.*;

public class SortEngine extends JFrame implements ActionListener {
 
	Sort parent; // ссылка на Sort
	private Generation dialogGen = null; //сслыка, пока пустая, на объект дочернего окна
	private ChooseSorting dialogChSort = null; //сслыка, пока пустая, на объект дочернего окна
	Data dataEngine;
	boolean haveBeenLoad;
	
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
	    			parent.vpanel.PanelArray = new int[dataEngine.array.length];
	    			for (int i = 0; i < dataEngine.array.length; i++) 
						parent.vpanel.PanelArray[i] = dataEngine.array[i];
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
	    			parent.vpanel.PanelArray = new int[dataEngine.array.length];
					for (int i = 0; i < dataEngine.array.length; i++) 
						parent.vpanel.PanelArray[i] = dataEngine.array[i];
	    			this.dialogChSort = new ChooseSorting(this, dataEngine);
	        		int x = this.dialogChSort.executeSort();
	    			switch(x)
	    			{
	    			case 1:
			    		Thread is1 = new InsertionSort(parent);
			    		is1.start();
			    		break;
	    			case 2:
	    				Thread is2 = new MergeSort(parent);
			    		is2.start();
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
	    		parent.vpanel.PanelArray = new int[dataEngine.array.length];
				for (int i = 0; i < dataEngine.array.length; i++) 
					parent.vpanel.PanelArray[i] = dataEngine.array[i];
				parent.vpanel.repaint();
				JOptionPane.showMessageDialog(this, "Исходный массив восстановлен!"," ", JOptionPane.INFORMATION_MESSAGE);
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
	    		if(parent.vpanel.PanelArray == null)
	    		{
	    			parent.vpanel.PanelArray = new int[dataEngine.array.length];
					for (int i = 0; i < dataEngine.array.length; i++) 
						parent.vpanel.PanelArray[i] = dataEngine.array[i];
	    		}
	    		boolean checkbool = true;
	    		for (int i = 1; i < parent.vpanel.PanelArray.length; i++)
	    		{
					if(parent.vpanel.PanelArray[i-1] > parent.vpanel.PanelArray[i])
					{
						JOptionPane.showMessageDialog(this, "Массив НЕ упорядочен!"," ", JOptionPane.INFORMATION_MESSAGE);
						checkbool = false;
						return;
					}
	    		}
	    		if(checkbool)
	    			JOptionPane.showMessageDialog(this, "Массив упорядочен!"," ", JOptionPane.INFORMATION_MESSAGE);
	    	}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "Исходные данные не загружены", " ", JOptionPane.WARNING_MESSAGE);
    			return;
    		}	
    	}
    }
    
}

