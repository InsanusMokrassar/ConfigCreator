package dev.inmo.config_creator.features.common.client.ui

import androidx.compose.runtime.Composable
import com.benasher44.uuid.uuid4
import dev.inmo.config_creator.features.common.client.ui.stylesheet.BooleanStyleSheet
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun StandardBooleanDrawer(
    item: Boolean,
    label: String?,
    disabled: Boolean,
    onChange: (Boolean) -> Unit
) {
    val uniqueId = uuid4().toString().replace(regex = Regex(pattern = "[\\d-]"), replacement = "")
    StandardRow {
        Div({
            classes(BooleanStyleSheet.main)
        }) {
            label ?.let {
                Label(uniqueId) {
                    Text(it)
                }
            }
            Input(
                InputType.Checkbox
            ) {
                id(uniqueId)
                classes(StandardElementsStyleSheet.booleanInput)
                value(item.toString())
                if (disabled) {
                    disabled()
                } else {
                    onChange {
                        onChange(
                            it.value
                        )
                    }
                }
            }
        }
    }
}