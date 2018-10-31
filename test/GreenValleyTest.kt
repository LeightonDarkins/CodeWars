import org.junit.Assert.*
import java.util.Arrays
import org.junit.Test

fun makeValley(array: IntArray): IntArray {
    var copyOfArray = array
    var descendingList = ArrayList<Int>()
    var ascendingList = ArrayList<Int>()

    copyOfArray.sortDescending()

    for ((index, number) in copyOfArray.withIndex()) {
        if (isEven(index)) {
            descendingList.add(number)
        } else {
            ascendingList.add(number)
        }
    }

    ascendingList.reverse()
    descendingList.addAll(ascendingList)

    return descendingList.toIntArray()
}

// A better example using more Kotlin-y syntax

fun makeValleyKotlin(array: IntArray): IntArray {
    var copyOfArray = array
    var descendingList = mutableListOf<Int>()
    var ascendingList = mutableListOf<Int>()

    copyOfArray.sortDescending()

    for ((index, number) in copyOfArray.withIndex()) {
        when(isEven(index)) {
            true -> descendingList.add(number)
            else -> ascendingList.add(number)
        }
    }

    ascendingList.reverse()
    descendingList.addAll(ascendingList)

    return descendingList.toIntArray()
}

fun isEven(number :Int): Boolean {
    return (number % 2) == 0
}

internal class GreenValleyTest {

    private fun testing(actual:String, expected:String) {
        assertEquals(expected, actual)
    }

    @Test
    fun oddArray() {
        var inputArray = intArrayOf(17, 17, 15, 14, 8, 7, 7, 5, 4, 4, 1)
        var expectedArray = intArrayOf(17, 15, 8, 7, 4, 1, 4, 5, 7, 14, 17)

        var result = makeValley(inputArray)

        testing(Arrays.toString(result), Arrays.toString(expectedArray))
    }

    @Test
    fun evenArray() {
        val inputArray = intArrayOf(20, 7, 6, 2)
        val expectedArray = intArrayOf(20, 6, 2, 7)

        var result = makeValley(inputArray)

        testing(Arrays.toString(result), Arrays.toString(expectedArray))
    }
}
