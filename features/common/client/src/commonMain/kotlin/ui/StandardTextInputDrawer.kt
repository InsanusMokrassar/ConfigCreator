package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable

@Composable
expect fun StandardTextInputDrawer(
    item: String,
    label: String?,
    placeholder: String?,
    onChange: (String) -> Unit
)
