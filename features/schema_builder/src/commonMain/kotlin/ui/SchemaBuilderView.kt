// Temporarily disabled due to builds errors and absence of this file necessity

//package dev.inmo.config_creator.features.schema_builder.client.ui
//
//import androidx.compose.runtime.Composable
//import dev.inmo.config_creator.features.schema_builder.client.ui.schema.SchemaDrawer
//import dev.inmo.navigation.core.NavigationChain
//import dev.inmo.navigation.core.NavigationNodeId
//import dev.inmo.navigation.mvvm.compose.ComposeView
//import org.koin.core.component.inject
//import org.koin.core.parameter.parametersOf
//
//class SchemaBuilderView(
//    config: SchemaBuilderViewConfig,
//    chain: NavigationChain<Any?>,
//    id: NavigationNodeId = NavigationNodeId()
//) : ComposeView<SchemaBuilderViewConfig, Any?, SchemaBuilderViewModel>(
//    config = config,
//    chain = chain,
//    id = id
//) {
//    override val viewModel: SchemaBuilderViewModel by inject<SchemaBuilderViewModel> {
//        parametersOf(this)
//    }
//
//    @Composable
//    override fun onDraw() {
//        super.onDraw()
//
//        SchemaDrawer(
//            config.initialSchema
//        ) {
//            config = config.copy(
//                it
//            )
//        }
//    }
//}