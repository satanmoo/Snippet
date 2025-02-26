// web/build.gradle.kts
plugins {
    id("kotlin-convention")
}

dependencies {
    implementation(project(":domain")) // compile & runtime
    runtimeOnly(project(":infra")) // runtime only
}