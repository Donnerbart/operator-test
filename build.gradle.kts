plugins {
    java
    id("io.quarkus")
}

group = "de.donnerbart"

// lowercase x.y.z-SNAPSHOT to x.y.z-snapshot
val dockerImageVersion = project.version.toString().lowercase()

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}
quarkus {
    quarkusBuildProperties.put("quarkus.container-image.tag", dockerImageVersion)
}

repositories {
    mavenCentral()
}

dependencies {
    // Quarkus Operator SDK
    implementation(enforcedPlatform("io.quarkiverse.operatorsdk:quarkus-operator-sdk-bom:${property("quarkus-operator-sdk.version")}"))
    implementation("io.quarkiverse.operatorsdk:quarkus-operator-sdk")
    implementation("io.quarkiverse.operatorsdk:quarkus-operator-sdk-bundle-generator")

    // Quarkus Logging
    implementation("io.quarkiverse.logging.logback:quarkus-logging-logback:${property("quarkus-logging-logback.version")}")

    // Quarkus
    implementation("io.quarkus:quarkus-arc")

    // misc
    implementation("org.bouncycastle:bcpkix-jdk15on:${property("bouncycastle.version")}")
    implementation("org.bouncycastle:bcprov-jdk15on:${property("bouncycastle.version")}")
    implementation("org.jetbrains:annotations:${property("jetbrains.annotations")}")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

/* ******************** test ******************** */

dependencies {
    // Quarkus
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.quarkus:quarkus-test-kubernetes-client")
    testImplementation("io.rest-assured:rest-assured")

    // Testcontainers
    testImplementation("org.testcontainers:testcontainers:${property("testcontainers.version")}")
    testImplementation("org.testcontainers:k3s:${property("testcontainers.version")}")

    // misc
    testImplementation("com.github.stefanbirkner:system-lambda:${property("system-lambda.version")}")
    testImplementation("org.assertj:assertj-core:${property("assertj.version")}")
    testImplementation("org.awaitility:awaitility:${property("awaitility.version")}")
    testImplementation("org.junit-pioneer:junit-pioneer:${property("junit-pioneer.version")}")
    testImplementation("org.mockito:mockito-core:${property("mockito.version")}")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
    reports {
        junitXml.isOutputPerTestCase = true
    }
}
