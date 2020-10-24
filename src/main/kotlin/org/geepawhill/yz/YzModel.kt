package org.geepawhill.yz

import javafx.beans.binding.Bindings.greaterThan
import javafx.beans.property.SimpleIntegerProperty
import java.lang.RuntimeException
import java.util.*

class YzModel {
    private val random = Random()
    private val rollsLeftProperty = SimpleIntegerProperty(0)

    val canRoll = greaterThan(rollsLeftProperty, 0)
    
    val dice = listOf(
            SimpleIntegerProperty(0),
            SimpleIntegerProperty(0),
            SimpleIntegerProperty(0),
            SimpleIntegerProperty(0),
            SimpleIntegerProperty(0)
    )

    fun roll() {
        if (!canRoll.value) throw RuntimeException("Illegal roll called!")
        dice.forEach { die ->
            die.value = random.nextInt(6) + 1
        }
        rollsLeftProperty.value--
    }

    fun start() {
        rollsLeftProperty.value = 3
    }
}