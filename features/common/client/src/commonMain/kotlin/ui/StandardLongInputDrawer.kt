package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable

@Composable
fun StandardLongInputDrawer(
    item: Long?,
    label: String?,
    placeholder: String?,
    onChange: (Long?) -> Unit
) {
    StandardNumberInputDrawer(
        item,
        label,
        placeholder,
        { it.toLongOrNull() },
        onChange
    )
}
