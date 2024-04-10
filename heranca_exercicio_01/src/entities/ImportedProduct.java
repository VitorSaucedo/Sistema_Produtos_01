package entities;

public class ImportedProduct extends Product {

	double customsFee;

	@Override
	public String priceTag() {
		return name + " $ " + String.format("%.2f", totalPrice()) + String.format(" (Customs fee: %.2f)", customsFee);
	}

	double totalPrice() {
		return super.price + customsFee;
	}

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}

	
}
