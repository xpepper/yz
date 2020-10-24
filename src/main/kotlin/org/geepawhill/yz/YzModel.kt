package org.geepawhill.yz

import javafx.beans.binding.Bindings.greaterThan
import javafx.beans.binding.BooleanBinding
import javafx.beans.property.SimpleIntegerProperty
import java.util.*

class YzModel {
    private val random = Random()
    private val rollsLeftProperty = SimpleIntegerProperty(0)

    val canRoll: BooleanBinding = greaterThan(rollsLeftProperty, 0)

    val dice = listOf(
            DieModel(),
            DieModel(),
            DieModel(),
            DieModel()
    )

    fun start() {
        rollsLeftProperty.value = 3
    }

    fun roll() {
        if (!canRoll.value) throw RuntimeException("Illegal roll called!")
        dice.forEach { die ->
            die.pips = random.nextInt(6) + 1
        }
        rollsLeftProperty.value--
    }
}