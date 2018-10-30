
import org.junit.Test
import kotlin.test.assertEquals

fun moveZeros(arrayOfItems: ArrayList<Int>): ArrayList<Int> {
    val zeroArray = ArrayList<Int>()
    val numberArray = ArrayList<Int>()

    for (item in arrayOfItems) {
        if (item == 0) {
            zeroArray.add(item)
        } else {
            numberArray.add(item)
        }
    }

    numberArray.addAll(zeroArray)

    return numberArray
}

internal class ZerosToTheEndTest {
    @Test
    fun movesOneZeroToTheEnd() {
        val testArrayList = ArrayList<Int>()
        testArrayList.addAll(listOf(0, 1))

        val expectedArrayList = ArrayList<Int>()
        expectedArrayList.addAll(listOf(1, 0))

        val result = moveZeros(testArrayList)

        assertEquals(expectedArrayList, result)
    }

    @Test
    fun movesTwoZerosToTheEnd() {
        val testArrayList = ArrayList<Int>()
        testArrayList.addAll(listOf(0, 1, 0, 2))

        val expectedArrayList = ArrayList<Int>()
        expectedArrayList.addAll(listOf(1, 2, 0, 0))

        val result = moveZeros(testArrayList)

        assertEquals(expectedArrayList, result)
    }

    @Test
    fun moveHeapsOfZerosToTheEnd() {
        val testArrayList = ArrayList<Int>()
        testArrayList.addAll(listOf(0, 1, 0, 2, 1, 0, 0, 10, 22))

        val expectedArrayList = ArrayList<Int>()
        expectedArrayList.addAll(listOf(1, 2, 1, 10, 22, 0, 0, 0, 0))

        val result = moveZeros(testArrayList)

        assertEquals(expectedArrayList, result)
    }
}
