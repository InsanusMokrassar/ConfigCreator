package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable

@Composable
actual fun StandardBooleanDrawer(
    item: Boolean,
    label: String?,
    disabled: Boolean,
    onChange: (Boolean) -> Unit
) {
}