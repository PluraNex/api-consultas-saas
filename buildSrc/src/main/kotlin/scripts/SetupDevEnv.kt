package scripts

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class SetupDevEnv : DefaultTask() {

    init {
        group = "dev"
        description = "Gera application-loc.yml a partir de um template localizado em buildSrc"
    }

    @TaskAction
    fun run() {
        val projectRoot = project.rootDir

        val templateFile = File(projectRoot, "buildSrc/src/resources/template/application-loc.yml.template")

        val targetFile = File(projectRoot, "src/main/resources/application-loc.yml")

        if (!templateFile.exists()) {
            println("❌ Template não encontrado: ${templateFile.absolutePath}")
            return
        }

        if (!targetFile.exists()) {
            targetFile.writeText(templateFile.readText())
            println("✅ application-loc.yml gerado com sucesso a partir do template.")
        } else {
            println("ℹ️ application-loc.yml já existe — nenhum arquivo alterado.")
        }
    }
}
