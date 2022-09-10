/*
 * Copyright 2022 Marco Dalla Ba'
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Versions {
    const val COMPOSE_COMPILER = "1.3.1"
    const val COMPOSE = "1.2.1"
    const val COMPOSE_NAVIGATION = "2.5.2"
    const val COMPOSE_HILT_NAVIGATION = "1.0.0"
    const val ACTIVITY = "1.5.1"
    const val KOTLIN = "1.7.10"
    const val HILT = "2.43.2"
    const val VERSIONS = "0.42.0"
    const val ROOM = "2.4.3"
    const val LOGGING_INTERCEPTOR = "4.9.3"
    const val RETROFIT = "2.9.0"
    const val PAGING = "3.1.1"
    const val PAGING_COMPOSE = "1.0.0-alpha16"
}

object Sdk {
    const val COMPILE_SDK_VERSION = 33
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 33
}

object ComposeLibs {
    const val UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val ACTIVITY = "androidx.activity:activity-compose:${Versions.ACTIVITY}"
    const val UI_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    const val NAVIGATION = "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"
    const val HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:${Versions.COMPOSE_HILT_NAVIGATION}"
}

object HiltLibs {
    const val ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val CORE = "com.google.dagger:hilt-core:${Versions.HILT}"
    const val COMPILER = "com.google.dagger:hilt-compiler:${Versions.HILT}"
    const val ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
}

object RetrofitLibs {
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
}

object RoomLibs {
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
}

object Paging {
    const val PAGING_RUNTIME = "androidx.paging:paging-runtime:${Versions.PAGING}"
    const val PAGING_COMPOSE = "androidx.paging:paging-compose:${Versions.PAGING_COMPOSE}"
}

object AndroidXLibs {
    const val APP_COMPACT= "androidx.appcompat:appcompat:${Versions.ACTIVITY}"
    const val CORE = "androidx.core:core-ktx:1.9.0"
}

object AndroidXTestLibs {
    const val JUNIT = "androidx.test.ext:junit:1.1.3"
}

object TestLibs {
    const val JUNIT = "junit:junit:4.13.2"
}

object AndroidLibs {
    const val MATERIAL = "com.google.android.material:material:1.6.1"
}