package com.idisfkj.databinding.autorun.ui.settings

import com.intellij.ui.layout.LCFlags
import com.intellij.ui.layout.panel
import java.awt.BorderLayout
import javax.swing.JPanel
import javax.swing.JTextField

class SettingsPanel : JPanel() {

    val defaultRootElement = JTextField()

    init {
        layout = BorderLayout()
        val panel = panel(LCFlags.fillX, title = "DataBinding Root Element") {
            row("Default root Element:") { defaultRootElement(growX) }
        }
        add(panel, BorderLayout.PAGE_START)
    }
}