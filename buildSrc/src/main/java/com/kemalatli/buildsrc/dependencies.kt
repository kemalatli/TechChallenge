/*
 * Copyright 2019 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kemalatli.buildsrc

object App{

    val ID = "com.kemalatli.techchallenge"
    val minSDK = 19
    val compileSDK = 29
    val targetSDK = 29
    val buildTools = "29.0.1"
    val kotlinVersion = "1.3.50"

    object Plugin{
        val androidGradlePlugin = "com.android.tools.build:gradle:3.4.2"
        val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50"
    }

}

object Libs {

    object Koin{
        private const val version = "2.0.1"
        val koin = "org.koin:koin-android:$version"
        val scope =  "org.koin:koin-android-scope:$version"
        val viewmodel =  "org.koin:koin-android-viewmodel:$version"
    }

    object AndroidX {

        val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta2"

        object Lifecycle {
            private const val version = "2.2.0-alpha03"
            val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Room {
            private const val version = "2.1.0-alpha07"
            val common = "androidx.room:room-common:$version"
            val runtime = "androidx.room:room-runtime:$version"
            val rxjava2 = "androidx.room:room-rxjava2:$version"
            val compiler = "androidx.room:room-compiler:$version"
            val ktx = "androidx.room:room-ktx:$version"
            val testing = "androidx.room:room-testing:$version"
        }

        object Work {
            private const val version = "2.0.1"
            val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
        }
    }

    object RxJava {
        val rxJava = "io.reactivex.rxjava2:rxjava:2.2.8"
        val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.3.0"
        val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
        val binding = "com.jakewharton.rxbinding3:rxbinding-core:3.0.0"
        val binding_appcompat = "com.jakewharton.rxbinding3:rxbinding-appcompat:3.0.0"
    }

    object Retrofit {
        private const val version = "2.5.0"
        val retrofit = "com.squareup.retrofit2:retrofit:$version"
        val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "3.12.0"
        val okhttp = "com.squareup.okhttp3:okhttp:$version"
        val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Epoxy {
        private const val version = "3.7.0"
        val epoxy = "com.airbnb.android:epoxy:$version"
        val paging = "com.airbnb.android:epoxy-paging:$version"
        val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
        val processor = "com.airbnb.android:epoxy-processor:$version"
    }

    object Arch{
        val mvrx = "com.airbnb.android:mvrx:1.0.2"
    }

}
