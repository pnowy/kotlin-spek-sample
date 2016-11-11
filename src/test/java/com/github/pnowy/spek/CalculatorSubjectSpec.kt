package com.github.pnowy.spek

import org.jetbrains.spek.api.SubjectSpek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.api.dsl.xon
import org.jetbrains.spek.api.memoized.CachingMode
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.todo

@RunWith(JUnitPlatform::class)
class CalculatorSubjectSpec : SubjectSpek<Calculator>({
    subject { Calculator() }
    //subject(CachingMode.GROUP, { Calculator() })

    on("calculating the sum of 2 and 2") {
        val result = subject.add(2, 2)
        it("should return 4") {
            assertEquals(4, result)
        }
    }

})

