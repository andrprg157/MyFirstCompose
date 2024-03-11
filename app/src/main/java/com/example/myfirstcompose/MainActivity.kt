package com.example.myfirstcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Horizontal
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcompose.ui.theme.MyFirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Text(text = "Hello Compose!!!")
            // UNCOMMENT FOR COUNTER    PreviewFunction()
            //ListComposable()
            LearningTask()

        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun LearningTask() {

    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        val username = remember {
            mutableStateOf(TextFieldValue())
        }
        val password = remember {
            mutableStateOf(TextFieldValue())
        }

        Image(painter = painterResource(id = R.drawable.composeimg),
            modifier = Modifier.size(35.dp),
            contentDescription = "TestImage")
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            text = "Hello Compose",
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            label = { Text(text = "Username") },
            value = username.value, onValueChange = {username.value = it})

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            label = { Text(text = "Password") },
            value = password.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {password.value = it}

        )
        Button(onClick = {
            Toast.makeText(context, "Button Clicked!!!",Toast.LENGTH_LONG).show()
        },modifier = Modifier.padding(30.dp)) {
            Text(text = "Login")
        }
    }
}

// UNCOMMENT BELOW TO SEE COUNTER EXAMPLE
//@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun PreviewFunction() {
    /*Row {
        Button(onClick = { }) {
            Text(text = "Submit")
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Dummy"
            )
        }
    }*/


    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = count.toString())
        Button(onClick = { count++ }) {
            Text(text = "Click Me")
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun ListComposable() {
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = name, onValueChange = { text ->
                    name = text

                },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                if (name.isNotBlank()) {
                    names = names + name
                    name = ""
                }
            }) {
                Text(text = "Add")
            }
        }
        LazyColumn {
            items(names) { currentName ->
                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Divider()
            }
        }
    }
}

