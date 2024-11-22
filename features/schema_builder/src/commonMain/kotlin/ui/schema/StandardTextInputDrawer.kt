package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable

@Composable
expect fun StandardTextInputDrawer(
    item: String,
    onChange: (String) -> Unit
)
