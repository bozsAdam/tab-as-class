package com.github.bozsadam.tabasclass

import com.intellij.openapi.fileEditor.impl.EditorTabTitleProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

internal class CustomEditorTabTitleProvider : EditorTabTitleProvider {
    override fun getEditorTabTitle(project: Project, file: VirtualFile): String? {
        val fileContent = getFileContent(file)
        var tabName: String = ""
        if (arrayOf("php", "class").contains(file.extension)){
            tabName = getClassName(fileContent)
        }

        return tabName
    }

    private fun getFileContent(file: VirtualFile): String {
        return String(file.contentsToByteArray())
    }

    private fun getClassName(from : String): String {
        var isClass: Boolean
        var nameToFindBy: Int = from.indexOf("class ")
        var splitted: List<String>

        if (nameToFindBy != -1) {
            isClass = true
        } else {
            nameToFindBy = from.indexOf("interface")
            isClass = false
            if (nameToFindBy == -1) {
                return ""
            }
        }

        if (isClass) {
            splitted = from.split("class ")
        } else {
            splitted = from.split("interface ")
        }

        val className = splitted[1].split("\n")[0].split(" ")[0]
        return className
    }

}
