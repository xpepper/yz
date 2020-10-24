package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

class YzModelTest {
    private val yz = YzModel()

    @Test
    fun `cannot roll the dice before start`() {
        assertThat(yz.canRoll.value).isFalse()
    }

    @Test
    fun `can roll the dice right after start`() {
        yz.start()
        assertThat(yz.canRoll.value).isTrue()
    }

    @Test
    fun `throws on unallowed roll`() {
        assertThrows<RuntimeException> {
            yz.roll()
        }
    }

    @Test
    fun `rolls change the dice values`() {
        yz.start()
        yz.roll()
        yz.dice.forEach { die ->
            assertThat(die.value).isNotEqualTo(0)
        }
    }

    @Test
    fun `can roll three times`() {
        yz.start()
        yz.roll()
        assertThat(yz.canRoll.value).isTrue()
        yz.roll()
        assertThat(yz.canRoll.value).isTrue()

        yz.roll()
        assertThat(yz.canRoll.value).isFalse()
    }

    @Test
    fun `start after three rolls allows a new set of three rolls`() {
        yz.start()
        yz.roll()
        yz.roll()
        yz.roll()
        assertThat(yz.canRoll.value).isFalse()

        yz.start()
        assertThat(yz.canRoll.value).isTrue()
    }
}