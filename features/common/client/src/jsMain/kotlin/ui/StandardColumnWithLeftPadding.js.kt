package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

@Composable
actual fun StandardColumnWithLeftPadding(block: @Composable () -> Unit) {
    Div({
        classes(StandardElementsStyleSheet.columnContainer, StandardElementsStyleSheet.columnWithLeftPaddingContainer)
    }) {
        block()
    }
}