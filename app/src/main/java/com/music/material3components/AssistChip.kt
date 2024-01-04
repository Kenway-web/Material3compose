package com.music.material3components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import  androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.material3.ElevatedAssistChip
import  androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import   androidx.compose.material3.ElevatedFilterChip
import    androidx.compose.material3.SuggestionChip
import    androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.InputChip


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistChip() {
    AssistChip(
        onClick = { /*TODO*/ },
        label = { Text(text = "Assit Chip") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = null,
                modifier = Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedAssistChip() {

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChip() {

    var selected by remember {
        mutableStateOf(false)
    }

    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = "Filter Chip") },
        leadingIcon = {
            if (selected) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = null,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            } else null
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedFilterChip() {

    var selected by remember {
        mutableStateOf(false)
    }


    ElevatedFilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = "Filter Chip") },
        leadingIcon = {
            if (selected) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = null,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            } else null

        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuggestionChip() {

    var selected by remember {
        mutableStateOf(false)
    }


    SuggestionChip(
        onClick = { selected = !selected },
        label = { Text(text = "Assist Chip") },
        icon = {

            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = null,
                modifier = Modifier.size(FilterChipDefaults.IconSize)
            )

        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedSuggestionChip() {

    var selected by remember {
        mutableStateOf(false)
    }

     ElevatedSuggestionChip(
        onClick = { selected = !selected },
        label = { Text(text = "Suggestion Chip") },
        icon = {

            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = null,
                modifier = Modifier.size(FilterChipDefaults.IconSize)
            )

        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputChips(){
    var selected by remember {
        mutableStateOf(false)
    }

    InputChip(
        selected = selected,
        onClick = {selected=!selected},
        label = { Text(text = "Input Chip") },
        avatar = {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = null,
                modifier = Modifier.size(FilterChipDefaults.IconSize)
            )

        }
    )

}