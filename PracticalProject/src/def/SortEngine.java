package def;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortEngine implements ActionListener {
 
	Sort parent; // ссылка на Sort
	Data dataEngine;
	
    // Конструктор сохраняет ссылку к Sort window в переменной класса parent
    SortEngine(Sort parent, Data data){
    	this.parent = parent;
    	dataEngine = new Data();
    }
       	   
    public boolean readArray(String fileName, int real_length) {
    	
    	try {
	    	Scanner in = new Scanner(new File(fileName));
	    	real_length = 0;
			while(in.hasNextInt()){
				dataEngine.array[real_length] = in.nextInt();	
				real_length++;
			}
			in.close();	
	    	return true;
    	}
    	catch (FileNotFoundException ex) {
       		return false;
    	}
    }
  
    public void actionPerformed(ActionEvent e) {
    	
    	// Получение источника события
    	JButton clickedButton =  (JButton) e.getSource();
    	// Если это кнопка "Ввод исходных данных"
    	if (clickedButton.getActionCommand() == "Ввод исходных данных") {
    		// Считать исходные данные в массив array[];
    		int real_length = 0;
    		boolean inforWasRead = readArray("input1.txt", real_length);		
    		
    		if (inforWasRead) { 
    			AlgorithmOfSort.insertionSort(dataEngine.array);
    			    			
    			parent.vpanel.PanelArray = new int[dataEngine.array.length];
    			for (int i = 0; i < dataEngine.array.length; i++) {
    				parent.vpanel.PanelArray[i] = dataEngine.array[i];
    			}
    			parent.vpanel.repaint();
    		}
    		else {
    			parent.setDisplayValue("Файл не найден!");
    		}
    	}
    } 
    
}

