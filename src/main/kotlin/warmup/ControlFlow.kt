package main.kotlin.warmup


fun main() {
    cases(Customer())
    cases(MyClass())
    cases("Holi")

    println(caseAssign(MyClass()))
    println(caseAssign("Holi"))

    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) {
        println("Let's eat a $cake")
    }

    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {
        eatCake()
        cakesEaten++
    }

    while (cakesBaked < cakesEaten){
        bakeCake()
        cakesBaked++
    }

}

fun eatCake() {
    println("Cake eaten")
}

fun bakeCake() {
    println("Bake a cake")
}

fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }
}

fun caseAssign(obj: Any): Any {
    val result = when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }
    return result
}

class MyClass
