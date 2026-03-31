package com.example.test2

import RegisterViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.test2.ui.theme.Test2Theme

class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Test2Theme {
                val navController = rememberNavController()
                val registerViewModel: RegisterViewModel = viewModel()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Greeting.route
                    ) {
                        composable(Screen.Greeting.route) {
                            Screen1(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,

                                )
                        }


                        composable(Screen.Screen2.route) {
                            Screen2(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                registerViewModel = registerViewModel
                            )
                        }

                        composable(Screen.Screen3.route) {
                            Screen3(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                registerViewModel = registerViewModel
                            )

                        }
                        composable(Screen.Screen4.route) {
                            Screen4(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                registerViewModel = registerViewModel
                            )
                        }


                        composable(Screen.Screen5_1.route) {
                            Screen5_1(
                                modifier = Modifier.padding(innerPadding),
                                registerViewModel = registerViewModel
                            )
                        }
                        composable(Screen.Screen5_2.route) {
                            Screen5_2(
                                modifier = Modifier.padding(innerPadding),
                                registerViewModel = registerViewModel
                            )
                        }
                        composable(Screen.Screen5_3.route) {
                            Screen5_3(
                                modifier = Modifier.padding(innerPadding),
                                registerViewModel = registerViewModel
                            )
                        }
                        composable(Screen.Screen5_4.route) {
                            Screen5_4(
                                modifier = Modifier.padding(innerPadding),
                                registerViewModel = registerViewModel
                            )

                        }
                        composable(Screen.Screen5_5.route) {
                            Screen5_5(
                                modifier = Modifier.padding(innerPadding),
                                registerViewModel = registerViewModel
                            )

                        }

                        composable(Screen.Screen5_6.route) {
                            Screen5_6(
                                modifier = Modifier.padding(innerPadding),
                                registerViewModel = registerViewModel
                            )

                        }
                        composable(Screen.Screen5_7.route) {
                            Screen5_7(
                                modifier = Modifier.padding(innerPadding),
                                registerViewModel = registerViewModel
                            )

                        }
                        composable(Screen.Screen5_8.route) {
                            Screen5_8(
                                modifier = Modifier.padding(innerPadding),
                                registerViewModel = registerViewModel
                            )

                        }
                    }
                }
            }
        }
    }


    @Composable
    fun Screen1(modifier: Modifier, navController: NavController) {

        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Board Helper!",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .align(Alignment.TopCenter)
                    .padding(40.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(10.dp)
            ) {

                Monopoly(navController)
                Catan()
            }

        }
    }

    @Composable
    fun Catan() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.catan),
                    contentDescription = "Header Image",
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(150.dp)
                )
                Column {
                    Button(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(200.dp)
                            .height(50.dp),
                        onClick = { TODO() },
                        shape = RoundedCornerShape(10.dp)
                    )
                    {
                        Text(
                            text = "New Game",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Button(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(200.dp)
                            .height(50.dp),
                        onClick = { TODO() },
                        shape = RoundedCornerShape(10.dp)
                    )
                    {
                        Text(
                            text = "////////",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun Monopoly(navController: NavController) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.logo1),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(150.dp)
                )
                Column {
                    Button(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(200.dp)
                            .height(50.dp),
                        onClick = { navController.navigate(Screen.Screen2.route) },
                        shape = RoundedCornerShape(10.dp)
                    )
                    {
                        Text(
                            text = "New Game",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Button(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(250.dp)
                            .height(50.dp),
                        onClick = { navController.navigate(Screen.Screen4.route) },
                        shape = RoundedCornerShape(10.dp)
                    )
                    {
                        Text(
                            text = "Continue",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Test2Theme {
            Screen1(modifier = Modifier, navController = rememberNavController())
        }
    }
}