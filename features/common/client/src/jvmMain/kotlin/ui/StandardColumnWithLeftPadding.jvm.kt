package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
actual fun StandardColumnWithLeftPadding(block: @Composable () -> Unit) {
    Column(Modifier.padding(start = 16.dp)) { block() }
}