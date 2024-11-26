package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable

@Composable
expect fun <T> StandardSelect(
    selected: T,
    items: Set<T>,
    titleCreator: @Composable (T) -> String,
    onSelect: (T) -> Unit
)
