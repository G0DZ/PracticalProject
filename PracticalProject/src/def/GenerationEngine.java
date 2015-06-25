package def;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenerationEngine implements ActionListener {
 
	Generation parentGen; 
	Data dataEngineGen;
	
    GenerationEngine(Generation parentParam, Data dataParam){
    	this.parentGen = parentParam;
    	dataEngineGen = dataParam;
    }
       	   
   /* public boolean readArray(String fileName, int real_length) {
    	
    	try {
	    	Scanner in = new Scanner(new File(fileName));
	    	real_length = 0;
	    	int size =  in.nextInt();
	    	dataEngine.array = new int[size];
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
    }*/
  
    public void actionPerformed(ActionEvent e) {
    	/*
    	// Получение источника события
    	JButton clickedButton =  (JButton) e.getSource();
    	// Если это кнопка "Ввод исходных данных"
    	if (clickedButton.getActionCommand() == dataEngine.b_input_txt) {
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
    	}*/
    } 
    
}

