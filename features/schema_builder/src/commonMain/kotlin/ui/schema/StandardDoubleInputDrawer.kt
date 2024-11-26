package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable

@Composable
fun StandardDoubleInputDrawer(
    item: Double?,
    label: String?,
    placeholder: String?,
    onChange: (Double?) -> Unit
) {
    StandardTextInputDrawer(
        item ?.let {
            if (it.toInt().toDouble() == it) {
                it.toString() + ".0"
            } else {
                it.toString()
            }
        } ?: "",
        label,
        placeholder,
    ) {
        val asDouble = if (it.isBlank()) {
            null
        } else {
            it.toDouble()
        }
        onChange(asDouble)
    }
}
