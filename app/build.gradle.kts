import java.util.regex.Pattern.compile

plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.comphrehensivehomework"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.comphrehensivehomework"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.google.android.material:material:1.12.0")
    // about me
    // implementation ("com.github.bumptech.glide:glide:3.7.0")
    // implementation ("jp.wasabeef:glide-transformations:2.0.1")


    // Application running failed when sync this dependencies
    // 必须使用
    // implementation ("com.lzy.net:okgo:2.1.4")

    // 以下三个选择添加，okrx和okrx2不能同时使用
    // implementation("com.lzy.net:okrx:1.0.2")
    // implementation ("com.lzy.net:okrx2:2.0.2")
    // implementation("com.lzy.net:okserver:2.0.5")

    implementation ("com.android.volley:volley:1.2.1")
}