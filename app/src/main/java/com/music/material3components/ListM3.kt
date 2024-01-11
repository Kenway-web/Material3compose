package com.music.material3components

import android.widget.ImageView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

//@Composable
//fun ListM3(){
//    // showing in lazycolumn
//    LazyColumn(
//        modifier = Modifier.fillMaxSize()
//    ){
//        items(items = tasks, key = { it.id }){ task->
//            ListItem(
//                headlineContent ={
//                    Text(text = task.name)
//                },
//                leadingContent = {
//                   Icon(imageVector = task.icon, contentDescription = task.name)
//                },
//                trailingContent = {
//                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = task.name)
//                }
//            )
//
//       }
//    }
//}
@Composable
fun ListsM3() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = tasks, key = {it.id }) {task ->
            ListItem(
                headlineContent = { Text(text = task.name)},
                supportingContent = { Text(text = task.description)},
                leadingContent = {
                    Icon(imageVector = task.icon, contentDescription = task.name)
                },
                trailingContent = {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = task.name)
                }
            )
        }
    }
}

data class Task(
    val id:Int,
    val name:String,
    val icon:ImageVector,
    val description:String
)

val tasks= listOf(
    Task(1,"Buy Groceries", Icons.Outlined.ShoppingCart,"Buy Groceries from D Mart."),
    Task(2,"Call Mom", Icons.Outlined.Call,"Discuss Plan"),
    Task(3,"Finish Project", Icons.Outlined.Build,"Finish Your Coding Project"),
    Task(4,"Go for a Run", Icons.Outlined.Lock,"Run a mile"),
    Task(5,"Send Email.", Icons.Outlined.Email,"Send birthday wish to your fiends."),
)