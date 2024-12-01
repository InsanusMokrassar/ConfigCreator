package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

@Composable
actual fun StandardRow(block: @Composable () -> Unit) {
    Row { block() }
}