package app

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AppTest : StringSpec({
    val jsonAdapter: Moshi = Moshi.Builder().build()

    "App greets" {
        @OptIn(ExperimentalStdlibApi::class)
        val greetingAdapter: JsonAdapter<Greeting> = jsonAdapter.adapter<Greeting>()
        val jsonGreeting = greetingAdapter.toJson(Greeting("Hi", "Gus"))

        App().greetFromJson(jsonGreeting) shouldBe "Hi Gus!"
    }
})
