package com.music.material3components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import  androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardBottomSheet() {
    val scope = rememberCoroutineScope()
    val scoffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = scoffoldState,
        sheetPeekHeight = 128.dp,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Swipe Up to expand the sheet..")
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Sheet Content..")
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    scope.launch { scoffoldState.bottomSheetState.partialExpand() }
                }) {
                        Text(text = "Click to cpllapse sheet")
                }
            }
        }
    ) {innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.Center
            ) {
            Text(text = "Scafold Content..")
        }

    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModelBottomSheet() {

    var isbottomsheetopened by remember {
        mutableStateOf(false)
    }

    // state of model bottom sheet

    var scope = rememberCoroutineScope()
    var bottomsheet = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )


    Button(onClick = {isbottomsheetopened=true}) {
        Text("Show Bottom Sheet.")
    }

    if(isbottomsheetopened){
            ModalBottomSheet(
                sheetState =  bottomsheet,
                onDismissRequest = {isbottomsheetopened=false },
                dragHandle = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BottomSheetDefaults.DragHandle()
                        Text(text = "Comments" , style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.height(10.dp))
                        Divider()
                    }
                }
                ) {
                BottomSheetContent(
                    onHideButtonClicked = {
                                scope.launch { bottomsheet.hide() }.invokeOnCompletion {
                                    if(!bottomsheet.isVisible) isbottomsheetopened = false
                                }
                    }
                )
            }
    }
}


@Composable
fun BottomSheetContent(
    onHideButtonClicked:()->Unit
){
    LazyColumn(contentPadding = PaddingValues(16.dp) )
    {
        items(5){
                    ListItem(
                        headlineContent = {Text(text = "item $it")},
                        leadingContent = {
                            Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                        }
                    )
        }
        item{
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onHideButtonClicked
            ) {
                    Text(text = "Cancel")
            }
        }

    }
}