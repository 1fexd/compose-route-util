plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `maven-publish`
    id("net.nemerosa.versioning") version "3.0.0"
}

android {
    namespace = "fe.android.compose.route.util"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
}

dependencies {
    api("androidx.compose.runtime:runtime:1.4.3")
    api("androidx.navigation:navigation-compose:2.5.3")

    api("org.jetbrains.kotlin:kotlin-reflect:1.8.21")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "fe.compose-route-util"
            version = versioning.info.tag ?: versioning.info.full

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}