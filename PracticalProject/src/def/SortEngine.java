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
    	dataEngine = data;
    }
       	    
    public void actionPerformed(ActionEvent e) {
    	
    	// Получение источника события
    	JButton clickedButton =  (JButton) e.getSource();
    	// Если это кнопка "Ввод исходных данных"
    	if (clickedButton.getActionCommand() == dataEngine.b_input_txt) {
            Generation.createAndShowGENERATION(dataEngine);
    	}
    } 
    
}

