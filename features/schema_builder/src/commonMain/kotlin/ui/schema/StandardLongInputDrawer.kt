package dev.inmo.config_creator.features.schema_builder.client.ui.schema

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
