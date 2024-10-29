plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.food_delivery"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.food_delivery"
        minSdk = 22
        //noinspection OldTargetApi
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
        implementation (libs.androidx.viewpager2.v100)
        implementation (libs.material)
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)




    dependencies {
        // AndroidX
        implementation ("androidx.appcompat:appcompat:1.6.1")
        implementation ("androidx.core:core-ktx:1.10.0")
        implementation ("androidx.drawerlayout:drawerlayout:1.1.1")
        implementation ("androidx.coordinatorlayout:coordinatorlayout:1.1.0")
        implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
        implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")

        // Material Components
        implementation ("com.google.android.material:material:1.9.0")

        // Optional: For Kotlin Coroutines support (if using coroutines)
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

        // Optional: For ViewModel and LiveData
        implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
        implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    }


}