package com.music.material3components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.ui.unit.dp


@Composable
fun ProgressIndicator(){
    var isLoading by remember{
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(isLoading){
            CircularProgressIndicator()
        }

        Button(onClick = {isLoading=!isLoading}) {
            Text(text = "Click here")
        }
    }
}

@Composable
fun CircularProgressIndicator(){
    var progress by remember{
        mutableStateOf(0.1f)
    }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

            CircularProgressIndicator(animatedProgress)


        Button(onClick = {
            if(progress<1f) progress+=0.1f
        }) {
            Text(text = "Click here")
        }
    }
}


@Composable
fun LinearProgressIndicator(){
    var isLoading by remember{
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(isLoading){
                LinearProgressIndicator()
        }

        Button(onClick = {isLoading=!isLoading}) {
            Text(text = "Click here")
        }
    }
}


@Composable
fun LinearProgressIndicator2(){
    var progress by remember{
        mutableStateOf(0.1f)
    }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LinearProgressIndicator(animatedProgress)


        Button(onClick = {
            if(progress<1f) progress+=0.1f
        }) {
            Text(text = "Click here")
        }
    }
}








