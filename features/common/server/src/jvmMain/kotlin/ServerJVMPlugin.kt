package dev.inmo.config_creator.features.common.server

import dev.inmo.config_creator.features.common.common.CommonJVMPlugin
import dev.inmo.micro_utils.startup.plugin.StartPlugin
import kotlinx.serialization.json.JsonObject
import org.koin.core.Koin
import org.koin.core.module.Module

object ServerJVMPlugin : StartPlugin {
    override fun Module.setupDI(config: JsonObject) {
        with(CommonJVMPlugin) { setupDI(config) }
        with(ServerPlugin) { setupDI(config) }
    }

    override suspend fun startPlugin(koin: Koin) {
        super.startPlugin(koin)
        CommonJVMPlugin.startPlugin(koin)
        ServerPlugin.startPlugin(koin)
    }
}