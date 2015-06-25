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
       	   
    public boolean readArray(String fileName) {
    	
    	try {
	    	Scanner in = new Scanner(new File(fileName));
			int i = 0;
			while(in.hasNextInt()){
				i++;
				dataEngine.array[i] = in.nextInt();		
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
    		boolean inforWasRead = readArray("input1.txt");		
    		
    		if (inforWasRead) {
    			//parent.setDisplayValue("Массив считан успешно!"); 
    			AlgorithmOfSort.insertionSort(dataEngine.array);
    			
    			
    			parent.vpanel.PanelArray = new int[dataEngine.array.length];
    			for (int i = 0; i < dataEngine.array.length; i++) {
    				parent.vpanel.PanelArray[i] = dataEngine.array[i];
    			}
    			parent.vpanel.repaint();
    			    			
    			
    			//for (int i = 0; i < dataEngine.array.length; i++) {
    			//	String dispFieldText = parent.getDisplayValue();
    			//	parent.setDisplayValue(dispFieldText+dataEngine.array[i]+" ");
    			//}
    			
    			//выделить память под PanelArray
    			//в цикле присвоить значение элементов
    			//вызвать метод repaint
    			
    			
    			/*for (int i:parent.vpanel.PanelArray) {
    				parent.vpanel.PanelArray[i] = i;
    			}*/
    			//parent.vpanel.repaint();
    		}
    		else {
    			parent.setDisplayValue("Файл не найден!");
    		}
    		// Считываем, что у нас есть в displayField - объект класса JTextField
    		//String dispFieldText = parent.getDisplayValue();
    		//String clickedButtonLabel = clickedButton.getText();
    	}
    } 
    
}

