import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

const val DEFAULT_HOUR = 13

fun getCalendar(hour: Int = DEFAULT_HOUR): Calendar {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, hour)

    return calendar
}

class Greeter(private val date: Calendar = getCalendar()) {
    fun greet(name: String): String {

        val hourOfDay = date.get(Calendar.HOUR_OF_DAY)
        val nameToReturn = name.trim().capitalize()

        return if (hourOfDay in 6..12) {
             "Good morning $nameToReturn!"
        } else if (hourOfDay in 18..22) {
            "Good evening $nameToReturn!"
        } else if (hourOfDay >= 23 || hourOfDay < 6) {
            "Good night $nameToReturn!"
        } else {
            "Hello $nameToReturn!"
        }
    }

    companion object {
        fun atHour(hour: Int): Greeter {
            if (hour > 23 || hour < 0) return Greeter(getCalendar())

            return Greeter(getCalendar(hour))
        }
    }
}

internal class GreeterTest {
    @Test
    fun greet() {
        assertEquals("Hello Jimmy!", Greeter().greet("jimmy"))
    }

    @Test
    fun greetRemovesLeadingAndTrailingSpaces() {
        assertEquals("Hello Jimmy!", Greeter().greet("   jimmy   "))
    }

    @Test
    fun greetCapitalizesFirstLetterOfTheName() {
        assertEquals("Hello Jimmy!", Greeter().greet("jimmy"))
    }

    @Test
    fun greetInTheMorning_6() {
        assertEquals("Good morning Jimmy!", Greeter.atHour(6).greet("jimmy"))
    }

    @Test
    fun greetInTheMorning_12() {
        assertEquals("Good morning Jimmy!", Greeter.atHour(12).greet("jimmy"))
    }

    @Test
    fun greetInTheEvening_18() {
        assertEquals("Good evening Jimmy!", Greeter.atHour(18).greet("jimmy"))
    }

    @Test
    fun greetInTheEvening_22() {
        assertEquals("Good evening Jimmy!", Greeter.atHour(22).greet("jimmy"))
    }

    @Test
    fun greetAtNight_23() {
        assertEquals("Good night Jimmy!", Greeter.atHour(23).greet("jimmy"))
    }

    @Test
    fun greetAtNight_5() {
        assertEquals("Good night Jimmy!", Greeter.atHour(5).greet("jimmy"))
    }

    @Test
    fun greetAtNight_0() {
        assertEquals("Good night Jimmy!", Greeter.atHour(0).greet("jimmy"))
    }

    @Test
    fun greetAtInvalidTime_25() {
        assertEquals("Hello Jimmy!", Greeter.atHour(24).greet("jimmy"))
    }

    @Test
    fun greetAtInvalifTime_negative1() {
        assertEquals("Hello Jimmy!", Greeter.atHour(-1).greet("jimmy"))
    }
}
