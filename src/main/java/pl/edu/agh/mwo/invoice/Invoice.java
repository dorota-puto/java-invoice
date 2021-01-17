package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {

	private Map<Product, Integer> products = new LinkedHashMap<Product, Integer>();

	public void addProduct(Product product) {
		addProduct(product, 1);
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be more than 0");
		}
		products.put(product, quantity);
	}

	public BigDecimal getNetPrice() {
		
		return this.products.keySet().stream()
		.map(p -> p.getPrice().multiply(new BigDecimal(products.get(p))))
		.reduce(BigDecimal.ZERO, BigDecimal::add);
		
//		BigDecimal sum = BigDecimal.ZERO;
//		for (Product p : this.products.keySet()) {
//			sum = sum.add(p.getPrice().multiply(new BigDecimal(products.get(p))));
//		}
//		return sum;
	}

	public BigDecimal getTax() {
		return this.getGroosPrice().subtract(this.getNetPrice());
	}

	public BigDecimal getGroosPrice() {
		return this.products.keySet().stream()
				.map(p -> p.getPriceWithTax().multiply(new BigDecimal(products.get(p))))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
//		BigDecimal sum = BigDecimal.ZERO;
//		for (Product p : this.products.keySet()) {
//			sum = sum.add(p.getPriceWithTax().multiply(new BigDecimal(products.get(p))));
//		}
//		return sum;
	}
}
