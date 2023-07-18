rootProject.name = "operator-test"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    plugins {
        id("io.quarkus") version "${extra["quarkus.version"]}"
    }
}
