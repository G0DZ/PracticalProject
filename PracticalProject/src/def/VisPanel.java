package def;

import javax.swing.*;
import java.awt.*;

public class VisPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private final int fontsize = 14; //размер шрифта.
	public ColorInt[] PanelArray;
	private int WidthCoef;
	private int HeigthCoef;
	
	private String SortDef = "Сортировка: ";
	String SortName = null;
	private String Comp = "Сравнений: ";
	int CompInt;
	private String AC = "Доступов к массиву: "; 
	int ACInt;
	private String Delay = "Задержка : ";
	int DelayInt = 0;
	private String ms = " мс";
	private String Delim = " | ";
	
	private String NumberofElements = " элем.";
	
	public VisPanel() 
	{
		setOpaque(true);
	}

	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		if(PanelArray != null)
		{
			WidthCoef = getWidth()/PanelArray.length;
		    if (WidthCoef > 1) 
		    	HeigthCoef=WidthCoef-WidthCoef/3; 
		    else 
		    	HeigthCoef=WidthCoef=1;
		    
		    Graphics2D g2d = (Graphics2D) g;
		    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    // drawing finction 
			g2d.setFont(new Font("Calibri", Font.PLAIN, fontsize));
		    if (SortName != null)
			{
				String S = SortDef+SortName+Delim+Comp+CompInt+Delim+AC+ACInt+Delim+Delay+DelayInt+ms;
				g2d.drawString(S, 5, 12);
			}
			//печать сообщения с количеством элементов.
			g2d.drawString(PanelArray.length+NumberofElements, (int) (getWidth()-fontsize*4.54), fontsize-2); //6,54 - коэфициент ширины символа от размера шрифта (экспериментально) 
		    //поиск максимума
			int max=PanelArray[0].I;   //начальное условие для поиска максимального элемента в массиве (чтобы определить масштаб)
		    for(int i = 1;i < PanelArray.length; i++)
		        if(PanelArray[i].I > max)
		        	max = PanelArray[i].I; //поиск максимального элемента
		    int k=(getHeight()-45)/max; //вычисляем масштаб - высота сцены минус запас 5px и делим это все на максимальное значение
		    for(int i=0;i<PanelArray.length;i++) 
		    {
			    // drawing axis
			    g2d.setPaint(PanelArray[i].InColor);
		    	g2d.fillRect(i*WidthCoef,getHeight()-k*PanelArray[i].I,HeigthCoef,k*PanelArray[i].I); //рисуем прямоугольник
		    }
		}
    }
	
	void reInitComponents()
	{
		CompInt = 0;
		ACInt = 0;
		DelayInt = 0;
	}

}