import org.junit.Test
import java.lang.Math.pow
import kotlin.math.ceil
import kotlin.test.assertEquals

fun movie(priceOfCard:Int, priceOfTicket:Int, percentage:Double): Int {
    var numberOfTimes = 0
    var systemASum = 0
    var systemBSum = 0.0

    while (ceil(priceOfCard + systemBSum) >= systemASum) {
        numberOfTimes++
        systemASum += priceOfTicket

        val newPercentage = pow(percentage, numberOfTimes.toDouble())

        systemBSum += priceOfTicket * newPercentage
    }

    return numberOfTimes
}

internal class GoingToTheCinemaTest {
    @Test
    fun movie_500_15_90_returns43() {
        val result = movie(500, 15, .9)

        assertEquals(43, result)
    }

    @Test
    fun movie_100_10_95_returns24() {
        val result = movie(100, 10, .95)

        assertEquals(24, result)
    }
}
