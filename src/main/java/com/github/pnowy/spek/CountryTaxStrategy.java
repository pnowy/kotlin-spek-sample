package com.github.pnowy.spek;

import org.joda.money.Money;

public interface CountryTaxStrategy {
    Money countTaxRate(TaxPayer taxPayer);
}
