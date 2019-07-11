package com.idisfkj.databinding.autorun.utils

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationListener
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

object NotificationUtils {

    fun notifyMessage(
        title: String,
        content: String,
        displayId: String,
        notificationType: NotificationType = NotificationType.INFORMATION,
        displayType: NotificationDisplayType = NotificationDisplayType.BALLOON,
        logByDefault: Boolean = true,
        listener: NotificationListener? = null
    ) {
        NotificationGroup(displayId, displayType, logByDefault)
            .createNotification(title, content, notificationType, listener)
            .notify(null)
    }

    fun showMessage(project: Project, title: String, message: String) {
        Messages.showIdeaMessageDialog(
            project,
            message,
            title,
            arrayOf("OK"),
            0,
            Messages.getErrorIcon(), null
        )
    }
}