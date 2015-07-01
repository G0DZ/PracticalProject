package def;

import java.awt.*;

import javax.swing.*;

public class Logic extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pl;
	static JLabel label_general;
	static JLabel label_general_text;
	static JLabel label_legend;
	static JLabel label_legend_text;
	static JLabel label_explanations_text;
	static JTextField tf_red;
	static JTextField tf_yellow;
	static JTextField tf_green;
	static JTextField tf_blue;
	SortEngine parentSE;

	Logic(SortEngine se) {
	          	        
		parentSE = se;
		label_general = new JLabel("Общие сведения");
		label_general_text = new JLabel("<HTML>Сортировка вставками (англ. Insertion sort) — алгоритм сортировки, в котором элементы входной последовательности просматриваются по одному, и каждый новый поступивший элемент размещается в подходящее место среди ранее упорядоченных элементов. Вычислительная сложность - O(n^2).");
		label_legend = new JLabel("Условные обозначения");
		label_legend_text = new JLabel("<HTML> -  следующий элемент <br> -  текущий элемент <br> -  элемент больше или равен текущему <br> -  элемент меньше текущего");
		label_explanations_text = new JLabel("Пояснения");
		
	    Font font = new Font("Calibri", Font.BOLD , 14);
	    label_general.setFont(font);  
	    label_legend.setFont(font); 
	    label_explanations_text.setFont(font);
	    Font fontAD = new Font("Calibri", Font.PLAIN , 14);
	    label_general_text.setFont(fontAD);
	    label_legend_text.setFont(fontAD);

	    tf_red = new JTextField();
	    tf_yellow = new JTextField();
	    tf_green = new JTextField();
	    tf_blue = new JTextField();	 
	    
	    tf_red.setBackground(Color.RED);
	    tf_yellow.setBackground(Color.YELLOW);
	    tf_green.setBackground(Color.GREEN);
	    tf_blue.setBackground(Color.CYAN);
	         
	    // Добавляем на панель
		pl = new JPanel();
		pl .setLayout(null);
					
		label_general.setBounds(20,  20,  150,  15);
		label_general_text.setBounds(20, 40, 390, 85);
		label_legend.setBounds(20,  135,  150,  15);
		label_legend_text.setBounds(40,  155,  390,  70);
		tf_red.setBounds(20,  160,  15,  15);
	    tf_yellow.setBounds(20,  177,  15,  15);
	    tf_green.setBounds(20,  195,  15,  15);
	    tf_blue.setBounds(20,  212,  15,  15);
	    label_explanations_text.setBounds(20,  237,  150,  15);
	    
	    tf_red.setEnabled(false);
	    tf_yellow.setEnabled(false);
	    tf_green.setEnabled(false);
	    tf_blue.setEnabled(false);
		
		pl.add(label_general);
		pl.add(label_legend);
		pl.add(label_general_text);
		pl.add(label_legend_text);
		pl.add(tf_red);
		pl.add(tf_yellow);
		pl.add(tf_green);
		pl.add(tf_blue);
		pl.add(label_explanations_text);
	
		getContentPane().add(pl);
		setPreferredSize(new Dimension(500, 430));
	    	 	
	    // Устанавливаем размер окна достаточно большим, чтобы разместить на нем все нужные объекты
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
		// Отображаю окно 
        this.setVisible(true);
     } 
	       	
}
