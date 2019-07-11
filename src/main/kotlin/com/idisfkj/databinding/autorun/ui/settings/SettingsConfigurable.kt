package com.idisfkj.databinding.autorun.ui.settings

import com.idisfkj.databinding.autorun.component.SettingsComponent
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import javax.swing.JComponent
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

class SettingsConfigurable(private val project: Project) : Configurable, DocumentListener {

    override fun changedUpdate(e: DocumentEvent?) {
        modified = true
    }

    override fun insertUpdate(e: DocumentEvent?) {
        modified = true
    }

    override fun removeUpdate(e: DocumentEvent?) {
        modified = true
    }

    private var modified = false

    private val settingsPanel = SettingsPanel()

    override fun isModified(): Boolean = modified

    override fun getDisplayName(): String = "DataBinding Autorun"

    override fun apply() {
        SettingsComponent.getInstance(project).defaultRootElement = settingsPanel.defaultRootElement.text
        modified = false
    }

    override fun createComponent(): JComponent? = settingsPanel.apply {
        defaultRootElement.text = SettingsComponent.getInstance(project).defaultRootElement
        defaultRootElement.document.addDocumentListener(this@SettingsConfigurable)
    }
}