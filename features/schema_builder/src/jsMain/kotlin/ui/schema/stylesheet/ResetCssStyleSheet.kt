package dev.inmo.config_creator.features.schema_builder.client.ui.schema.stylesheet

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
    }
}