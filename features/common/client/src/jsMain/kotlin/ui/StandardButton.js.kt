package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun StandardButton(text: String, onClick: () -> Unit) {
    Button({
        classes(StandardElementsStyleSheet.button)
        onClick {
            onClick()
        }
    }) {
        Text(text)
    }
}
