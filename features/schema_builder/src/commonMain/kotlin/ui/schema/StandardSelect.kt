package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable

@Composable
expect fun <T> StandardSelect(
    selected: T,
    items: Set<T>,
    titleCreator: @Composable (T) -> String,
    onSelect: (T) -> Unit
)
