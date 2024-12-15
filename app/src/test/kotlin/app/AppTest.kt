package app

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AppTest : StringSpec({

    "App greets" {
        val jsonGreeting = Json.encodeToString(Greeting("Hi", "Gus"))

        App().greetFromJson(jsonGreeting) shouldBe "Hi Gus!"
    }
})
