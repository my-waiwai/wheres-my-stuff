package com.waiwai.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.waiwai.presentation.common.BottomNavigationItem
import com.waiwai.presentation.common.SharedViewModel
import com.waiwai.presentation.models.Screen
import com.waiwai.presentation.ui.inventorylist.InventoryScreen
import com.waiwai.presentation.ui.inventorylist.InventoryViewModel
import com.waiwai.presentation.ui.theme.WheresMyStuffTheme
import dagger.hilt.android.AndroidEntryPoint
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavHost
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.popAll
import dev.olshevski.navigation.reimagined.rememberNavController
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by viewModels()
    private val startDestinationViewModel: InventoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WheresMyStuffTheme {
                val navController = rememberNavController<Screen>(
                    startDestination = Screen.Inventory
                )

                NavBackHandler(navController)

                val isBackStackEmpty by remember {
                    derivedStateOf {
                        navController.backstack.entries.size == 1
                    }
                }

                BackHandler(enabled = isBackStackEmpty) {
                    finish()
                }

                val currentDestination by remember {
                    derivedStateOf {
                        navController.backstack.entries.first().destination
                    }
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(0.dp),
//                    containerColor = setThemeColor(SolarizedBase3, SolarizedBase03),
                    bottomBar = {
                        NavigationBar(
//                            containerColor = navigationBarContainerColors(),
//                            contentColor = navigationBarContentColor()
                        ) {
                            BottomNavigationItem.entries.forEach { item ->
                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            item.icon,
                                            contentDescription = stringResource(id = item.title)
                                        )
                                    },
                                    label = { Text(stringResource(id = item.title)) },
                                    selected = item.route == currentDestination,
//                                    colors = navigationBarItemColors(),
                                    onClick = {
                                        if (item.route != currentDestination) {
                                            navController.popAll()
                                            navController.navigate(item.route)
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->

                    Surface(modifier = Modifier.padding(innerPadding)) {
//                        SharedElementsRoot {
                            NavHost(
                                controller = navController,
                                //transitionSpec = mainNavHostTransitionSpec
                            ) { route ->
                                when (route) {
                                    is Screen.Inventory -> {
                                        InventoryScreen(
                                            navController = navController,
                                            sharedViewModel = sharedViewModel,
                                            viewModel = startDestinationViewModel
                                        )
                                    }
                                    else -> {}


//                                    is Screen.PortfolioDetail -> { PortfolioDetailScreen(sharedViewModel = sharedViewModel, navController = navController) }
//                                    is Screen.SecurityDetail -> { SecurityDetailScreen(sharedViewModel = sharedViewModel, navController = navController) }
//                                    is Screen.AddTransaction -> { AddTransactionScreen(sharedViewModel = sharedViewModel, navController = navController) }
//                                    is Screen.AllTransactions -> { AllTransactionsScreen(sharedViewModel = sharedViewModel, navController = navController) }
//                                    is Screen.Search -> { SearchScreen(navController = navController) }
//                                    is Screen.Help -> { HelpScreen(navController = navController) }
//                                    is Screen.Settings -> { SettingsScreen(navController = navController) }
//                                    is Screen.GeneralSettings -> { GeneralSettingsScreen(navController = navController) }
//                                    is Screen.DisplaySettings -> { DisplaySettingsScreen(navController = navController) }
//                                    is Screen.About -> {
//                                        AboutScreen(
//                                            navController = navController,
//                                            playStoreCoinTrendPackageName = packageName,
//                                            onLinkClick = { url ->
//                                                this@MainActivity.openUrlInExternalBrowser(url = url)
//                                            },
//                                            onEmailClick = { email, subject ->
//                                                this@MainActivity.openEmailInExternalApp(
//                                                    toEmailAddresses = setOf(email),
//                                                    subject = subject
//                                                )
//                                            },
//                                            onPlayStoreClick = {
//                                                openAppInPlayStore(packageName = packageName)
//                                            }
//                                        )
                                }
                            }
                        }
//                    }
                }
            }
        }
    }
}
