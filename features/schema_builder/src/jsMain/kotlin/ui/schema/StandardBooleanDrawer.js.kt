package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import com.benasher44.uuid.uuid4
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun StandardBooleanDrawer(item: Boolean, label: String?, onChange: (Boolean) -> Unit) {
    val uniqueId = uuid4().toString().replace(regex = Regex(pattern = "[\\d-]"), replacement = "")
    StandardRow {
        label ?.let {
            Label(uniqueId) {
                Text(it)
            }
        }
        Input(
            InputType.Checkbox
        ) {
            id(uniqueId)
            classes(SchemaDrawerStyleSheet.booleanInput)
            value(item.toString())
            onChange {
                onChange(
                    it.value
                )
            }
        }
    }
}