import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() { runBlocking {
    val channel = Channel<Int>()

    launch {
        for (x in 1..20) {
            channel.send(x)
            delay(300L)
        }
        channel.close()
    }

    launch {
        for (y in channel) {
            println("receiver #1 $y")
        }
    }

    launch {
        for (y in channel) {
            println("receiver #2 $y")
        }
    }
}}

// output:
// receiver #1 1
// receiver #1 2
// receiver #2 3
// receiver #1 4
// receiver #2 5
// receiver #1 6
// receiver #2 7
// receiver #1 8
// receiver #2 9
// receiver #1 10
// receiver #2 11
// receiver #1 12
// receiver #2 13
// receiver #1 14
// receiver #2 15
// receiver #1 16
// receiver #2 17
// receiver #1 18
// receiver #2 19
// receiver #1 20