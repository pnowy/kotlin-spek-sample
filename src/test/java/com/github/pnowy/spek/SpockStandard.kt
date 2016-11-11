package com.github.pnowy.spek

import org.jetbrains.spek.api.dsl.Dsl
import org.jetbrains.spek.api.dsl.Pending

/**
 * Extension examples
 */

fun Dsl.`when`(description: String, body: Dsl.() -> Unit) {
    group("when $description", body = body)
}

fun Dsl.with(description: String, body: Dsl.() -> Unit) {
    group("with $description", body = body)
}

fun Dsl.xwith(description: String, reason: String? = null, body: Dsl.() -> Unit) {
    group("with $description", Pending.Yes(reason), body)
}

fun Dsl.then(description: String, body: () -> Unit) {
    test("then $description", body = body)
}

fun Dsl.should(description: String, body: () -> Unit) {
    test("should $description", body = body)
}

fun Dsl.xshould(description: String, reason: String? = null, body: () -> Unit = {}) {
    test("should $description", Pending.Yes(reason), body)
}