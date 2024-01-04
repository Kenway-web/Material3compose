package com.music.material3components


import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun Switch(){

    var isChecked by remember {
        mutableStateOf(false)
    }



    // it is taking a composable function as a paramaeter and if checked is true it will display a icon


    val icon :(@Composable () -> Unit)? = if (isChecked) {
        {
        Icon(
            imageVector =  Icons.Filled.Check ,
            //If the isChecked state variable is true, the icon variable is assigned a composable function that renders an Icon
            contentDescription = null,
            modifier = Modifier.size(SwitchDefaults.IconSize)
        )
    }
    }
    else null


     Switch(
         checked = isChecked,
         onCheckedChange = {
             isChecked = it
         },
         thumbContent = icon
     )

}



