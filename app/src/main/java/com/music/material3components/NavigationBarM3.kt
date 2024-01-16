package com.music.material3components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun NavigationBarScaffold(){
    Scaffold(
        bottomBar = { NavigationBarM3() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {paddingValues ->  
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
                contentPadding = PaddingValues(16.dp)
        ){
            items(50){
                    ListItem(
                        headlineContent = { Text(text = "Item $it")},
                        leadingContent = {
                            Icon(imageVector = Icons.Default.Face , contentDescription = null )
                        }
                    )
            }
        }
    }
}


@Composable
fun NavigationBarM3(){
    var selectedItem by remember { mutableStateOf(0) }

    var barItem = listOf(
        BarItem(title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "home"
        ),
        BarItem(title = "Contacts",
            selectedIcon = Icons.Filled.Face,
            unselectedIcon = Icons.Outlined.Face,
            route = "home"
        ),
        BarItem(title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = "settings"
        ),
        BarItem(title = "Shop",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
            route = "shop"
        ),
    )

    NavigationBar {
        barItem.forEachIndexed{index, barItem ->
            val selected = selectedItem == index
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                          selectedItem  =index
                    /*navigation logic*/
                },
                icon = {
                    Icon(
                            imageVector = if (selected) barItem.selectedIcon else barItem.unselectedIcon,
                          contentDescription = barItem.title
                    )
                },
                label = {
                    Text(text = barItem.title)
                },
                alwaysShowLabel = selected
            )
        }
    }

}

data class BarItem(
    var title:String,
    var selectedIcon:ImageVector,
    var unselectedIcon:ImageVector,
    var route:String
)