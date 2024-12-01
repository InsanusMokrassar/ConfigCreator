package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
actual fun StandardColumn(block: @Composable () -> Unit) {
    Column { block() }
}