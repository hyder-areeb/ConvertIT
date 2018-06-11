//Import necessary libraries 
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javafx.scene.layout.Border;

// set up the class, with an action listener

public class a3 implements ActionListener{
	
	
	//initialize the core variables
	static double output = 0.0;
	String s_unit, f_unit;
	
	//initialize each component of the application 
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea textarea = new JTextArea(1,10);
	JTextArea textarea2 = new JTextArea(1,10);	
	JTextArea textarea3 = new JTextArea(1,10);
	
	JButton button_s_cm = new JButton();
	JButton button_s_in = new JButton();
	JButton button_s_c = new JButton();
	JButton button_s_f = new JButton();
	JButton button_s_lb = new JButton();
	JButton button_s_kg = new JButton();
	JButton button_f_cm = new JButton();
	JButton button_f_in = new JButton();
	JButton button_f_c = new JButton();
	JButton button_f_f = new JButton();
	JButton button_f_lb = new JButton();
	JButton button_f_kg = new JButton();
	
	JButton button_undo = new JButton();
	JButton button_continue = new JButton();
	JButton button_calculate = new JButton();
	
	//initialize a value for each button in the application 
	double s_cm, s_in, s_c, s_f, s_lb, s_kg, f_cm, f_in, f_c, f_f, f_lb, f_kg;
	
	public a3() {
		// set up the GUI components 
		frame.setSize(400, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("ConvertIT");
		
		frame.add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY,4);
		panel.setBorder(border);
		
		panel.add(textarea);
		
		textarea.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("arial", Font.BOLD, 27);
		textarea.setFont(font);
		textarea.setForeground(Color.WHITE);
		textarea.setText("Please select a starting unit: ");
		
		button_s_cm.setPreferredSize(new Dimension(100,50));
		button_s_cm.setText("centimetre");
		button_s_in.setPreferredSize(new Dimension(100,50));
		button_s_in.setText("inch");
		button_s_c.setPreferredSize(new Dimension(100,50));
		button_s_c.setText("celsius");
		button_s_f.setPreferredSize(new Dimension(100,50));
		button_s_f.setText("farenheit");
		button_s_lb.setPreferredSize(new Dimension(100,50));
		button_s_lb.setText("pound");
		button_s_kg.setPreferredSize(new Dimension(100,50));
		button_s_kg.setText("kilogram");
		
		panel.add(button_s_cm);
		panel.add(button_s_in);
		panel.add(button_s_c);
		panel.add(button_s_f);
		panel.add(button_s_lb);
		panel.add(button_s_kg);
		
		panel.add(textarea2);
		
		textarea2.setBackground(Color.LIGHT_GRAY);
		textarea2.setFont(font);
		textarea2.setForeground(Color.WHITE);
		textarea2.setText("Please select a target unit: ");
		
		button_f_cm.setPreferredSize(new Dimension(100,50));
		button_f_cm.setText("centimetre");
		button_f_in.setPreferredSize(new Dimension(100,50));
		button_f_in.setText("inch");
		button_f_c.setPreferredSize(new Dimension(100,50));
		button_f_c.setText("celsius");
		button_f_f.setPreferredSize(new Dimension(100,50));
		button_f_f.setText("farenheit");
		button_f_lb.setPreferredSize(new Dimension(100,50));
		button_f_lb.setText("pound");
		button_f_kg.setPreferredSize(new Dimension(100,50));
		button_f_kg.setText("kilogram");
		
		panel.add(button_f_cm);
		panel.add(button_f_in);
		panel.add(button_f_c);
		panel.add(button_f_f);
		panel.add(button_f_lb);
		panel.add(button_f_kg);
		
		panel.add(textarea3);
		
		textarea3.setBackground(Color.LIGHT_GRAY);
		textarea3.setFont(font);
		textarea3.setForeground(Color.LIGHT_GRAY);
		textarea3.setText("This is just here for spacing");
		
		button_undo.setPreferredSize(new Dimension(150, 50));
		button_undo.setForeground(Color.RED);
		button_undo.setText("Undo");
		button_continue.setPreferredSize(new Dimension(150, 50));
		button_continue.setForeground(Color.GREEN);
		button_continue.setText("Continue");
		button_calculate.setPreferredSize(new Dimension(150, 50));
		button_calculate.setForeground(Color.GREEN);
		button_calculate.setText("Calculate");
		
		panel.add(button_undo);
		panel.add(button_continue);
		panel.add(button_calculate);
		button_calculate.setVisible(false);
		
		// add action listener to each button 
		button_s_cm.addActionListener(this);
		button_s_in.addActionListener(this);
		button_s_c.addActionListener(this);
		button_s_f.addActionListener(this);
		button_s_lb.addActionListener(this);
		button_s_kg.addActionListener(this);
		button_f_cm.addActionListener(this);
		button_f_in.addActionListener(this);
		button_f_c.addActionListener(this);
		button_f_f.addActionListener(this);
		button_f_lb.addActionListener(this);
		button_f_kg.addActionListener(this);
		button_undo.addActionListener(this);
		button_continue.addActionListener(this);
		button_calculate.addActionListener(this);
		
	}
	
	//create a main method
	public static void main(String[] args) {
		
		a3 gooey = new a3();
		
	}

	// create method for when something is clicked 
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		//ensure which button is clicked turns blue, amd all others turn black. 
		
		if (source == button_s_cm) {
			s_cm = 1; 
			s_unit = "centimetre";
			button_s_cm.setForeground(Color.BLUE);
			s_in = 0; 
			button_s_in.setForeground(Color.BLACK);
			s_c = 0; 
			button_s_c.setForeground(Color.BLACK);
			s_f = 0;
			button_s_f.setForeground(Color.BLACK);
			s_lb = 0;
			button_s_lb.setForeground(Color.BLACK);
			s_kg = 0;
			button_s_kg.setForeground(Color.BLACK);
			f_cm = 0; 
		}
		if(source == button_s_in) {
			s_cm = 0; 
			button_s_cm.setForeground(Color.BLACK);
			s_in = 1; 
			s_unit = "inches";
			button_s_in.setForeground(Color.BLUE);
			s_c = 0; 
			button_s_c.setForeground(Color.BLACK);
			s_f = 0;
			button_s_f.setForeground(Color.BLACK);
			s_lb = 0;
			button_s_lb.setForeground(Color.BLACK);
			s_kg = 0;
			button_s_kg.setForeground(Color.BLACK);
		}
		if (source == button_s_c) {
			s_cm = 0; 
			button_s_cm.setForeground(Color.BLACK);
			s_in = 0; 
			button_s_in.setForeground(Color.BLACK);
			s_c = 1; 
			s_unit = "celsius";
			button_s_c.setForeground(Color.BLUE);
			s_f = 0;
			button_s_f.setForeground(Color.BLACK);
			s_lb = 0;
			button_s_lb.setForeground(Color.BLACK);
			s_kg = 0;
			button_s_kg.setForeground(Color.BLACK);
		}
		if (source == button_s_f) {
			s_cm = 0; 
			button_s_cm.setForeground(Color.BLACK);
			s_in = 0; 
			button_s_in.setForeground(Color.BLACK);
			s_c = 0; 
			button_s_c.setForeground(Color.BLACK);
			s_f = 1;
			s_unit = "farenheit";
			button_s_f.setForeground(Color.BLUE);
			s_lb = 0;
			button_s_lb.setForeground(Color.BLACK);
			s_kg = 0;
			button_s_kg.setForeground(Color.BLACK);
		}
		if (source == button_s_lb) {
			s_cm = 0; 
			button_s_cm.setForeground(Color.BLACK);
			s_in = 0; 
			button_s_in.setForeground(Color.BLACK);
			s_c = 0; 
			button_s_c.setForeground(Color.BLACK);
			s_f = 0;
			button_s_f.setForeground(Color.BLACK);
			s_lb = 1;
			s_unit = "pounds";
			button_s_lb.setForeground(Color.BLUE);
			s_kg = 0;
			button_s_kg.setForeground(Color.BLACK);
		}
		if (source == button_s_kg) {
			s_cm = 0; 
			button_s_cm.setForeground(Color.BLACK);
			s_in = 0; 
			button_s_in.setForeground(Color.BLACK);
			s_c = 0; 
			button_s_c.setForeground(Color.BLACK);
			s_f = 0;
			button_s_f.setForeground(Color.BLACK);
			s_lb = 0;
			button_s_lb.setForeground(Color.BLACK);
			s_kg = 1;
			s_unit = "kilograms";
			button_s_kg.setForeground(Color.BLUE);
		}
		if (source == button_f_cm) {
			f_cm = 1;
			f_unit = "centimetre";
			button_f_cm.setForeground(Color.BLUE);
			f_in = 0;
			button_f_in.setForeground(Color.BLACK);
			f_c = 0;
			button_f_c.setForeground(Color.BLACK);
			f_f = 0;
			button_f_f.setForeground(Color.BLACK);
			f_lb = 0;
			button_f_lb.setForeground(Color.BLACK);
			f_kg = 0;
			button_f_kg.setForeground(Color.BLACK);
		}
		if (source == button_f_in) {
			f_cm = 0;
			button_f_cm.setForeground(Color.BLACK);
			f_in = 1;
			f_unit = "inches";
			button_f_in.setForeground(Color.BLUE);
			f_c = 0;
			button_f_c.setForeground(Color.BLACK);
			f_f = 0;
			button_f_f.setForeground(Color.BLACK);
			f_lb = 0;
			button_f_lb.setForeground(Color.BLACK);
			f_kg = 0;
			button_f_kg.setForeground(Color.BLACK);
		}
		if (source == button_f_c) {
			f_cm = 0;
			button_f_cm.setForeground(Color.BLACK);
			f_in = 0;
			button_f_in.setForeground(Color.BLACK);
			f_c = 1;
			f_unit = "celsius";
			button_f_c.setForeground(Color.BLUE);
			f_f = 0;
			button_f_f.setForeground(Color.BLACK);
			f_lb = 0;
			button_f_lb.setForeground(Color.BLACK);
			f_kg = 0;
			button_f_kg.setForeground(Color.BLACK);
		}
		if (source == button_f_f) {
			f_cm = 0;
			button_f_cm.setForeground(Color.BLACK);
			f_in = 0;
			button_f_in.setForeground(Color.BLACK);
			f_c = 0;
			button_f_c.setForeground(Color.BLACK);
			f_f = 1;
			f_unit = "farenheit";
			button_f_f.setForeground(Color.BLUE);
			f_lb = 0;
			button_f_lb.setForeground(Color.BLACK);
			f_kg = 0;
			button_f_kg.setForeground(Color.BLACK);
		}
		if (source == button_f_lb) {
			f_cm = 0;
			button_f_cm.setForeground(Color.BLACK);
			f_in = 0;
			button_f_in.setForeground(Color.BLACK);
			f_c = 0;
			button_f_c.setForeground(Color.BLACK);
			f_f = 0;
			button_f_f.setForeground(Color.BLACK);
			f_lb = 1;
			f_unit = "pounds";
			button_f_lb.setForeground(Color.BLUE);
			f_kg = 0;
			button_f_kg.setForeground(Color.BLACK);
		}
		if (source == button_f_kg) {
			f_cm = 0;
			button_f_cm.setForeground(Color.BLACK);
			f_in = 0;
			button_f_in.setForeground(Color.BLACK);
			f_c = 0;
			button_f_c.setForeground(Color.BLACK);
			f_f = 0;
			button_f_f.setForeground(Color.BLACK);
			f_lb = 0;
			button_f_lb.setForeground(Color.BLACK);
			f_kg = 1;
			f_unit = "kilograms";
			button_f_kg.setForeground(Color.BLUE);
		}
		
		//ensure the undo button un-selects all of the buttons 
		if (source == button_undo) {
			s_cm = 0; 
			button_s_cm.setForeground(Color.BLACK);
			s_in = 0; 
			button_s_in.setForeground(Color.BLACK);
			s_c = 0; 
			button_s_c.setForeground(Color.BLACK);
			s_f = 0;
			button_s_f.setForeground(Color.BLACK);
			s_lb = 0;
			button_s_lb.setForeground(Color.BLACK);
			s_kg = 0;
			button_s_kg.setForeground(Color.BLACK);
			f_cm = 0;
			button_f_cm.setForeground(Color.BLACK);
			f_in = 0;
			button_f_in.setForeground(Color.BLACK);
			f_c = 0;
			button_f_c.setForeground(Color.BLACK);
			f_f = 0;
			button_f_f.setForeground(Color.BLACK);
			f_lb = 0;
			button_f_lb.setForeground(Color.BLACK);
			f_kg = 0;
			button_f_kg.setForeground(Color.BLACK); 
		}
		
		//check which unit combination was selected for the conversion
		if (source == button_continue) {
			boolean valid = false;
			if ("centimetre".equals(s_unit) && "inches".equals(f_unit)) {
				valid = true;
			}

			if ("inches".equals(s_unit) && "centimetre".equals(f_unit)) {
				valid = true;
			}
			
			 if ("celsius".equals(s_unit) && "farenheit".equals(f_unit)) {
				valid = true;
			}

			 if ("farenheit".equals(s_unit) && "celsius".equals(f_unit)) {
				valid = true;
			}

			 if ("pounds".equals(s_unit) && "kilograms".equals(f_unit)) {
				valid = true;
			}

			 if ("kilograms".equals(s_unit) && "pounds".equals(f_unit)) {
				valid = true;
			}
			 
			 // if combination invalid, throw an error 
			if (!valid) {
				JOptionPane.showMessageDialog(frame, "Please select a valid combination of start and target units! ");
			}
			
			//start fixing layout for the second page
			else {
				panel.remove(button_s_cm);
				panel.remove(button_s_in);
				panel.remove(button_s_c);
				panel.remove(button_s_f);
				panel.remove(button_s_lb);
				panel.remove(button_s_kg);
				panel.remove(button_f_cm);
				panel.remove(button_f_in);
				panel.remove(button_f_c);
				panel.remove(button_f_f);
				panel.remove(button_f_lb);
				panel.remove(button_f_kg);
				
				button_continue.setVisible(false);
				button_undo.setVisible(false);
				
				textarea.setText("Please select a starting value: ");
				textarea2.setBackground(Color.WHITE);
				textarea2.setForeground(Color.BLACK);
				textarea2.setText("");
	
				button_calculate.setVisible(true);
			}

		}
		
		// do calculations 
		if (source == button_calculate) {
			
			frame.add(panel);
			panel.setBackground(Color.LIGHT_GRAY);
			javax.swing.border.Border border = BorderFactory.createLineBorder(Color.RED,4);
			panel.setBorder(border);
			
			//get the starting value 
			String s_val = textarea2.getText();
			
			try {
				double s_value = Double.parseDouble(s_val);
			
			
				if ("centimetre".equals(s_unit) && "inches".equals(f_unit)) {
					output = s_value*0.393701;
				}
	
				if ("inches".equals(s_unit) && "centimetre".equals(f_unit)) {
					output = s_value/0.393701;
				}
				
				 if ("celsius".equals(s_unit) && "farenheit".equals(f_unit)) {
					output = s_value*1.8+32;
				}
	
				 if ("farenheit".equals(s_unit) && "celsius".equals(f_unit)) {
					output = (s_value-32)/1.8;
				}
	
				 if ("pounds".equals(s_unit) && "kilograms".equals(f_unit)) {
					output = s_value*0.453592;
				}
				 
				 if ("kilograms".equals(s_unit) && "pounds".equals(f_unit)) {
					output = s_value/0.453592;
				}
				
				 
				 // set up for the final page
				panel.remove(button_calculate);
				
				textarea.setText(s_val + " " + s_unit + " is the same as: ");
				textarea2.setBackground(Color.GREEN);
				textarea2.setForeground(Color.BLACK);
				textarea2.setText(String.valueOf(output));
				textarea3.setBackground(Color.LIGHT_GRAY);
				textarea3.setForeground(Color.WHITE);
				textarea3.setText(f_unit);
				
			}
			
			//catch and throw an error if input is not numeric. 
			catch (NumberFormatException error){

				JOptionPane.showMessageDialog(frame, "Please enter a valid number");
			}
			
		}

	}

}
