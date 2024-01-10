package com.music.material3components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.ListItem
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeacrhBarm(){

    var query by remember {
        mutableStateOf("")
    }
    var isseahcbaractibve by remember {
        mutableStateOf(false)
    }
    val searchhistory = listOf("Android","Compose","Kotlin","Rx Java")

 //  SearchBar
   DockedSearchBar (
       query = query,
       onQueryChange = {query = it},
       onSearch = { neqQuery->
                  print("Performing search on the query.... $neqQuery")
       },
       active = isseahcbaractibve,
       onActiveChange ={
           isseahcbaractibve=it
       },
       placeholder = {
           Text(text = "Search")
       },
       leadingIcon = {
           Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
       },
       trailingIcon = {
          Row {
              IconButton(onClick = { /*TODO*/ }) {
                  Icon(painter = painterResource(id = R.drawable.baseline_mic_24), contentDescription = "Mic" )
              }
              if(isseahcbaractibve){
                  IconButton(onClick = { if(query.isNotEmpty()) query="" else isseahcbaractibve = false }) {
                      Icon(imageVector = Icons.Filled.Close, contentDescription = "Search")
                  }
              } else null
          }
       }
   ) {
       searchhistory.takeLast(3).forEach{item ->
                ListItem(
                    modifier = Modifier.clickable { query=item },
                    headlineContent = { Text(text = item)},
                    leadingContent = {
                         Icon(painter = painterResource(id = R.drawable.baseline_history_24), contentDescription = "History")
                    }
                )
       }
   }
}