package com.music.material3components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextFields(){

    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var ispasswordhidden by rememberSaveable {
        mutableStateOf(true)
    }

    var keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = email,
            onValueChange = {email=it},
            label={ Text("Email")},
            placeholder = { Text(text = "Enter your email....")},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email , contentDescription = null )
            },
            trailingIcon = if(email.isNotEmpty()){
                {
                    IconButton(onClick = { email = "" }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }

            }else null,
            supportingText = {Text(text="Please use the company email address ...")},
            isError = email.contains('.'),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {keyboardController?.hide()}
            ),
            singleLine = true
        )
        
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if(ispasswordhidden){
                PasswordVisualTransformation()
            }
            else VisualTransformation.None,
            trailingIcon = {
                val vsisbilityIcon = if(ispasswordhidden){
                    painterResource(R.drawable.baseline_visibility_24)
                }
                else painterResource(R.drawable.baseline_visibility_off_24)

                IconButton(onClick = { ispasswordhidden=!ispasswordhidden }) {
                    Icon(
                        painter = vsisbilityIcon,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        )

    }
}