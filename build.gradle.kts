import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")

    application

    id("io.spring.dependency-management")
    id("org.springframework.boot")
}

repositories {
    mavenCentral()
}

dependencyManagement {
    dependencies {
        imports {
            mavenBom("org.jetbrains.kotlin:kotlin-bom:${getKotlinPluginVersion()}")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

application {
    mainClass.set("sample.SampleMain")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = project.java.targetCompatibility.majorVersion
        }
    }

    test {
        useJUnitPlatform()
    }

    jar {
        enabled = true
    }

    bootJar {
        archiveClassifier.set("all")
    }

    wrapper {
        gradleVersion = "7.4.2"
        distributionType = Wrapper.DistributionType.ALL
    }
}
