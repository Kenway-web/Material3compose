package com.music.material3components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.ui.text.style.TextOverflow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithScaffold(){
    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = { LargeTopAppBarM3(scrollBehavior = scrollBehaviour) }
    ){ paddingValues ->
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
                          Icon(imageVector = Icons.Default.Face, contentDescription = null)
                      }
                  )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopApBarM3(
    scrollBehavior: TopAppBarScrollBehavior
){
   TopAppBar(
        scrollBehavior = scrollBehavior,
       title = { Text(text = " Top Stories")},
       navigationIcon = {
           Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
       },
       actions = {
           IconButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Open likes")
           }
       }
   )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumTopAppBar(    scrollBehavior: TopAppBarScrollBehavior
){
       MediumTopAppBar(
        scrollBehavior = scrollBehavior,
        title = { Text(text = "Top Stories")},
        navigationIcon = {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Open likes")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopAppBar(    scrollBehavior: TopAppBarScrollBehavior
){
    MediumTopAppBar(
        scrollBehavior = scrollBehavior,
        title = { Text(text = "Top Stories")},
        navigationIcon = {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Open likes")
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBarM3(scrollBehavior: TopAppBarScrollBehavior){
       LargeTopAppBar(
        scrollBehavior = scrollBehavior,
        title = { Text(text = "AL Industry Power Limited.", maxLines = 1, overflow = TextOverflow.Ellipsis)},
        navigationIcon = {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Open likes")
            }
        }
    )
}



