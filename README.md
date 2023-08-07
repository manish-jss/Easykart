<p align="center">
<img src="/art/app_logo.png"/>
</p>
<h1 align="center"># Easykart 👜 </h1>

<p align="center">  
**Easykart** is a sample Ecomerce 👜 Android application 📱 built to demonstrate use of *Modern Android development* tools. This project mainly contains Compose Navigation, Coroutines, Hilt, Retrofit, and all the UI created in Jetpack Compose 👜 .
</p>


## Screenshot 📱
<p>
<img src="/art/ss1.jpeg" width="220" height="450"/>
<img src="/art/ss2.jpeg" width="220" height="450"/>
</p>


## About
It simply loads **Posts** data from API.  
- Clean and Simple Material UI.
- It supports dark theme too 🌗.

*Dummy API is used in this app. API documentation is [here](https://fakestoreapi.com/docs)*.

## Built With 🛠
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI creation library
- [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) - Navigate between Compose Screen
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  
  [Dependency Injection](https://developer.android.com/training/dependency-injection) - 
  - [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
  - [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - DI for injecting `ViewModel`.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Coil-kt](https://coil-kt.github.io/coil/) - An image loading library for Android backed by Kotlin Coroutines.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For writing Gradle build scripts using Kotlin.


# Package Structure
    
    com.sample.easykart     # Root Package
    .
    ├── data                # For data handling.
    │   ├── model           # Model classes
    │   ├── api             # Retrofit API for remote end point        
    │   └── repository      # Single source of data.
    |
    ├── di                  # Dependency Injection            
    │   ├── component       # DI Components       
    │   └── module          # DI Modules
    |
    ├── ui                  # View layer 
    │   ├── navigation          # NavHost for Compose
    │   ├── screens             # Compose Functions & ViewModel 
    │   ├── theme               # ColorSceme, Theme and Typography
    │   └── Utils               # Utility compose functions for common UI
    |
    └── utils               # Utility Classes / Kotlin extensions

    


