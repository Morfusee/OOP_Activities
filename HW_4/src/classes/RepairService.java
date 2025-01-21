package classes;

import javax.swing.JOptionPane;

public class RepairService extends SaleItem {
	private double pricePerHour;
	private int hours;
	
	public RepairService(double pricePerHour, int hours) {
		this.pricePerHour = pricePerHour;
		this.hours = hours;
	}
	
	@Override
	public double calculateTotal() {
		if (pricePerHour < 0 || hours < 0) {
			JOptionPane.showMessageDialog(null, "Input cannot be negative.");
		}
		return pricePerHour * hours;
	}
}
