pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val dependencyManagementPluginVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion
        id("io.spring.dependency-management") version dependencyManagementPluginVersion
        id("org.springframework.boot") version springBootVersion
    }
}

rootProject.name = "spring-boot-gradle-sample"
