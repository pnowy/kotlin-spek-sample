package com.github.pnowy.spek;

import org.joda.money.Money;

public class TaxRateCalculator {

    private CountryTaxStrategy taxStrategy;

    public TaxRateCalculator(CountryTaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public CountryTaxStrategy getTaxStrategy() {
        return taxStrategy;
    }

    public void setTaxStrategy(CountryTaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    TaxRateResult calculateTax(TaxPayer taxPayer) {
        Money taxRate = getTaxStrategy().countTaxRate(taxPayer);
        return new TaxRateResult(taxPayer, taxRate);
    }

}
