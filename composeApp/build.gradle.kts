import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation("io.github.aakira:napier:2.7.1")
            implementation("com.alexstyl:addcoilmultiplatform:3.0.0-rc01")
            // Plot
            implementation("io.github.koalaplot:koalaplot-core:0.10.3")
            implementation("com.himanshoe:charty:3.0.0-rc01")
            // Iconos
            implementation(libs.composeIcons.fontAwesome)
            // DI
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.viewmodel.navigation)
            // Navegacion
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.1")
            implementation(libs.ktor.serialization.kotlinx.json)
            // Networking
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logs)
        }
        wasmJsTest.dependencies {
            implementation("org.jetbrains.kotlin:kotlin-test-wasm-js:2.3.0")
            implementation(libs.koin.test)
        }

        jsTest.dependencies {
            implementation("org.jetbrains.kotlin:kotlin-test-js:2.3.0")
            implementation(libs.koin.test)
        }
    }
}


