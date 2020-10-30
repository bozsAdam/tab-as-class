package com.github.bozsadam.tabasclass.services

import com.intellij.openapi.project.Project
import com.github.bozsadam.tabasclass.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
