fun main() {
    println(Float.NaN > Float.POSITIVE_INFINITY)
    println(Float.NaN > Float.NEGATIVE_INFINITY)

    println(Float.NaN < Float.POSITIVE_INFINITY)
    println(Float.NaN < Float.NEGATIVE_INFINITY)

    println(Float.NaN == Float.NaN)
    println(Float.NaN != Float.NaN)

    println(0.0 > -0.0)
    println(0.0 < -0.0)
}