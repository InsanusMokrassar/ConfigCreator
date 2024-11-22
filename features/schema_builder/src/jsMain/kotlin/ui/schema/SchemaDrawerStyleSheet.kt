package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import org.jetbrains.compose.web.css.*

object SchemaDrawerStyleSheet : StyleSheet() {
    val rowContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
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