package main.kotlin.warmup

fun main() {
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(str: String) = Pair(this, str)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)
    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
    sophia.likedPeople.forEach { println(it.name) }

    operator fun String.get(range: IntRange) = substring(range)  // 3
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
    }
}