package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
actual fun StandardButton(text: String, onClick: () -> Unit) {
    Button(onClick) {
        Text(text)
    }
}