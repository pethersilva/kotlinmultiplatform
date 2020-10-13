buildscript {
	val kotlinVersion = "1.4.10"
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
		classpath("com.android.tools.build:gradle:4.0.2")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
		classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    }
}
group = "com.pethersilva.kotlinmultiplatform"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
