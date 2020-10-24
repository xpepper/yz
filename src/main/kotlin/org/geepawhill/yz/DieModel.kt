package org.geepawhill.yz

import javafx.beans.property.ReadOnlyIntegerWrapper

class DieModel {
    private val pipsProperty = ReadOnlyIntegerWrapper(UNKNOWN)

    var pips: Int
        get() = pipsProperty.value
        set(value) {
            val valueToSet = if (value in 0..6) value else UNKNOWN
            pipsProperty.set(valueToSet)
        }

    companion object {
        const val UNKNOWN = 0
    }
}