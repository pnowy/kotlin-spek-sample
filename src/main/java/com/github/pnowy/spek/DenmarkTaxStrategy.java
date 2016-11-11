package com.github.pnowy.spek;

import org.joda.money.Money;

import java.math.RoundingMode;

/**
 * Denmark tax rate strategy. It is just assumption.
 */
public class DenmarkTaxStrategy implements CountryTaxStrategy {
    public static final double GENERAL_TAX_RATE = 0.25;

    @Override
    public Money countTaxRate(TaxPayer taxPayer) {
        return taxPayer.getGrossIncome().multipliedBy(GENERAL_TAX_RATE, RoundingMode.DOWN);
    }
}
