import java.io.File
import javax.swing.UIManager.put

sealed interface Error

sealed class IOError: Error

class FileReadError(val file: File): IOError()
class DatabaseError(val source: String): IOError()

data object RuntimeError: Error

fun getError(): Error = TODO()

fun main() {
    when (val error: Error = getError()) {
        is FileReadError -> println("File read error: ${error.file}")
        is DatabaseError -> println("Database error: ${error.source}")
        is RuntimeError -> println("Runtime error")
    }

    buildList { add(3) }
}