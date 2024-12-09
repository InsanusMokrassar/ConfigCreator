package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

@Composable
actual fun StandardColumn(block: @Composable () -> Unit)  {
    Div({
        classes(StandardElementsStyleSheet.columnContainer)
    }) {
        block()
    }
}