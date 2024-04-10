package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine(); // Consume a quebra de linha deixada pelo nextInt()
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee);
				list.add(product);
			} else if (ch == 'u') {
				System.out.print("Date (dd/mm/yyyy): ");
				String dateInput = sc.next();
				Date date = dateFormat.parse(dateInput);
				Product product = new UsedProduct(name, price, date);
				list.add(product);
			} else {
				Product product = new Product(name, price);
				list.add(product);
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}
}