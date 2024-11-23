package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Input

@Composable
actual fun StandardNumberInputDrawer(
    item: Number?,
    label: String?,
    placeholder: String?,
    onChange: (Number?) -> Unit
) {
    StandardCommonTextInputDrawer(
        item = item ?.toString() ?: "",
        type = InputType.Number,
        label = label,
        placeholder = placeholder,
        onChange = onChange
    )
}