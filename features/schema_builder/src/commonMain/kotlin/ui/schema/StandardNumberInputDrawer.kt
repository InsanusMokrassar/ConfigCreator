package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable

@Composable
expect fun StandardNumberInputDrawer(
    item: Number?,
    label: String?,
    placeholder: String?,
    onChange: (Number?) -> Unit
)
