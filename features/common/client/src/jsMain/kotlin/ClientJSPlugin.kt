package dev.inmo.config_creator.features.common.client

import dev.inmo.config_creator.features.common.common.CommonJSPlugin
import dev.inmo.micro_utils.startup.plugin.StartPlugin
import kotlinx.serialization.json.JsonObject
import org.koin.core.Koin
import org.koin.core.module.Module

object ClientJSPlugin : StartPlugin {
    override fun Module.setupDI(config: JsonObject) {
        with(CommonJSPlugin) { setupDI(config) }
        with(ClientPlugin) { setupDI(config) }
    }

    override suspend fun startPlugin(koin: Koin) {
        super.startPlugin(koin)
        CommonJSPlugin.startPlugin(koin)
        ClientPlugin.startPlugin(koin)
    }
}