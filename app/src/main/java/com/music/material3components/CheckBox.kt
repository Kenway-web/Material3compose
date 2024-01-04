package com.music.material3components

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CheckBox(){
    val items = listOf("Pickles","Tomato","Lettuce","Chesse")

    val checkBoxState = remember{
        mutableStateMapOf<String,Boolean>().withDefault { false }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        
    ) {
        items.forEach { item->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .toggleable(
                        value = checkBoxState.getValue(item),
                        onValueChange = {checkBoxState[item]=it}
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
              Checkbox(
                  checked = checkBoxState.getValue(item),
                  onCheckedChange =null
              )
              Text(text = item)  
            }
        }
    }
}