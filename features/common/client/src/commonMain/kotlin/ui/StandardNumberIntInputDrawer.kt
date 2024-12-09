package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable

@Composable
fun <T : Number> StandardNumberInputDrawer(
    item: T?,
    label: String?,
    placeholder: String?,
    converter: (String) -> T?,
    onChange: (T?) -> Unit
) {
    StandardTextInputDrawer(
        item ?.toString() ?: "",
        label,
        placeholder,
    ) {
        onChange(
            when {
                it.isBlank() -> null
                converter(it) != null -> converter(it)
                else -> item
            }
        )
    }
}
