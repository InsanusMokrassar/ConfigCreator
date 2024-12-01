package dev.inmo.config_creator.features.common.client.ui.stylesheet

import dev.inmo.micro_utils.coroutines.compose.includeInStyleSheetsAggregator
import org.jetbrains.compose.web.css.*

object ResetStyles : StyleSheet() {
    init {
        "html, body" style {
            backgroundColor(rgba(40, 47, 64, 1))
            color(Color.white)
            fontFamily("Roboto", "serif")
            fontStyle("normal")
            fontWeight(600)
        }
        "p" style {
            margin(0.px)
        }
        includeInStyleSheetsAggregator()
    }
}