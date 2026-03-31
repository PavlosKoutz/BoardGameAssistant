@file:OptIn(ExperimentalFoundationApi::class)

package com.example.test2

import RegisterViewModel
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.test2.ui.theme.Test2Theme
import kotlinx.coroutines.delay


class A2_PlayerRegistration : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test2Theme {
                val navController = rememberNavController()
                val registerViewModel: RegisterViewModel = viewModel()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen2(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        registerViewModel = registerViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Screen2(
    modifier: Modifier,
    navController: NavController,
    registerViewModel: RegisterViewModel
) {
    val customColor1 = Color(0xFFFFA726)
    val customColor2 = Color(0xFFFF5722)
    val customColor3 = Color(0xFF00BFFF)
    var name by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val register = registerViewModel.registerList
    val mMediaPlayer1 = MediaPlayer.create(context, R.raw.transition_sound_effect)
    val mMediaPlayer2 = MediaPlayer.create(context, R.raw.turn_page)




    Box(
        modifier=Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(customColor2, customColor1, Color.Yellow)
                )
            )
    ) {
        Column {

            Image(
                painter = painterResource(id = R.drawable.logo1),
                contentDescription = "Header Image",
                modifier = Modifier
                    .width(450.dp)
                    .height(110.dp)

            )



            LazyColumn(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top,


            ) {
                itemsIndexed(register, key = { index, item -> item.Name }) { index, item ->
                    var visible by remember { mutableStateOf(false) }
                    LaunchedEffect(Unit) {
                        delay(500)
                        visible = true
                    }

                    Box(modifier = Modifier.fillMaxSize()) {
                        androidx.compose.animation.AnimatedVisibility(
                            visible = visible,
                            enter = slideInHorizontally(initialOffsetX = { 1200 })
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .height(52.dp)
                                        .width(250.dp),
                                    shape = RoundedCornerShape(8.dp),
                                    color = customColor3,
                                    border = BorderStroke(2.dp, color = Color.Black),

                                    ) {
                                    Text(
                                        text = item.Name,
                                        modifier = Modifier.padding(15.dp),
                                        fontSize = (17.sp),
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }


                                Button(modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp),
                                    shape = CircleShape,
                                    border = BorderStroke(2.dp, color = Color.Black),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                                    onClick = {
                                        registerViewModel.removeRegister(item.Name)
                                    }
                                ) {
                                    Text(
                                        text = "-",
                                        fontSize = (25.sp),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }


            Box(
                modifier = Modifier.fillMaxSize()
            ) {


                Column(
                    modifier = Modifier.align(Alignment.BottomCenter).padding(50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text(text = "Enter your name:") },
                        placeholder = { Text(text = "") },
                        modifier = Modifier
                            .height(70.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Person Icon"
                            )
                        }
                    )
                    Row {

                        Button(modifier = Modifier

                            .padding(30.dp)
                            .height(70.dp)
                            .width(120.dp),
                            border = BorderStroke(2.dp, color = Color.Black), onClick = {

                                if (register.size < 8 && name.isNotBlank() && name.length < 7) {
                                    registerViewModel.addRegister(
                                        name,
                                        money = 1000,

                                        )
                                    mMediaPlayer1.start()
                                } else if (name.length >= 7) {
                                    Toast.makeText(context, "Name is too long", Toast.LENGTH_LONG)
                                        .show()
                                }
                                name = ""
                            }) {
                            Text(
                                text = "Submit", modifier = Modifier,
                                fontSize = (21.sp)
                            )
                        }
                        if (register.size > 1) {
                            Button(modifier = Modifier
                                .padding(30.dp)
                                .width(70.dp)
                                .height(70.dp),
                                shape = CircleShape,
                                border = BorderStroke(2.dp, color = Color.Black),
                                onClick = {
                                    mMediaPlayer2.start()
                                    navController.navigate(Screen.Screen3.route)
                                }
                            ) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = "ArrowForward Icon"
                                )
                            }
                        }

                    }
                }
            }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun Greeting2Preview() {
    Test2Theme {
        Screen2(
            modifier = Modifier,
            navController = rememberNavController(),
            registerViewModel = RegisterViewModel()
        )
    }
}
