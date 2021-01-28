package main.kotlin.warmup

import java.lang.Math.abs

val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
val sudoers: List<Int> = systemUsers

fun addSudoer(user: Int) {
    systemUsers.add(user)
}

fun getSysSudoers(): List<Int> {
    return sudoers
}

val openIssues: MutableSet<String> = mutableSetOf("Issue 1", "Issue 2", "Issue 3")

fun addIssue(uniqueIssue: String): Boolean {
    return openIssues.add(uniqueIssue)
}

fun addStatusLog(status: Boolean): String {
    return if (status) "Issue added" else "Whoops duplicate issue"
}

const val POINTS_X_PASS = 15

val EzPassAccount: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
val EzPassReport: Map<Int, Int> = EzPassAccount

fun updatePass(id: Int) {
    if (EzPassAccount.containsKey(id)) {
        println("Updating $id...")
        EzPassAccount[id] = EzPassAccount.getValue(id) + POINTS_X_PASS
    } else {
        println("Error. Account doesn't exist")
    }
}

fun accountReport() {
    println("EzPass Report:")
    EzPassReport.forEach { (k, v) -> println("Id: $k Points:$v") }
}

fun main() {
    //lists
//    addSudoer(4)
//    println("Sudoers size: ${getSysSudoers().size}")
//    getSysSudoers().forEach { i-> println("Info about user:$i")}
    // sets
//    val aNewIssue = "Issue 4"
//    val duplicateIssue = "Issue 3"
//    println("Issue $aNewIssue: ${addStatusLog(addIssue(aNewIssue))}")
//    println("Issue $duplicateIssue: ${addStatusLog(addIssue(duplicateIssue))}")
    // maps
//    accountReport()
//    updatePass(1)
//    updatePass(1)
//    updatePass(5)
//    accountReport()
    // filter
    val numbers = listOf<Int>(1, -2, 3, -4, 5, -6)
//    val positives = numbers.filter { x -> x > 0 }
//    val negatives = numbers.filter { x -> x < 0 }
//    println(positives)
//    println(negatives)
//    println(numbers)
    // map
//    numbers.map { x -> x * 2 }.forEach { println(it) }
    numbers.map { it * 3 }

    data class Person(val name: String, val city: String, val phone: String)

    val people = listOf(
        Person("John", "Boston", "+1-888-123456"),
        Person("Sarah", "Munich", "+49-777-789123"),
        Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        Person("Vasilisa", "Saint-Petersburg", "+7-999-123456")
    )
    val phoneBook = people.associateBy { it.phone }
    val cityBook = people.associateBy(Person::phone, Person::city)
    val peopleCities = people.groupBy(Person::city, Person::name)

    println(phoneBook)
    println(cityBook)
    println(peopleCities)

    val evenNumbers = numbers.partition { it % 2 == 0 }
    val (positive, negative) = numbers.partition { it > 0 }
    println(evenNumbers)
    println(positive)
    println(negative)


    val shuffled = listOf(5, 4, 2, 1, 3, -10)
    val natural = shuffled.sorted()
    val inverted = shuffled.sortedBy { -it }
    val descending = shuffled.sortedDescending()
    val descendingBy = shuffled.sortedByDescending { abs(it) }
    println(natural)
    println(inverted)
    println(descending)
    println(descendingBy)

    val A = listOf("a", "b", "c")
    val B = listOf(1, 2, 3, 4)

    val merged = A zip B
    val mergedBy = A.zip(B) { a, b -> "$a$b" }
    println(merged)
    println(mergedBy)
}