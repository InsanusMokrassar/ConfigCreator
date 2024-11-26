package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

@Composable
actual fun StandardRow(block: @Composable () -> Unit) {
    Div({
        classes(StandardElementsStyleSheet.rowContainer)
    }) {
        block()
    }
}