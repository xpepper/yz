package org.geepawhill.yz

import tornadofx.*

class YzView : View() {
    private val model = YzModel()

    override val root = pane {
        hbox {
            button("Start") {
                action { model.start() }
            }
            button("Roll") {
                enableWhen(model.canRoll)
                action { model.roll() }
            }
            model.dice.forEach { label(it) }
        }
    }
}