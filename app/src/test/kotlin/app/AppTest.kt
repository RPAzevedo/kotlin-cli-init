package app

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AppTest : StringSpec({
    "App greets" {
        App().greeting shouldBe "Hello World!"
    }
})
