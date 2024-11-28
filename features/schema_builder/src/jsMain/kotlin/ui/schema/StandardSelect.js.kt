package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.selected
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun <T> StandardSelect(
    selected: T,
    items: Set<T>,
    titleCreator: @Composable (T) -> String,
    onSelect: (T) -> Unit
) {
    val titles = items.associateWith { titleCreator(it) }
    Select({
        onChange {
            onSelect(items.elementAt(it.value ?.toIntOrNull() ?: return@onChange))
        }
    }) {
        items.forEachIndexed { i, it ->
            val title = titles.getValue(it)
            Option(
                i.toString(),
                {
                    if (it == selected) {
                        selected()
                    }
                }
            ) {
                Text(title)
            }
        }
    }
}