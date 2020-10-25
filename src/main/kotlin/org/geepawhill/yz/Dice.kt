package org.geepawhill.yz

import org.geepawhill.yz.DieModel.Companion.UNKNOWN

class Dice(private val roller: Roller) {
    val pips = arrayOf(UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN)

    fun roll() {
        for (i in 0..4) pips[i] = roller.roll()
    }
}