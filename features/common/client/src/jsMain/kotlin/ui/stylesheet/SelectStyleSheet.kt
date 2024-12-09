package dev.inmo.config_creator.features.common.client.ui.stylesheet

import dev.inmo.micro_utils.coroutines.compose.includeInStyleSheetsAggregator
import org.jetbrains.compose.web.css.*

object SelectStyleSheet : StyleSheet() {
    init {
        "select" style {
            property("appearance", "none")
            outline("12px red")
            border(0.px)
            property("box-shadow", "none")
            flex(1)
            padding(0.em, 0.5.em)
            color(Color.white)
            backgroundColor(Color.darkslategray)
            backgroundImage("none")
            cursor("pointer")
            position(Position.Relative)
        }
    }
    val rootContainerSelect by style {
        "::after" style {
            property("content", "'\\25BC")
            position(Position.Absolute)
            top(0.px)
            right(0.px)
            padding(0.5.em)
            backgroundColor(Color.gray)
            property("transition", ".25s all ease")
            property("pointer-events", "none")
        }
        ":hover::after" style {
            color(Color.darkslategray)
        }
    }
    val containerSelect by style {
        position(Position.Relative)
        display(DisplayStyle.Flex)
        width(20.em)
        height(2.em)
        borderRadius(0.25.em)
        overflow("hidden")
        "*" style {
            fontSize(1.15.cssRem)
            fontWeight(600)
        }
    }

    init {
        includeInStyleSheetsAggregator()
    }
}