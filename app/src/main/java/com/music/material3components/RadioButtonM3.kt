package com.music.material3components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import   androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun RadioButton(){
    val options = listOf("English","Hindi","Urdu")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        options.forEach { option ->
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(56.dp)
                   .selectable(
                       selected = selectedOption==option,
                       onClick = {selectedOption}
                   )
           ) {
                RadioButton(
                    selected = selectedOption==option,
                     onClick = { selectedOption=option }
                )
              Text(text = option)  
           }
        }
    }
}