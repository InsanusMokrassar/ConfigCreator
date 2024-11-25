package dev.inmo.config_creator.features.schema_builder.client.ui.schema.stylesheet

import org.jetbrains.compose.web.css.*

object BooleanStyleSheet : StyleSheet() {
    val main by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        border {
            width(2.px)
            style(LineStyle.Solid)
            color(Color.white)
        }
        borderRadius(0.25.em)
        gap(8.px)
        padding(8.px)
    }
}