package def;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class LogicIns extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pl;
	static JLabel label_general;
	static JLabel label_general_text;
	static JLabel label_legend;
	static JLabel label_legend_text;
	static JTextField tf_red;
	static JTextField tf_yellow;
	static JTextField tf_green;
	static JTextField tf_blue;
	JTextArea ta;
	String strLog = "";
	Sort parentSE;

	LogicIns(Sort se) {
	          	        
		parentSE = se;
// ЕСЛИ СОРТИРОВКА ВСТАВКАМИ		
		if (se.typeOfSort == true) {
			label_general = new JLabel("Общие сведения");
			label_general_text = new JLabel("<HTML>Сортировка вставками (англ. Insertion sort) — алгоритм сортировки, в котором элементы входной последовательности просматриваются по одному, и каждый новый поступивший элемент размещается в подходящее место среди ранее упорядоченных элементов. Вычислительная сложность - O(n^2).");
			label_legend = new JLabel("Условные обозначения");
			label_legend_text = new JLabel("<HTML> -  следующий элемент <br> -  текущий элемент <br> -  элемент меньше текущего <br> -  элемент меньше текущегоэлемент больше или равен текущему ");
			
		    Font font = new Font("Calibri", Font.BOLD , 14);
		    label_general.setFont(font);  
		    label_legend.setFont(font); 
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
		    
		    ta = new JTextArea("Пояснения\n", 450, 150);
		    ta.setFont(new Font("Calibri", Font.PLAIN , 20));
		    // Добавляем на панель
			pl = new JPanel();
			pl .setLayout(null);
						
			label_general.setBounds(20,  20,  150,  15);
			label_general_text.setBounds(20, 40, 450, 85);
			label_legend.setBounds(20,  135,  150,  15);
			label_legend_text.setBounds(40,  155,  450,  70);
			tf_red.setBounds(20,  160,  15,  15);
		    tf_yellow.setBounds(20,  177,  15,  15);
		    tf_blue.setBounds(20,  195,  15,  15);
		    tf_green.setBounds(20,  212,  15,  15);	    
		    
		    tf_red.setEnabled(false);
		    tf_yellow.setEnabled(false);
		    tf_green.setEnabled(false);
		    tf_blue.setEnabled(false);
		    	    
		    DefaultCaret caret = (DefaultCaret) ta.getCaret(); 
		    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		    JScrollPane scrollingArea = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
	        scrollingArea.setBounds(20, 237, 450, 150);	    
		    ta.setCaret(caret);
		    scrollingArea.setViewportView(ta);
		    		
			pl.add(label_general);
			pl.add(label_legend);
			pl.add(label_general_text);
			pl.add(label_legend_text);
			pl.add(tf_red);
			pl.add(tf_yellow);
			pl.add(tf_green);
			pl.add(tf_blue);
			pl.add(scrollingArea);
		
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
		}
// ЕСЛИ СОРТИРОВКА СЛИЯНИЕМ
		else
		{
			label_general = new JLabel("Общие сведения");
			label_general_text = new JLabel("<HTML>Сортировка слиянием (англ. Merge sort) — алгоритм сортировки, который упорядочивает последовательность в определённом порядке. Эта сортировка — хороший пример использования принципа «разделяй и властвуй». Сначала задача разбивается на несколько подзадач меньшего размера. Затем эти задачи решаются с помощью рекурсивного вызова или непосредственно, если их размер достаточно мал. Наконец, их решения комбинируются, и получается решение исходной задачи. <br>Вычислительная сложность - O(n log n)");		
			label_legend = new JLabel("Условные обозначения");
			label_legend_text = new JLabel("<HTML> -  правая часть в текущем разбиении <br> -  левая часть в предыдущем разбиении <br> -  левая часть в текущем разбиении <br>    Разбиением называется часть массива, сортируемая на данном этапе");
			
		    Font font = new Font("Calibri", Font.BOLD , 14);
		    label_general.setFont(font);  
		    label_legend.setFont(font); 
		    Font fontAD = new Font("Calibri", Font.PLAIN , 14);
		    label_general_text.setFont(fontAD);
		    label_legend_text.setFont(fontAD);

		    tf_yellow = new JTextField();
		    tf_green = new JTextField();
		    tf_blue = new JTextField();	 
		    
		    tf_yellow.setBackground(Color.YELLOW);
		    tf_green.setBackground(Color.GREEN);
		    tf_blue.setBackground(Color.CYAN);
		    
		    ta = new JTextArea("Пояснения\n", 450, 90);
		    ta.setFont(new Font("Calibri", Font.PLAIN , 12));
		    // Добавляем на панель
			pl = new JPanel();
			pl .setLayout(null);
						
			label_general.setBounds(20,  20,  150,  15);
			label_general_text.setBounds(20, 40, 450, 140);
			label_legend.setBounds(20,  190,  150,  15);
			label_legend_text.setBounds(40,  210,  450,  70);
		    tf_yellow.setBounds(20,  215,  15,  15);
		    tf_green.setBounds(20,  232,  15,  15);
		    tf_blue.setBounds(20,  250,  15,  15);
		    		    
		    tf_yellow.setEnabled(false);
		    tf_green.setEnabled(false);
		    tf_blue.setEnabled(false);
		    	    
		    DefaultCaret caret = (DefaultCaret) ta.getCaret(); 
		    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		    JScrollPane scrollingArea = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
	        scrollingArea.setBounds(20, 295, 450, 90);	    
		    ta.setCaret(caret);
		    scrollingArea.setViewportView(ta);
			
			pl.add(label_general);
			pl.add(label_legend);
			pl.add(label_general_text);
			pl.add(label_legend_text);
			pl.add(tf_yellow);
			pl.add(tf_green);
			pl.add(tf_blue);
			pl.add(scrollingArea);
		
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
		}		
     } 
	       	
}
