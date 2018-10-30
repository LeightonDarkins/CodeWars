import junit.framework.Assert.assertEquals
import org.junit.Test
import kotlin.math.absoluteValue

const val e = 1

fun absoluteDifferenceOfLastTwoElements(guesses: ArrayList<Long>): Long {
    val last = guesses.last()
    val secondLast = guesses.elementAt(guesses.size - 2)

    return (last - secondLast).absoluteValue
}

fun intRac(n:Long, guess:Long): Long {
    var guesses = arrayListOf(guess)

    while (guesses.size == 1 || absoluteDifferenceOfLastTwoElements(guesses) > e) {
        guesses.add((guesses.last() + n / guesses.last()) / 2)
    }

    return guesses.size.toLong() - 1
}

internal class HerosRootTest {
    @Test
    fun returns4For25And1() {
        assertEquals(4, intRac(25,1))
    }

    @Test
    fun returns3For125348And300() {
        assertEquals(3, intRac(125348, 300))
    }

    @Test
    fun returnsDunnoFor36And3() {
        assertEquals(2, intRac(36, 3))
    }

    @Test
    fun returns1ForAbsoluteDifferenceOf1And2() {
        val array = arrayListOf<Long>(2,1)
        assertEquals(1, absoluteDifferenceOfLastTwoElements(array))
    }

    @Test
    fun returns5ForAbsoluteDifferenceOf5And10() {
        val array = arrayListOf<Long>(5,10)
        assertEquals(5, absoluteDifferenceOfLastTwoElements(array))
    }
}
