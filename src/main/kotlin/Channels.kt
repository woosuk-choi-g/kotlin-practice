import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

suspend fun delayWithLog(time: Long) {
    println("delaying $time")
    delay(time)
    println("delayed $time")
}

fun main() = runBlocking {

    val channel = Channel<Int>()
    launch {
        // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
        for (x in 1..5) {
            println("preparing send ${x * x}")
            channel.send(x * x)
            println("sent ${x * x}")
            delayWithLog(1000L)
        }
    }
    // here we print five received integers:
    repeat(5) {
        println("preparing receive")
        println("received ${channel.receive()}")
    }
    println("Done!")

}