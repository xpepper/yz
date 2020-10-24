package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.yz.DieModel.Companion.UNKNOWN
import org.junit.jupiter.api.Test

class DieModelTest {
    val model = DieModel()

    @Test
    fun `starts with UNKNOWN`() {
        assertThat(model.pips).isEqualTo(UNKNOWN)
    }

    @Test
    internal fun `legal values changes on set`() {
        model.pips = 5
        assertThat(model.pips).isEqualTo(5)
    }

    @Test
    fun `illegal value has no effect on pips`() {
        model.pips = -7
        assertThat(model.pips).isEqualTo(UNKNOWN)
    }
}