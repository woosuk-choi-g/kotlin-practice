import kotlinx.coroutines.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main() = runBlocking {
    repeat(50_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".")
        }
    }
}

//fun main() {
//    repeat(50_000) { // launch a lot of coroutines
//        thread {
//            sleep(5000L)
//            print(".")
//        }
//    }
//}