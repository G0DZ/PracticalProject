package def;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortEngine implements ActionListener {
 
	Sort parent; // ссылка на Sort
	
    // Конструктор сохраняет ссылку к Sort window в переменной класса parent
    SortEngine(Sort parent){
    	this.parent = parent;
    }
       	   
    public static boolean algorithm(String fileName) {
    	
    	try {
	    	Scanner in = new Scanner(new File(fileName));
			int i = 0;
			while(in.hasNextInt()){
				i++;
				Data.array[i] = in.nextInt();		
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
    		boolean inforWasRead = algorithm("input1.txt");		
    		
    		if (inforWasRead) {
    			parent.setDisplayValue("Массив считан успешно!");    			
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

