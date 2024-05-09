package app

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter

val jsonAdapter: Moshi = Moshi.Builder().build()
@OptIn(ExperimentalStdlibApi::class)
val greetingAdapter: JsonAdapter<Greeting> = jsonAdapter.adapter<Greeting>()

class App {
    fun greetFromJson(jsonGreeting: String): String {
        val greeting = greetingAdapter.fromJson(jsonGreeting)!!
        return "${greeting.message} ${greeting.person}!"
    }
}

@JsonClass(generateAdapter = true)
data class Greeting(val message: String, val person: String)

fun main() {
    val jsonGreeting = greetingAdapter.toJson(Greeting("Hello", "Raf"))
    println(App().greetFromJson(jsonGreeting))
}
