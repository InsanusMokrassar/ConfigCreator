package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Input

@Composable
actual fun StandardTextInputDrawer(item: String, onChange: (String) -> Unit) {
    Input(
        InputType.Text
    ) {
        onChange {
            onChange(it.value)
        }
        value(item)
    }
}