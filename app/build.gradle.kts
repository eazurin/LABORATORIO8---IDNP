plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.lab08"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.lab08"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Versión de Room
    val room_version = "2.6.1"

    // Librerías de Room
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    // Procesador de anotaciones para Room (necesario para generar las clases)
    annotationProcessor("androidx.room:room-compiler:$room_version")

    // Si usas Kotlin (kapt en lugar de annotationProcessor)
    // kapt("androidx.room:room-compiler:$room_version")
}