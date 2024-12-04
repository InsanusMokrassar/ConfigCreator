package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
actual fun StandardBorder(content: @Composable () -> Unit) {
    Div({
        style {
            borderRadius(0.5.em)
            border {
                width = 1.px
                style = LineStyle.Solid
                color = Color.black
            }
        }
    }) {
        content()
    }
}