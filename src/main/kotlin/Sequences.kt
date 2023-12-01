import kotlin.random.Random

fun main() {
    val list = listOf(1, 2, 3, 4, 5)

    list.asIterable().onEach { print("$it ") }.filter { it % 2 == 0 }.forEach { print("$it ") }
    // output: 1 2 3 4 5 2 4
    println("\n------")
    list.asSequence().onEach { print("$it ") }.filter { it % 2 == 0 }.forEach { print("$it ") }
    // output: 1 2 2 3 4 4 5

    println("\n------")

//    generateSequence(0) { it + 1 }.shuffled().take(5).forEach { print("$it ") } // infinite because shuffled is terminal
    generateSequence { Random.nextInt() }.distinct().take(5).forEach { print("$it ") }
}