package dev.inmo.config_creator.features.common.client.ui.stylesheet

import dev.inmo.micro_utils.coroutines.compose.includeInStyleSheetsAggregator
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
        borderRadius(0.25.cssRem)
        gap(8.px)
        padding(4.px, 8.px)
    }

    init {
        includeInStyleSheetsAggregator()
    }
}