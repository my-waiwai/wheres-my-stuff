package com.waiwai.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface Screen : Parcelable {

    @Parcelize
    object Inventory : Screen

    @Parcelize
    object Settings : Screen

    @Parcelize
    object About : Screen

}
