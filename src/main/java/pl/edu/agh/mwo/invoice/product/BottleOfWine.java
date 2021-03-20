package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class BottleOfWine extends Product {

    private final BigDecimal excise;

    public BottleOfWine(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.23"));
        this.excise = new BigDecimal("5.56");
    }

    @Override
    public BigDecimal getPriceWithTax() {
        return super.getPrice().multiply(super.getTaxPercent()).add(super.getPrice()).add(excise);
    }
}