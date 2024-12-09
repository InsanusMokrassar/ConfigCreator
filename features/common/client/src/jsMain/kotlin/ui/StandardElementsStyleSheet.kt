package dev.inmo.config_creator.features.common.client.ui

import dev.inmo.micro_utils.coroutines.compose.includeInStyleSheetsAggregator
import org.jetbrains.compose.web.css.*

object StandardElementsStyleSheet : StyleSheet() {
    val rowContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(8.px)
        paddingTop(8.px)
        paddingLeft(8.px)
        paddingRight(8.px)
        alignItems(AlignItems.Baseline)
    }
    val columnContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Start)
        padding(8.px, 8.px, 8.px, 8.px)
    }
    val columnWithLeftPaddingContainer by style {
        paddingLeft(24.px)
    }
    val itemContainer by style {
    }
    val button by style {
        border {
            width(1.px)
            style(LineStyle.Solid)
            color(Color.transparent)
        }
        padding(8.px, 16.px)
        textAlign("center")
        borderRadius(0.25.cssRem)
        backgroundColor(rgba(225, 255, 255, 1))
        this.self + hover style {
            cursor("pointer")
            backgroundColor(rgba(240, 255, 255, 1))
        }
        this.self + active style {
            cursor("pointer")
            backgroundColor(rgba(225, 255, 255, 0.8))
        }
    }
    val booleanContainer by style {
        display(DisplayStyle.Inline)
    }
    val booleanInput by style {

    }

    val numberInput by style {

    }
    init {
        includeInStyleSheetsAggregator()
    }
}