package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

@Composable
actual fun StandardColumnWithLeftPadding(block: @Composable () -> Unit) {
    Div({
        classes(SchemaDrawerStyleSheet.columnContainer, SchemaDrawerStyleSheet.columnWithLeftPaddingContainer)
    }) {
        block()
    }
}