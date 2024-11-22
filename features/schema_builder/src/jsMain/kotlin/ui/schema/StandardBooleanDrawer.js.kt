package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Input

@Composable
actual fun StandardBooleanDrawer(item: Boolean, onChange: (Boolean) -> Unit) {
    Input(
        InputType.Checkbox
    ) {
        classes(SchemaDrawerStyleSheet.booleanInput)
        value(item.toString())
        onChange {
            onChange(
                it.value
            )
        }
    }
}