<div align="center">

<!-- <p><img src="https://github.com/CoinTrend/CoinTrend/blob/develop/metadata/en-US/images/icon.png" width="200"></p> -->

# Where's My Stuff

### Lightweight Personal Inventory Utility

[![Android](https://img.shields.io/badge/Android-grey?logo=android&style=flat)](https://www.android.com/)
[![AndroidAPI](https://img.shields.io/badge/API-26%2B-859900.svg?style=flat)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/kotlin-2.0.21-6c71c4.svg?logo=kotlin)](https://kotlinlang.org)
[![JetpackCompose](https://img.shields.io/badge/Jetpack%20Compose-1.7.5-b58900)](https://developer.android.com/jetpack/compose)
[![Release](https://badgen.net/github/release/my-waiwai/wheres-my-stuff?color=dc322f)](https://github.com/my-waiwai/wheres-my-stuff/releases)

</div>

 ----

Lightweight and fast utility for Android dedicated to tracking where your personal items are located.

## Features

- **List Items**: show a list of your items
- **Add Items**: add an item to your inventory
- **Settings**: customize your in-app experience

### Lightweight
At this time, Where's My Stuff does not require internet access, nor does it ask for it.

### Designed for Android
The User Interface has been designed by following the latest Google's Material Design guidelines and by using only native Android components and animations.


## Technical Details

- **100% Jetpack Compose** 🚀

- **Material Design 3** 💎

- **Multimodule Clean Architecture** 🏛 as [davidepanidev](https://github.com/davidepanidev)'s [Clean Architecture Compose Concept](https://github.com/davidepanidev/android-multimodule-architecture-concepts/tree/clean-architecture-compose-concept) which consists of four separate modules:
  -  _app_: Android module that contains the Android Application component and all the framework specific configurations. It has visibility over all the other modules and defines the global dependency injection configurations.
  -  _presentation_: Android **MVVM**-based module. It contains the Android UI framework components (Activities, Composables, ViewModels...) and the related resources (e.g. images, strings...). This module just observes data coming from the undelying modules through Kotlin Flows and displays it. 
  -  _domain_: Kotlin module that contains platform-independent business logic, the entities (platform-independent business models), and the repository interfaces. It contains the `BaseAutomaticRefreshDataFlowUseCase` which handles the logic to refresh the persisted data when it becomes outdated.
  -  _data_: Android module that acts as the **Single-Source-Of-Truth** of the app. It contains repositories implementations, the Room entities for persistence, the data source API implementations and the corresponding API-specific models.

## Credits

### Contributors

- [Dave Wiard](https://github.com/davewiard)

### Libraries and References

- [CoinTrend](https://github.com/CoinTrend/CoinTrend): provided a very clean MVVM example to learn from

- [nicolashaan](https://github.com/nicolashaan): for the [Resultat](https://github.com/nicolashaan/resultat) library

- [olshevski](https://github.com/olshevski): for the [Compose Navigation Reimagined](https://github.com/olshevski/compose-navigation-reimagined) library

- [mxalbert1996](https://github.com/mxalbert1996): for the [Compose Shared Element](https://github.com/mxalbert1996/compose-shared-elements) library


## Support

Where's My Stuff does not generate any revenue. If you wish to support the developers you can donate some sats (Satoshis) at the Bitcoin address below:
