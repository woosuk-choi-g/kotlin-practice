import kotlin.reflect.KClass

// Annotations are means of attaching metadata to code. To declare an annotation, put the annotation modifier in front of a class:
@Target(AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION,)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy


// Annotations can have constructors that take parameters.
annotation class Special(val why: String)

@Special("example") class Foo


// If an annotation is used as a parameter of another annotation, its name is not prefixed with the @ character:
annotation class ReplaceWith(val expression: String)

annotation class Deprecated(
    val message: String,
    val replaceWith: ReplaceWith = ReplaceWith("")
)


// If you need to specify a class as an argument of an annotation, use a Kotlin class (KClass). The Kotlin compiler will automatically convert it to a Java class, so that the Java code can access the annotations and arguments normally.
@Deprecated("This function is deprecate, use === instead", ReplaceWith("this === other"))
fun foo() {}


annotation class Ann(val arg1: KClass<*>, val arg2: KClass<out Any>)

@Ann(String::class, Int::class) class MyClass


// Annotations can also be used on lambdas. They will be applied to the invoke() method into which the body of the lambda is generated. This is useful for frameworks like Quasar, which uses annotations for concurrency control.
annotation class Suspendable
//val f = @Suspendable { Fiber.sleep(10) }


// Annotation use-site targets
//class Example(@field:Ann val foo,
//              @get:Ann val bar,
//              @param:Ann val quux)