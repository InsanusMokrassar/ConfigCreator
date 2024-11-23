package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import com.benasher44.uuid.uuid4
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun StandardTextInputDrawer(
    item: String,
    label: String?,
    placeholder: String?,
    onChange: (String) -> Unit
) {
    StandardCommonTextInputDrawer(
        item = item,
        type = InputType.Text,
        label = label,
        placeholder = placeholder,
        onChange = onChange
    )
}