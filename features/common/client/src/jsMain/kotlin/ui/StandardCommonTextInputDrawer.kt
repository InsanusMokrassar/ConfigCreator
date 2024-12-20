package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable
import com.benasher44.uuid.uuid4
import dev.inmo.config_creator.features.common.client.ui.stylesheet.InputStyleSheet
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

@Composable
fun <T> StandardCommonTextInputDrawer(
    item: String,
    type: InputType<T>,
    label: String?,
    placeholder: String?,
    onChange: (T) -> Unit
) {
    val uniqueId = uuid4().toString().replace(regex = Regex(pattern = "[\\d-]"), replacement = "")
    Div({ classes(InputStyleSheet.containerStandardInput) }) {
        label?.let {
            Label(uniqueId) {
                Text(it)
            }
        }
        Input(
            type
        ) {
            classes(InputStyleSheet.textInput)
            onInput {
                onChange(it.value)
            }
            placeholder?.let {
                placeholder(it)
            }
            value(item)
        }
    }
}