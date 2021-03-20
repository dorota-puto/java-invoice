package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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