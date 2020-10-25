package org.geepawhill.yz

import java.util.*

class RandomRoller : Roller {
    private val random = Random()

    override fun roll(): Int {
        return random.nextInt(6) + 1
    }

}