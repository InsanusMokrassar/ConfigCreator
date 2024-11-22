package dev.inmo.config_creator.features.schema_builder.client

import dev.inmo.config_creator.features.schema_builder.common.CommonJVMPlugin
import dev.inmo.config_creator.features.schema_builder.common.CommonJVMPlugin.setupDI
import dev.inmo.micro_utils.startup.plugin.StartPlugin
import kotlinx.serialization.json.JsonObject
import org.koin.core.Koin
import org.koin.core.module.Module

object ClientJVMPlugin : StartPlugin {
    override fun Module.setupDI(config: JsonObject) {
        with(CommonJVMPlugin) { setupDI(config) }
        with(ClientPlugin) { setupDI(config) }
    }

    override suspend fun startPlugin(koin: Koin) {
        super.startPlugin(koin)
        CommonJVMPlugin.startPlugin(koin)
        ClientPlugin.startPlugin(koin)
    }
}