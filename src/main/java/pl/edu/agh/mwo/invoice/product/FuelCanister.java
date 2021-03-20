package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuelCanister extends Product {
	private final BigDecimal excise;
	private final LocalDate transactionDate;

	protected FuelCanister(String name, BigDecimal price, LocalDate transactionDate) {
		super(name, price, new BigDecimal("0.22"));
		this.excise = new BigDecimal("5.56");
		this.transactionDate = transactionDate;
	}

	@Override
	public BigDecimal getPriceWithTax() {
		BigDecimal price = super.getPrice();
		if (transactionDate.isEqual(LocalDate.of(2021, 4, 26))) {
			return price;
		} else {
			return price.multiply(super.getTaxPercent()).add(super.getPrice()).add(excise);
		}
	}
}