package org.geepawhill.yz

import javafx.beans.property.ReadOnlyIntegerProperty
import javafx.beans.property.ReadOnlyIntegerWrapper
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.scene.image.Image


class DieModel {
    private val pipsProperty = ReadOnlyIntegerWrapper(UNKNOWN)
    val pipsReadOnly: ReadOnlyIntegerProperty = pipsProperty.readOnlyProperty

    private val imageProperty = ReadOnlyObjectWrapper(images[UNKNOWN])
    val imageReadOnly: ReadOnlyObjectProperty<Image> = imageProperty.readOnlyProperty

    var pips: Int
        get() = pipsProperty.value
        set(value) {
            if (value in 0..6) {
                imageProperty.set(images[value])
                pipsProperty.set(value)
            } else {
                imageProperty.set(images[UNKNOWN])
                pipsProperty.set(UNKNOWN)
            }

        }

    companion object {
        init {
            Jfx.required()
        }

        val images = arrayListOf(
                Image("question.png", 100.0, 100.0, true, true),
                Image("one.png", 100.0, 100.0, true, true),
                Image("two.png", 100.0, 100.0, true, true),
                Image("three.png", 100.0, 100.0, true, true),
                Image("four.png", 100.0, 100.0, true, true),
                Image("five.png", 100.0, 100.0, true, true),
                Image("six.png", 100.0, 100.0, true, true))

        const val UNKNOWN = 0
    }
}