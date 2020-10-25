package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.yz.DieModel.Companion.UNKNOWN
import org.junit.jupiter.api.Test

class DiceTest {
    private val dice = Dice(FakeRoller(4, 5, 2, 1, 6))

    @Test
    fun `dice starts out as unknowns`() {
        dice.pips.forEach {
            assertThat(it).isEqualTo(UNKNOWN)
        }
    }

    @Test
    fun `dice change during a roll`() {
        dice.roll()
        assertThat(dice.pips).containsExactly(4, 5, 2, 1, 6)
    }
}

class FakeRoller(vararg pending: Int) : Roller {
    private val pending = pending.toMutableList()

    override fun roll(): Int {
        return pending.removeAt(0)
    }
}

