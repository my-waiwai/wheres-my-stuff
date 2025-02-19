package com.waiwai.presentation.common

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.waiwai.presentation.R
import com.waiwai.presentation.models.Screen
import com.waiwai.presentation.ui.icons.Inventory

enum class BottomNavigationItem(val route: Screen,
                                val icon: ImageVector,
                                @StringRes val title: Int) {
    PortfoliosItem(
        route = Screen.Inventory,
        icon = Inventory,
        title = R.string.inventories
    ),
//    SearchItem(
//        route = Screen.Search,
//        icon = Search,
//        title = R.string.search
//    ),
//    HelpItem(
//        route = Screen.Help,
//        icon = Question_mark,
//        title = R.string.help
//    ),
//    SettingsItem(
//        route = Screen.Settings,
//        icon = Settings,
//        title = R.string.settings
//    )
}