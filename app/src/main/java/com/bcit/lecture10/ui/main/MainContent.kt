package com.bcit.lecture10.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcit.lecture10.data.LocalUser

@Composable
fun MainContent(userState: UserState){

    val signupState = remember { SignupState() }
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {


        Spacer(modifier = Modifier.height(10.dp))
        MyTextField(
            "username",
            signupState.name,
            signupState.onNameChanged)
        MyTextField(
            "email",
            signupState.email,
            signupState.onEmailChanged,
            signupState.validEmail)


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                userState.add(LocalUser(userName= signupState.name, email= signupState.email))
            }) {
                Text("Add")
            }
            Row {
                Button(onClick = {
                    userState.refresh()
                }) {
                    Text("Refresh")

                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(modifier =Modifier.fillMaxWidth()) {
            items(userState.users.size){
                Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()){
                    Text(userState.users[it].userName!!)
                    Text(userState.users[it].email)
                }
            }
        }
    }
}




@Composable
fun MyTextField(label:String, value:String, onValueChange: (String) -> Unit, valid:Boolean = true){


    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontSize = 30.sp),
            label = {
                Text(text = label)
            }
        )
        if (!valid) Text("not a valid email address", color = Color.Red)
    }
}