
package com.example.test2
import RegisterViewModel
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.test2.ui.theme.Test2Theme




@ExperimentalFoundationApi
class A3_PlayerShuffle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test2Theme {
                val registerViewModel: RegisterViewModel = viewModel()
                val navController = rememberNavController()
                Scaffold(modifier = Modifier) { innerPadding ->
                    Screen3(
                        registerViewModel = registerViewModel,
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
        }
    }
}



@Composable
fun Screen3(modifier: Modifier,
              navController: NavController,
              registerViewModel: RegisterViewModel) {

    val customColor1 = Color(0xFFFFA726)
    val customColor2 = Color(0xFFFF5722)
    val customColor3 = Color(0xFF00BFFF)
    val context = LocalContext.current
    var startAnimation by remember { mutableStateOf(true) }
    var startAnimation2 by remember { mutableStateOf(true) }
    val mMediaPlayer1 = MediaPlayer.create(context, R.raw.turn_page)
    val mMediaPlayer2 = MediaPlayer.create(context, R.raw.roll)
    var isEnabled by remember { mutableStateOf(true) }
    val scale = remember { Animatable(1f) }
    val scale2 = remember { Animatable(1f) }

    LaunchedEffect(startAnimation) {
        if (startAnimation) {
            while (startAnimation) {
                scale.animateTo(1.15f, animationSpec = tween(400))
                scale.animateTo(1f, animationSpec = tween(200))
            }
        } else {
            scale.animateTo(1f)
        }
    }




    LaunchedEffect(startAnimation2) {
        if (startAnimation2) {
            while (startAnimation2) {
                scale2.animateTo(1.15f, animationSpec = tween(400))
                scale2.animateTo(1f, animationSpec = tween(200))
            }
        } else {
            scale2.animateTo(1f)
        }
    }

    Box(
        modifier = modifier.fillMaxSize().background(
            brush = Brush.linearGradient(
                colors = listOf(customColor2, customColor1, Color.Yellow)
            )
        )
    ) {

       /* Image(
            painter = painterResource(id = R.drawable._2),
            contentDescription = "Header Image",
            modifier = Modifier
                .width(600.dp)
                .height(600.dp)
                .graphicsLayer(

                )
        )*/
        Column(modifier=Modifier.fillMaxSize().align(Alignment.TopCenter)) {


            LazyColumn(modifier = Modifier.padding(20.dp)) {
                itemsIndexed(
                    registerViewModel.shuffledList,
                    key = { _, name -> name }) { index, name ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateItem(tween(durationMillis = 2000))
                    ) {
                        Text(
                            text = "${index + 1}.",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(15.dp), color = Color.White
                        )
                        Surface(
                            modifier = Modifier.padding(5.dp)
                                .height(52.dp).width(250.dp),
                            shape = RoundedCornerShape(8.dp),
                            color = customColor3,
                            border = BorderStroke(2.dp, color = Color.Black)
                        ) {
                            Text(
                                text = name.Name,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(15.dp), color = Color.White
                            )
                        }
                    }
                }
            }


            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.resource__),
                        contentDescription = "Image Left",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .aspectRatio(1f)
                            .graphicsLayer(
                                scaleX = 3f,
                                scaleY = 3f
                            )
                    )


                    Box(
                        modifier = Modifier
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = {
                                if (isEnabled) {
                                    mMediaPlayer2.start()
                                    registerViewModel.shuffleNames()
                                    isEnabled = false
                                    startAnimation = false
                                }
                            },

                            enabled = isEnabled,
                            modifier = Modifier.size(80.dp)
                                .graphicsLayer(
                                    scaleX = scale.value,
                                    scaleY = scale.value
                                ),
                            border = BorderStroke(2.dp, color = Color.Black)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Refresh,
                                contentDescription = "Refresh Icon",
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }


                    Image(
                        painter = painterResource(id = R.drawable.resource2),
                        contentDescription = "Image Right",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .aspectRatio(1f)
                            .graphicsLayer(
                                scaleX = 3f,
                                scaleY = 3f
                            )
                    )
                }



                if (!isEnabled) {
                    Button(modifier = Modifier.padding(20.dp)
                        .height(70.dp).width(70.dp).align(Alignment.BottomCenter).graphicsLayer(
                            scaleX = scale2.value,
                            scaleY = scale2.value
                        ),
                        border = BorderStroke(2.dp, color = Color.Black), onClick = {
                            mMediaPlayer1.start()
                            navController.navigate(Screen.Screen4.route)
                        }) {
                        Icon(
                            modifier = Modifier.size(70.dp),
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "ArrowForward Icon"
                        )
                    }
                }

            }




            LaunchedEffect(Unit) {
                startAnimation = true
                startAnimation2 = true
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Test2Theme {
        Screen3(
            registerViewModel = RegisterViewModel()

            ,
            modifier = Modifier, navController = rememberNavController()
        )
    }
}
