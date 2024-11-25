package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import org.jetbrains.compose.web.css.*

object SchemaDrawerStyleSheet : StyleSheet() {
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
    }
    val itemContainer by style {
    }
    val booleanContainer by style {
        display(DisplayStyle.Inline)
    }
    val booleanInput by style {

    }

    val numberInput by style {

    }
}