package com.music.material3components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun NavigationDrawer(){

     val drawerState  = rememberDrawerState(initialValue = DrawerValue.Closed)
     val scope = rememberCoroutineScope()

    val items = listOf(
        DrawableItems(Icons.Default.Favorite,"Likes","64"),
        DrawableItems(Icons.Default.Face,"Messages","64"),
        DrawableItems(Icons.Default.Email,"Mail","64"),
        DrawableItems(Icons.Default.Settings,"Settings","64")
    )

    var selectedItem by remember{
        mutableStateOf(items[0])
    }

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(64.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Header",style=MaterialTheme.typography.headlineLarge)
                    }
                    items.forEach{ item ->
                        NavigationDrawerItem(
                            label = { Text(text = item.label)},
                            selected = item == selectedItem,
                            onClick = {
                                scope.launch {drawerState.open()}
                                selectedItem = item
                            },
                            icon={Icon(imageVector = item.icon , contentDescription = item.label)},
                            badge = { Text(text = item.secondarylabel)},
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
          content = {
              Content (
                  onClick = { scope.launch {drawerState.open()}}
              )
          }
        )
}

data class DrawableItems(
    val icon:ImageVector,
    val label: String,
    val secondarylabel :String
)


@Composable
fun Content(
    onClick: () -> Unit
){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = ">>> Swipe >>>")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = onClick) {
                Text(text = "Click to Open")
            }
        }
}
