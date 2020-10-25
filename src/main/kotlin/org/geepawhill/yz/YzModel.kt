package org.geepawhill.yz

import javafx.beans.binding.Bindings.greaterThan
import javafx.beans.binding.BooleanBinding
import javafx.beans.property.SimpleIntegerProperty

class YzModel {
    private val game = YzGame()
    private val rollsLeftProperty = SimpleIntegerProperty(0)

    val canRoll: BooleanBinding = greaterThan(rollsLeftProperty, 0)

    val dice = listOf(
            DieModel(),
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

        game.dice.roll()
        for (die in 0..4) dice[die].pips = game.dice.pips[die]
        rollsLeftProperty.value--
    }
}