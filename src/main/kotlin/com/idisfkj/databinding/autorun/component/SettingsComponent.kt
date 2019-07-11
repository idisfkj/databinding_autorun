package com.idisfkj.databinding.autorun.component

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "SettingsConfiguration",
    storages = [Storage(value = "settingsConfiguration.xml")]
)
class SettingsComponent : PersistentStateComponent<SettingsComponent> {

    var defaultRootElement = "LinearLayout"

    companion object {
        fun getInstance(project: Project): SettingsComponent =
            ServiceManager.getService(project, SettingsComponent::class.java)
    }

    override fun getState(): SettingsComponent? = this

    override fun loadState(state: SettingsComponent) {
        XmlSerializerUtil.copyBean(state, this)
    }
}