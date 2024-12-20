package dev.inmo.config_creator.features.common.common

import dev.inmo.micro_utils.startup.plugin.StartPlugin
import kotlinx.serialization.json.JsonObject
import org.koin.core.Koin
import org.koin.core.module.Module

object CommonJSPlugin : StartPlugin {
    override fun Module.setupDI(config: JsonObject) {
        with (CommonPlugin) { setupDI(config) }
    }

    override suspend fun startPlugin(koin: Koin) {
        super.startPlugin(koin)
        CommonPlugin.startPlugin(koin)
    }
}