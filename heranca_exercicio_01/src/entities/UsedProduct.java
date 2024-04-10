package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	Date manufactureDate;

	@Override
	public String priceTag() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String formattedDate = dateFormat.format(manufactureDate);
	    return name + " (used) $ "+ String.format("%.2f", price) + String.format(" (Manufacture date: %s)", formattedDate);
	}

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	
}
