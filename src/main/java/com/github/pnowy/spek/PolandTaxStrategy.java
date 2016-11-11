package com.github.pnowy.spek;

import org.jetbrains.annotations.NotNull;
import org.joda.money.Money;

import java.math.RoundingMode;

import static com.google.common.base.Preconditions.checkState;

/**
 * <p>Tax rate counting strategy for Poland laws.</p>
 *
 * <p>Please take into account this is not so easy in real life, especially in Poland :)</p>
 */
public class PolandTaxStrategy implements CountryTaxStrategy {
    private static final double LINEAR_TAX_RATE = 0.19;
    private static final double FIRST_THRESHOLD_TAX_RATE = 0.18;
    private static final double SECOND_THRESHOLD_TAX_RATE = 0.32;

    private static final double THRESHOLD_TIPPING_POINT = 85528.00;

    @Override
    public Money countTaxRate(TaxPayer taxPayer) {
        // normally the implementation would be divided for specific interfaces
        // and executed by specific chain of responsibility or somethign like that
        // but this is only the demo
        Money grossIncome = taxPayer.getGrossIncome();
        if (isLinearTax(taxPayer)) {
            return countLinearTax(grossIncome);
        }

        checkState(TaxType.PROGRESSIVE.equals(taxPayer.getTaxType()), "Should be progressive type only here!");
        if (isFirstThresholdTax(grossIncome)) {
            return countFirstThresholdTax(grossIncome);
        }

        return countSecondThresholdTax(grossIncome);
    }

    private boolean isFirstThresholdTax(Money grossIncome) {
        return grossIncome.isLessThan(Money.of(grossIncome.getCurrencyUnit(), THRESHOLD_TIPPING_POINT));
    }

    private boolean isLinearTax(TaxPayer taxPayer) {
        return TaxType.LINEAR.equals(taxPayer.getTaxType());
    }

    @NotNull
    private Money countLinearTax(@NotNull Money grossIncome) {
        return grossIncome.multipliedBy(LINEAR_TAX_RATE, RoundingMode.DOWN);
    }

    @NotNull
    private Money countFirstThresholdTax(Money grossIncome) {
        return grossIncome.multipliedBy(FIRST_THRESHOLD_TAX_RATE, RoundingMode.DOWN).minus(556.02);
    }

    private Money countSecondThresholdTax(Money grossIncome) {
        Money excess = grossIncome.minus(THRESHOLD_TIPPING_POINT);
        Money taxForFirstThreshold = Money.of(grossIncome.getCurrencyUnit(), 14839.02);
        return taxForFirstThreshold.plus(excess.multipliedBy(SECOND_THRESHOLD_TAX_RATE, RoundingMode.UNNECESSARY));
    }

}
