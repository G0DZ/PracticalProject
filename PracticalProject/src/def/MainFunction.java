package def;

public class MainFunction {

	public static void main(String[] args) 
	{
		Data data =  new Data();
		new Sort(data);	
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Generation.createAndShowGENERATION(data);
            }
        });
	}

}
