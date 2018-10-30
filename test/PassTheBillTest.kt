
import org.junit.Test
import kotlin.test.assertEquals

fun passTheBill(totalMembers: Int, conservatives: Int, reformists: Int): Int {
    val independents = totalMembers - conservatives - reformists
    val majority = totalMembers / 2 + 1
    val votesNeeded = majority - conservatives

    if (conservatives >= majority) return 0

    if (independents < votesNeeded) return -1

    return votesNeeded
}

internal class PassTheBillTest {
    @Test
    fun Members8_Conservatives3_Reformists3_Returns2() {
        assertEquals(2, passTheBill(8,3,3))
    }

    @Test
    fun Members9_Conservatives2_Reformists5_ReturnsNegative1() {
        assertEquals(-1, passTheBill(9,2,5))
    }

    @Test
    fun Members10_Conservatives6_Reformists2_Returns0() {
        assertEquals(0, passTheBill(10,6,0))
    }

    @Test
    fun Members11_Conservatives5_Reformists5_Returns1() {
        assertEquals(1, passTheBill(11,5,5))
    }
}
