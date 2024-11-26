package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun StandardButton(text: String, onClick: () -> Unit) {
    Button({
        classes(SchemaDrawerStyleSheet.button)
        onClick {
            onClick()
        }
    }) {
        Text(text)
    }
}
