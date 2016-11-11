package com.github.pnowy.spek;

import com.google.common.base.MoreObjects;
import org.joda.money.Money;

import static java.util.Objects.requireNonNull;

/**
 * Details about tax payer.
 */
public class TaxPayer {
    private final TaxType taxType;
    private final Money grossIncome;

    public TaxPayer(TaxType taxType, Money grossIncome) {
        this.taxType = requireNonNull(taxType);
        this.grossIncome = requireNonNull(grossIncome);
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public Money getGrossIncome() {
        return grossIncome;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("taxType", taxType)
                .add("grossIncome", grossIncome)
                .toString();
    }
}
