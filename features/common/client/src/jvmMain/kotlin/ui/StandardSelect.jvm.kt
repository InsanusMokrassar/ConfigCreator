package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
actual fun <T> StandardSelect(
    selected: T,
    items: Set<T>,
    titleCreator: @Composable (T) -> String,
    onSelect: (T) -> Unit
) {
    Column {
        items.forEach {
            Row {
                RadioButton(
                    selected == it,
                    {
                        onSelect(it)
                    },
                    enabled = selected != it
                )
                Text(titleCreator(it))
            }
        }
    }
}
