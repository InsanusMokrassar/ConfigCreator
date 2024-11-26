package dev.inmo.config_creator.features.common.client.ui

import org.jetbrains.compose.web.css.*

object StandardElementsStyleSheet : StyleSheet() {
    val rowContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(8.px)
        padding(8.px, 8.px, 0.px, 8.px)
        alignItems(AlignItems.Center)
    }
    val columnContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Start)
    }
    val columnWithLeftPaddingContainer by style {
        paddingLeft(8.px)
    }
    val itemContainer by style {
    }
    val button by style {
    }
    val booleanContainer by style {
        display(DisplayStyle.Inline)
    }
    val booleanInput by style {

    }

    val numberInput by style {

    }
}