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
        // AnActionEvent的扩展方法，目的是找到当前操作的虚拟文件
        e.handleVirtualFile { project, virtualFile ->
            NewLayoutDialog(project, virtualFile).show()
        }
    }

    override fun update(e: AnActionEvent) {
        with(e) {
            // 默认不显示
            presentation.isVisible = false
            // AnActionEvent的扩展方法，目的是找到当前操作的虚拟文件
            handleVirtualFile { project, virtualFile ->
                // 找到当前module，并且定位到layout文件目录
                ModuleUtil.findModuleForFile(virtualFile, project)?.sourceRoots?.map {
                    val layout = PsiManager.getInstance(project)
                        .findDirectory(it)
                        ?.findSubdirectory("layout")

                    // 当前操作范围在layout节点下
                    if (layout != null && virtualFile.path.contains(layout.virtualFile.path)) {
                        // 显示
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