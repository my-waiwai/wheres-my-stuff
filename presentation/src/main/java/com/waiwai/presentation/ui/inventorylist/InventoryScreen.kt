package com.waiwai.presentation.ui.inventorylist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.waiwai.presentation.R
import com.waiwai.presentation.common.SharedViewModel
import com.waiwai.presentation.models.Screen
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.hilt.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryScreen(
    navController: NavController<Screen>,
    sharedViewModel: SharedViewModel,
    viewModel: InventoryViewModel = hiltViewModel()
) {

    val inventoriesState = rememberLazyGridState()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = Modifier,
        snackbarHost = { SnackbarHost(snackbarHostState) },
//        containerColor = setThemeColor(SolarizedBase3, SolarizedBase03),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) { Text(text = stringResource(R.string.inventories)) }
                },
            )
        }
    ) { innerPadding ->

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp), // Columns adapt to screen size
            contentPadding = innerPadding,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            state = inventoriesState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            val inventoryImages = listOf(
                R.drawable.living_room,
                R.drawable.kitchen,
                R.drawable.garage,
                R.drawable.computer,
                R.drawable.bedroom,
                R.drawable.rv,
                R.drawable.bedroom,
                R.drawable.rv
            )
            val inventoryList = listOf(
                "Living Room",
                "Kitchen",
                "Garage",
                "Computer",
                "Bedroom",
                "RV",
                "Safe Deposit Box",
                "Storage Unit"
            )
            items(count = inventoryList.size, key = { it }) { index ->
                InventoryList(inventoryList[index], inventoryImages[index])
            }
        }
    }
}


@Composable
fun InventoryList(item: String, image: Any) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = image,
                contentDescription = "Inventory image",
                contentScale = ContentScale.Fit,
            )
            Text(text = item)

//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data("")
//                    .build(),
//                contentDescription = "preview",
//                contentScale = ContentScale.Inside,
//                modifier = Modifier.size(30.dp),
//            )
        }
    }
}
