package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.yz.DieModel.Companion.UNKNOWN
import org.junit.jupiter.api.Test

class DieModelTest {
    val model = DieModel()

    @Test
    fun `starts with UNKNOWN pips`() {
        assertThat(model.pips).isEqualTo(UNKNOWN)
        assertThat(model.imageReadOnly.value.url).endsWith("question.png")
    }

    @Test
    fun `legal values changes on set`() {
        model.pips = 5
        assertThat(model.pips).isEqualTo(5)
        assertThat(model.imageReadOnly.value.url).endsWith("five.png")
    }

    @Test
    fun `illegal value has no effect on pips`() {
        model.pips = -7
        assertThat(model.pips).isEqualTo(UNKNOWN)
    }
}