package com.github.pnowy.spek

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.todo

@RunWith(JUnitPlatform::class)
class CalculatorSpec : Spek({

    beforeEach {
        println("before test ...")
    }

    given("simple calculator") {
        val calculator = Calculator()

        on("calculating the sum of 2 and 2") {
            val result = calculator.add(2, 2)
            it("should return 4") {
                assertEquals(4, result)
            }
        }

        xon("calculating the multiplication of 2 and 2") {
            todo({ "implement multiplication" })
        }
    }

    given("simple calculator (given-when-then-approach)") {
        val calculator = Calculator()

        `when`("calculating the sum of 2 and 2") {
            val result = calculator.add(2, 2)
            then("should return 4") {
                assertEquals(4, result)
            }
        }
    }

})

