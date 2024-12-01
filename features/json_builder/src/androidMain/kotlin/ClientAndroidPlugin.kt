package dev.inmo.config_creator.features.json_builder.client

import dev.inmo.micro_utils.startup.plugin.StartPlugin
import kotlinx.serialization.json.JsonObject
import org.koin.core.Koin
import org.koin.core.module.Module

object ClientAndroidPlugin : StartPlugin {
    override fun Module.setupDI(config: JsonObject) {
        with(ClientPlugin) { setupDI(config) }
    }

    override suspend fun startPlugin(koin: Koin) {
        super.startPlugin(koin)
        ClientPlugin.startPlugin(koin)
    }
}