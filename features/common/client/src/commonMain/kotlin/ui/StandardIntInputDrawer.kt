package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable

@Composable
fun StandardIntInputDrawer(
    item: Int?,
    label: String?,
    placeholder: String?,
    onChange: (Int?) -> Unit
) {
    StandardNumberInputDrawer(
        item,
        label,
        placeholder,
        { it.toIntOrNull() },
        onChange
    )
}
