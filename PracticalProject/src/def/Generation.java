package def;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Generation extends JPanel {
	
	JPanel paramPanel;
	
	 public Generation(Data data) {
	        super(new BorderLayout());

	        //Create the radio buttons.
	        JRadioButton radio_file = new JRadioButton(Data.rb_file_txt);
	        radio_file.setSelected(true);
	        JRadioButton radio_string = new JRadioButton(Data.rb_string_txt);
	        JRadioButton radio_auto = new JRadioButton(Data.rb_auto_txt);

	        //Group the radio buttons.
	        ButtonGroup group = new ButtonGroup();
	        group.add(radio_file);
	        group.add(radio_string);
	        group.add(radio_auto);

	        //Register a listener for the radio buttons.
	        GenerationEngine gEngine = new GenerationEngine(this, data);
	        radio_file.addActionListener(gEngine);
	        radio_string.addActionListener(gEngine);
	        radio_auto.addActionListener(gEngine);

	        //Put the radio buttons in a column in a panel.
	        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
	        radioPanel.add(radio_file);
	        radioPanel.add(radio_string);
	        radioPanel.add(radio_auto);

	        add(radioPanel, BorderLayout.NORTH);
	        paramPanel = new JPanel();
	        add(paramPanel, BorderLayout.SOUTH);
	        setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
	    }

	    public static void createAndShowGENERATION(Data data) {
	        //Create and set up the window.
	        JFrame frame = new JFrame(Data.f_Generation_txt);
	        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Create and set up the content pane.
	        JComponent newContentPane = new Generation(data);
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);

	        //Display the window.
	        frame.pack();
	        // Запрет на изменение размера экрана
	        frame.setResizable(false);
	        frame.setVisible(true);
	    }	

}