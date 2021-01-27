package main.kotlin.warmup

fun main() {
    val empty = "test".let {
        customPrint(it)
        it.isEmpty()
    }
    println(" is empty: $empty")

    fun printNotNull(str: String?) {
        println("Printing \"$str\":")
        str?.let {
            print("\t")
            customPrint(it)
            println()
        }
    }

    printNotNull(null)
    printNotNull("my string")

    fun getNullableLength(str: String?) {
        println("for \"$str\":")
        str?.run {
            println("is empty " + isEmpty())
            println("length: $length")
            length
        }
    }
    getNullableLength(null)
    getNullableLength("")
    getNullableLength("my string")

    val configuration = Configuration(host = "127.0.0.1", port = 9000)
    with(configuration) {
        println("$host $port")
    }

    val jake = Person1()
    val description = jake.apply {
        name = "Jake"
        age = 19
        about = "He's a pretty cool dude"
    }.toString()
    println(jake)
    println(description)//  same output than #45, apply  mutates the object

    fun writeCreationLog(p: Person1) {
        println("A new person ${p.name} was created.")
    }

    jake.also { writeCreationLog(it) }

}

data class Person1(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

class Configuration(var host: String, var port: Int)

fun customPrint(str: String) {
    print(str.toUpperCase())
}