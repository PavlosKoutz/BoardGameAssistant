package com.example.test2

import RegisterViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.navigation.compose.rememberNavController

import com.example.test2.ui.theme.Test2Theme

class A4_PlayerDisplay : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test2Theme {
                val registerViewModel: RegisterViewModel = viewModel()
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen4(
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
fun LowPanel(registerViewModel: RegisterViewModel, navController: NavController) {
    ButtonCreation(registerViewModel, navController)
}


@Composable
private fun ButtonCreation(registerViewModel: RegisterViewModel, navController: NavController) {
    val list = registerViewModel.shuffledList


    var i = 0

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            while (i < list.size) {
                Row(Modifier.padding(10.dp)) {
                    Player(i + 1, list[i], registerViewModel, navController)

                    if (list.size > 2 && i != list.size - 1) {
                        i++
                        Player(i + 1, list[i], registerViewModel, navController)
                    }
                }
                i++
            }
        }
    }
}



@Composable
private fun Player(
    num: Int, player: Register,
    registerViewModel: RegisterViewModel,
    navController: NavController
)/*, money: Int*/ {

    Button(
        modifier = Modifier
            .padding(10.dp)
            .width(170.dp)
            .height(100.dp),
        onClick = {
            val route = when (num) {

                1 -> Screen.Screen5_1.route
                2 -> Screen.Screen5_2.route
                3 -> Screen.Screen5_3.route
                4 -> Screen.Screen5_4.route
                5 -> Screen.Screen5_5.route
                6 -> Screen.Screen5_6.route
                7 -> Screen.Screen5_7.route
                8 -> Screen.Screen5_8.route

                else ->
                    Screen.Screen5_1.route
            }
            navController.navigate(route)
        },
        shape = RoundedCornerShape(10.dp)
    )
    {
        Text(
            "$num. ${player.Name}\n\n${player.Money.value}$",

            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun UpperPanel() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Current Board",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Image(
            painter = painterResource(R.drawable._21_thickbox_default_monopoly_board),
            contentDescription = "monopoly_board",
            modifier = Modifier
                .size(250.dp)
        )
    }
}


@Composable
fun Screen4(
    navController: NavController,
    registerViewModel: RegisterViewModel, modifier: Modifier = Modifier
) {

    Column(modifier) {
        UpperPanel()
        LowPanel(registerViewModel, navController)
    }
}


@Preview(showBackground = true)
@Composable
fun Greeting4Preview() {
    Test2Theme {
        Screen4(
            navController = rememberNavController(),
            modifier = Modifier,
            registerViewModel = RegisterViewModel()
        )
    }
}