package com.idisfkj.databinding.autorun.utils

object TemplateUtils {
    const val TEMPLATE_DATABINDING_FILE_NAME = "activity_databinding_test_layout"
    const val TEMPLATE_LAYOUT_SUFFIX = ".xml"

    fun getTemplateContent(rootElement: String) = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<layout>\n" +
            "\n" +
            "    <data>\n" +
            "\n" +
            "        <variable\n" +
            "            name=\"\"\n" +
            "            type=\"\" />\n" +
            "    </data>\n" +
            "\n" +
            "    <$rootElement xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "        xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
            "        android:layout_width=\"match_parent\"\n" +
            "        android:layout_height=\"wrap_content\">\n" +
            "        \n" +
            "    </$rootElement>\n" +
            "\n" +
            "</layout>"
}