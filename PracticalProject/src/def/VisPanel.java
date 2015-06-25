package def;

import javax.swing.*;
import java.awt.*;


public class VisPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	public int[] PanelArray;
	private int WidthCoef;
	private int HeigthCoef;
	
	
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
		    // drawing axis
		    g2d.setPaint(Color.ORANGE);
		    // drawing finction 
		    int max=PanelArray[0];   //начальное условие для поиска максимального элемента в массиве (чтобы определить масштаб)
		    for(int i = 1;i < PanelArray.length; i++)
		        if(PanelArray[i] > max)
		        	max = PanelArray[i]; //поиск максимального элемента
		    int k=(getHeight()-5)/max; //вычисляем масштаб - высота сцены минус запас 5px и делим это все на максимальное значение
		    for(int i=0;i<PanelArray.length;i++) {
		    	g2d.fillRect(i*WidthCoef,0,HeigthCoef,k*PanelArray[i]); //рисуем прямоугольник
		    }
		}
    }

}