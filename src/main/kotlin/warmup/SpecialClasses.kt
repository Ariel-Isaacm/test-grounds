package main.kotlin.warmup

data class User(val name: String, val id: Int)

fun main() {
    val user = User("Ariel", 1)
    println(user)

    val secondUser = User("Ariel", 1)
    val thirdUser = User("Jonathan", 3)
    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    println(user.hashCode())
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    println(user.component1())

    val state = State.RUNNING
    val result = when (state) {
        State.FINISHED -> "Finished"
        State.IDLE -> "Idle"
        State.RUNNING -> "Running"
    }
    println(result)

    val red = Color.RED
    println(red)
    println(red.containsRed())
    println(Color.BLUE.containsRed())

    rentPrice(10, 2, 1)
    BigBen.getBongs(12)
}

class BigBen() {
    companion object Bongers {
        fun getBongs(nTimes: Int) {
            for (i in 1..nTimes) {
                print("BONG ")
            }
        }
    }
}

fun rentPrice(regularDays: Int, specialDays: Int, festivityDays: Int): Unit {
    val obj = object {
        var regular: Int = regularDays * 30
        var special: Int = specialDays * 50
        var festivity: Int = festivityDays * 100
    }
    val total = obj.regular + obj.special + obj.festivity

    println("Total price: $$total")
}

enum class State {
    RUNNING,
    FINISHED,
    IDLE
}

enum class Color(private val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}