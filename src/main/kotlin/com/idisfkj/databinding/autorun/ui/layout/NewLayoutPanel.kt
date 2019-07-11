package com.idisfkj.databinding.autorun.ui.layout

import com.idisfkj.databinding.autorun.component.SettingsComponent
import com.intellij.openapi.project.Project
import com.intellij.ui.layout.LCFlags
import com.intellij.ui.layout.panel
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.*

class NewLayoutPanel(project: Project) : JPanel() {

    val fileName = JTextField()
    val rootElement = JTextField()

    init {
        layout = BorderLayout()
        val panel = panel(LCFlags.fill) {
            row("File name:") { fileName() }
            row("Root element:") { rootElement() }
        }
        rootElement.text = SettingsComponent.getInstance(project).defaultRootElement

        add(panel, BorderLayout.CENTER)
    }

    override fun getPreferredSize(): Dimension = Dimension(300, 40)
}