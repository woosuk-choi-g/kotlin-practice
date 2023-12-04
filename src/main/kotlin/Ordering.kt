import kotlin.math.sign

class Version(val major: Int, val minor: Int, val patch: Int) : Comparable<Version> {
    companion object {
        val comparator = compareBy<Version>({ it.major }, { it.minor }, { it.patch })
    }

    override fun compareTo(other: Version) = comparator.compare(this, other)

//    override fun compareTo(other: Version) = when {
//        major != other.major -> major - other.major
//        minor != other.minor -> minor - other.minor
//        else -> patch - other.patch
//    }
}

fun main() {
    val numbers = mutableListOf("one", "two", "three", "four")
    numbers.sort()
    println(numbers.binarySearch("two")) // 3
    println(numbers.binarySearch("z")) // -5
    println(numbers.binarySearch("two", 0, 2)) // -3
}