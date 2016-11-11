package com.github.pnowy.spek


import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.joda.money.CurrencyUnit
import org.joda.money.Money
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.todo

fun ofPln(amount: Double): Money = Money.of(CurrencyUnit.of("PLN"), amount)
fun ofDkk(amount: Double): Money = Money.of(CurrencyUnit.of("DKK"), amount)

@RunWith(JUnitPlatform::class)
class TaxRateCalculatorSpec : Spek({

    describe("calculating tax") {
        val calculator = TaxRateCalculator(PolandTaxStrategy())

        context("for poland") {
            calculator.taxStrategy = PolandTaxStrategy()

            with("linear tax payer and 10 000 PLN gross income") {
                val taxPayer = TaxPayer(TaxType.LINEAR, ofPln(10000.00))
                val calculatedTax = calculator.calculateTax(taxPayer)

                should("return 1900 as tax rate") {
                    assertThat(calculatedTax.tax).isEqualTo(ofPln(1900.00))
                }
                should("should return 8100 as net income") {
                    assertThat(calculatedTax.netIncome).isEqualTo(ofPln(8100.00))
                }
            }

            with("progressive tax payer and 10 000 PLN gross income") {
                val taxPayer = TaxPayer(TaxType.PROGRESSIVE, ofPln(10000.00))
                val calculatedTax = calculator.calculateTax(taxPayer)

                should("return 1243.98 as tax rate") {
                    assertThat(calculatedTax.tax).isEqualTo(ofPln(1243.98))
                }
            }

            xwith("progressive tax payer and high gross income") {
                todo({ "implement" })
            }
        }

        context("for denmark") {
            calculator.taxStrategy = DenmarkTaxStrategy()

            with("linear tax payer and 10 000 DKK gross income") {
                val taxPayer = TaxPayer(TaxType.LINEAR, ofDkk(10000.00))
                val calculatedTax = calculator.calculateTax(taxPayer)

                should("should return 2500 DKK as tax rate") {
                    assertThat(calculatedTax.tax).isEqualTo(ofDkk(2500.00))
                }
            }

            with("linear and progressive tax payer and the same gross income") {
                val grossIncome = ofDkk(12345.67)
                val payerFirst = TaxPayer(TaxType.LINEAR, grossIncome)
                val secondPayer = TaxPayer(TaxType.PROGRESSIVE, grossIncome)
                val taxForFirstPayer = calculator.calculateTax(payerFirst)
                val taxForSecondPayer = calculator.calculateTax(secondPayer)

                should("have the same tax rate") {
                    assertThat(taxForFirstPayer.tax).isEqualTo(taxForSecondPayer.tax)
                }
            }
        }
    }
})