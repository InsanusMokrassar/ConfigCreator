package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable

@Composable
expect fun StandardButton(text: String, onClick: () -> Unit)
