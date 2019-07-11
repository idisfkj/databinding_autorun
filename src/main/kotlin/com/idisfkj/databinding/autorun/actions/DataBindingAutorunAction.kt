package com.idisfkj.databinding.autorun.actions

import com.idisfkj.databinding.autorun.ui.layout.NewLayoutDialog
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.module.ModuleUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import org.jetbrains.kotlin.idea.util.sourceRoots

class DataBindingAutorunAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        e.handleVirtualFile { project, virtualFile ->
            NewLayoutDialog(project, virtualFile).show()
        }
    }

    override fun update(e: AnActionEvent) {
        with(e) {
            presentation.isVisible = false
            handleVirtualFile { project, virtualFile ->
                ModuleUtil.findModuleForFile(virtualFile, project)?.sourceRoots?.map {
                    val layout = PsiManager.getInstance(project)
                        .findDirectory(it)
                        ?.findSubdirectory("layout")

                    if (layout != null && virtualFile.path.contains(layout.virtualFile.path)) {
                        presentation.isVisible = true
                        return@map
                    }
                }
            }
        }
    }

    private inline fun AnActionEvent.handleVirtualFile(handle: (Project, VirtualFile) -> Unit) {
        project?.let {
            getData(CommonDataKeys.VIRTUAL_FILE)?.let { virtualFile ->
                handle(it, virtualFile)
            }
        }
    }

}