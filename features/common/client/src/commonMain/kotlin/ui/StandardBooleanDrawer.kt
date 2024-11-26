package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable

@Composable
expect fun StandardBooleanDrawer(
    item: Boolean,
    label: String?,
    onChange: (Boolean) -> Unit
)
