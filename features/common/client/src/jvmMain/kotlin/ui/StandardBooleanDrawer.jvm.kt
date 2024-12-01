package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
actual fun StandardBooleanDrawer(
    item: Boolean,
    label: String?,
    disabled: Boolean,
    onChange: (Boolean) -> Unit
) {
    Row {
        label ?.let { Text(label) }
        Checkbox(
            item,
            onChange,
            enabled = !disabled
        )
    }
}