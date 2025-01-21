package classes;

import javax.swing.JOptionPane;

public class PhoneSales extends SaleItem {
	private double price;
	private int quantity;

	public PhoneSales(double price, int quantity) {
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public double calculateTotal() {
		if (price < 0 || quantity < 0) {
			JOptionPane.showMessageDialog(null, "Input cannot be negative.");
		}
		return price * quantity;
	}
}
