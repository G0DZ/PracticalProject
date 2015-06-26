package def;

import def.SortAlgorithms.InsertionSort;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortEngine extends JFrame implements ActionListener {
 
	Sort parent; // ссылка на Sort
	private Generation dialog = null; //сслыка, пока пустая, на объект дочернего окна
	Data dataEngine;
	
    // Конструктор сохраняет ссылку к Sort window в переменной класса parent
    SortEngine(Sort parent, Data data){
    	this.parent = parent;
    	dataEngine = data;
    }
     /*  	    
    // обработчик нажатия на кнопку, которая по логике должна вызывать дочернее окно
    private void jButtonAddMouseClicked(MouseEvent evt) {
    	 // создаём объект дочернего окна, передавая в конструктор this-ссылку - т.о., именно это окно становится для нового родительским
        this.dialog = new Generation(this, dataEngine);
        
        /*  if (this.dialog.execute()) {
        // действия при нажатии клавиши ОК
        // здесь же прописывается считывание нужных результатов, введённых пользователем, используя функции get, заблаговременно прописанные вами в класе дочернего окна
        }
        else {
            // действия при нажатии на клавишу отмены	
        }*/
   // }*/

 
    
    public boolean readArray(String fileName, int real_length) {
    	
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
    }
    	
    public void actionPerformed(ActionEvent e) {
    	
    	// Получение источника события
    	JButton clickedButton =  (JButton) e.getSource();
    	// Если это кнопка "Ввод исходных данных"
    	String actioncommand = clickedButton.getActionCommand();
    	if (actioncommand == dataEngine.b_input_txt) {
    	
    		 this.dialog = new Generation(this, dataEngine); 	
    	
    	
    	}
    	if(actioncommand == dataEngine.b_start_sort_txt)
    	{ //если это кнопка "Запуск сортировки"
    		int real_length = 0;
    		boolean inforWasRead = readArray("input1.txt", real_length);	
    		if (dataEngine.array == null)
    		{ //если массив пустой, тогда
    			JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
    			return;
    		}	
			parent.vpanel.PanelArray = new int[dataEngine.array.length];
			for (int i = 0; i < dataEngine.array.length; i++) {
				parent.vpanel.PanelArray[i] = dataEngine.array[i];
			}
    		Thread is1 = new InsertionSort(parent);
    		is1.start();
    	}
    }
    
}

