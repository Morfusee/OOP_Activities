package com.homework.four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import classes.PhoneSales;
import classes.RepairService;
import classes.SaleItem;

public class HomeWork4 {

	public static void main(String[] args) {
		// Create the main frame
		JFrame frame = new JFrame("Sales Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 600);
		frame.setLayout(new GridLayout(8, 2));

		// Components for phone sales
		JLabel phoneLabel = new JLabel("Phone Price:");
		JTextField phonePriceField = new JTextField("500.0");
		JLabel phoneQtyLabel = new JLabel("Quantity Sold:");
		JTextField phoneQtyField = new JTextField("10");

		// Components for repair services
		JLabel repairLabel = new JLabel("Repair Price per Hour:");
		JTextField repairPriceField = new JTextField("50.0");
		JLabel repairHoursLabel = new JLabel("Number of Hours:");
		JTextField repairHoursField = new JTextField("5");

		// Button and result area
		JButton calculateButton = new JButton("Calculate");
		JTextArea resultArea = new JTextArea();
		resultArea.setEditable(false);

		// Add components to frame
		frame.add(phoneLabel);
		frame.add(phonePriceField);
		frame.add(phoneQtyLabel);
		frame.add(phoneQtyField);
		frame.add(repairLabel);
		frame.add(repairPriceField);
		frame.add(repairHoursLabel);
		frame.add(repairHoursField);
		frame.add(new JLabel()); // Empty cell for spacing
		frame.add(calculateButton);
		frame.add(new JLabel("Results:"));
		frame.add(resultArea);

		// Action listener for calculate button
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Get phone sales details
					double phonePrice = Double.parseDouble(phonePriceField.getText());
					int phoneQty = Integer.parseInt(phoneQtyField.getText());
					SaleItem phoneSales = new PhoneSales(phonePrice, phoneQty);

					// Get repair service details
					double repairPrice = Double.parseDouble(repairPriceField.getText());
					int repairHours = Integer.parseInt(repairHoursField.getText());
					SaleItem repairService = new RepairService(repairPrice, repairHours);

					// Display results
					resultArea.setText(String.format("Total Sales:\n" + "Phones: ₱%.2f\n" + "Repairs: ₱%.2f\n",
							phoneSales.calculateTotal(), repairService.calculateTotal()));
				} catch (NumberFormatException ex) {
					resultArea.setText("Error: Please enter valid numbers.");
				}
			}
		});

		// Show the frame
		frame.setVisible(true);
	}

}
