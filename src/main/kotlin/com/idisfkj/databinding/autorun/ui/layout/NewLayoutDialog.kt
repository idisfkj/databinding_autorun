package com.idisfkj.databinding.autorun.ui.layout

import com.idisfkj.databinding.autorun.utils.NotificationUtils
import com.idisfkj.databinding.autorun.utils.TemplateUtils
import com.intellij.lang.xml.XMLLanguage
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.module.ModuleUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager
import com.intellij.util.IncorrectOperationException
import org.jetbrains.kotlin.idea.util.sourceRoots
import javax.swing.JComponent

class NewLayoutDialog(
    private val project: Project,
    private val actionVirtualFile: VirtualFile
) : DialogWrapper(true) {

    private val panel = NewLayoutPanel(project)

    init {
        title = "New DataBinding Layout Resource File"
        init()
    }

    override fun createCenterPanel(): JComponent? = panel

    override fun doOKAction() {
//        getModule()?.handleVirtualFile {
//            val file = it.findFile(panel.fileName.text + TemplateUtils.TEMPLATE_LAYOUT_SUFFIX)
//            if (file != null && actionVirtualFile.path.contains(it.virtualFile.path)) {
//                NotificationUtils.showMessage(
//                    project, "error",
//                    "Cannot create file '" + file.virtualFile.path + "'.\n" + "File already exits"
//                )
//                return
//            }
//        }

        val file = PsiFileFactory.getInstance(project)
            .createFileFromText(
                (panel.fileName.text
                    ?: TemplateUtils.TEMPLATE_DATABINDING_FILE_NAME) + TemplateUtils.TEMPLATE_LAYOUT_SUFFIX,
                XMLLanguage.INSTANCE,
                TemplateUtils.getTemplateContent(panel.rootElement.text)
            )

        // 通过Swing dispatch thread来进行写操作
        ApplicationManager.getApplication().runWriteAction {
            // module的扩展方法，目的是通过PsiManager定位到layout目录下
            getModule()?.handleVirtualFile {
                // 判断该操作是否在可接受的范围内
                if (actionVirtualFile.path.contains(it.virtualFile.path)) {
                    try {
                        // 添加文件
                        it.add(file)
                        // 关闭弹窗
                        close(OK_EXIT_CODE)
                    } catch (e: IncorrectOperationException) {
                        // 异常弹窗提醒
                        NotificationUtils.showMessage(
                            project, "error",
                            e.localizedMessage
                        )
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    private fun getModule(): Module? =
        ModuleUtil.findModuleForFile(actionVirtualFile, project) ?: ModuleManager.getInstance(project).findModuleByName(
            "app"
        )

    private inline fun Module.handleVirtualFile(handle: (PsiDirectory) -> Unit) {
        sourceRoots.map {
            PsiManager.getInstance(project)
                .findDirectory(it)
                ?.findSubdirectory("layout")
                ?.let { layout -> handle(layout) }
        }
    }
}