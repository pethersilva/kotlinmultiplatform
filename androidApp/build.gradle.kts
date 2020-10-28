plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}
group = "com.pethersilva.kotlinmultiplatform"
version = "1.0-SNAPSHOT"

//adding coroutines dependency
val coroutinesVersion = "1.4.0-M1"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.2")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7")
	implementation("androidx.core:core-ktx:1.3.2")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
	implementation("androidx.core:core-ktx:1.3.2")
	implementation("androidx.recyclerview:recyclerview:1.1.0")
	implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
	implementation("androidx.cardview:cardview:1.0.0")
}
android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.pethersilva.kotlinmultiplatform.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	kotlinOptions {
		jvmTarget = JavaVersion.VERSION_1_8.toString()
	}

}
