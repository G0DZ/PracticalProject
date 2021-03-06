package def;

import javax.swing.*;
import java.awt.*;

public class VisPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private final int fontsize = 14; //������ ������.
	private int WidthCoef;
	private int HeigthCoef;
	
	public ColorInt[] PanelArray;
	
	public Sort parent = null; //��������� �� ��������
	private String SortDef = "����������: ";
	String SortName = null;
	private String Comp = "���������: ";
	int CompInt;
	private String AC = "�������� � �������: "; 
	int ACInt;
	private String Delay = "�������� : ";
	private String ms = " ��";
	private String Delim = " | ";
	
	private String NumberofElements = " ����.";
	
	public VisPanel(Sort p) 
	{
		setOpaque(true);
		parent = p;
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
			{ //������� �� ������ ��� ���������� � ����������.
				String S = SortDef+SortName+Delim+Comp+CompInt+Delim+AC+ACInt+Delim+Delay+parent.SleepTime+ms;
				g2d.drawString(S, 5, 12);
			}
			//������ ��������� � ����������� ���������.
			g2d.drawString(PanelArray.length+NumberofElements, (int) (getWidth()-fontsize*5.54), fontsize-2); //6,54 - ���������� ������ ������� �� ������� ������ (����������������) 
		    //����� ���������
			int max=PanelArray[0].I;   //��������� ������� ��� ������ ������������� �������� � ������� (����� ���������� �������)
		    for(int i = 1;i < PanelArray.length; i++)
		        if(PanelArray[i].I > max)
		        	max = PanelArray[i].I; //����� ������������� ��������
		    int k=(getHeight()-45)/max; //��������� ������� - ������ ����� ����� ����� 5px � ����� ��� ��� �� ������������ ��������
		    for(int i=0;i<PanelArray.length;i++) 
		    {
			    // drawing axis
			    g2d.setPaint(PanelArray[i].InColor);
		    	g2d.fillRect(i*WidthCoef,getHeight()-k*PanelArray[i].I,HeigthCoef,k*PanelArray[i].I); //������ �������������
		    }
		}
    }
	
	void reInitComponents()
	{
		CompInt = 0;
		ACInt = 0;
	}

}