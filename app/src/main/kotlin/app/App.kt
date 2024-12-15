package app

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class App {
    fun greetFromJson(jsonGreeting: String): String {
        val greeting = Json.decodeFromString<Greeting>(jsonGreeting)!!
        return "${greeting.message} ${greeting.person}!"
    }
}

@Serializable
data class Greeting(val message: String, val person: String)

fun main() {
    val jsonGreeting = Json.encodeToString(Greeting("Hello", "Raf"))
    println(App().greetFromJson(jsonGreeting))
}
