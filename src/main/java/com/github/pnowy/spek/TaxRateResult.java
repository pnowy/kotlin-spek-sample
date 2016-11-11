package com.github.pnowy.spek;

import com.google.common.base.MoreObjects;
import org.joda.money.Money;

/**
 * Result with tax rate and net income.
 */
public class TaxRateResult {
    private final TaxPayer taxPayer;
    private final Money tax;
    private final Money netIncome;

    public TaxRateResult(TaxPayer taxPayer, Money tax) {
        this.taxPayer = taxPayer;
        this.tax = tax;
        this.netIncome = taxPayer.getGrossIncome().minus(tax);
    }

    public TaxPayer getTaxPayer() {
        return taxPayer;
    }

    public Money getTax() {
        return tax;
    }

    public Money getNetIncome() {
        return netIncome;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("taxPayer", taxPayer)
                .add("tax", tax)
                .add("netIncome", netIncome)
                .toString();
    }
}
