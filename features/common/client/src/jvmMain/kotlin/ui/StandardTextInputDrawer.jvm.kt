package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
actual fun StandardTextInputDrawer(
    item: String,
    label: String?,
    placeholder: String?,
    onChange: (String) -> Unit
) {
    OutlinedTextField(
        item,
        onChange,
        label = label ?.let {
            @Composable {
                Text(label)
            }
        },
        placeholder = placeholder ?.let {
            @Composable {
                Text(placeholder)
            }
        }
    )
}