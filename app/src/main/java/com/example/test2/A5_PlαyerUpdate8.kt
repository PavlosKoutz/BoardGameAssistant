package com.example.test2

import RegisterViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.TextField
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.test2.ui.theme.Test2Theme

class A5_PlayerUpdate8 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test2Theme {
                val registerViewModel: RegisterViewModel = viewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen5_8(
                        modifier = Modifier.padding(innerPadding),
                        registerViewModel =registerViewModel
                    )
                }
            }
        }
    }
}


@Composable
fun Screen5_8(modifier: Modifier, registerViewModel: RegisterViewModel){

    Column (modifier.fillMaxSize()){
        Text(registerViewModel.shuffledList[7].Name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally))
        PropertiesPanel8(registerViewModel = registerViewModel)
    }
}





@SuppressLint("UnrememberedMutableState")
@Composable
fun PropertiesPanel8(registerViewModel: RegisterViewModel) {
    val context = LocalContext.current

    val items = listOf(
        "Mediterranean Avenue",
        "Baltic Avenue",
        "Reading Railroad",
        "Oriental Avenue",
        "Vermont Avenue",
        "Connecticut Avenue",
        "St. Charles Place",
        "States Avenue",
        "Virginia Avenue",
        "Pennsylvania Railroad",
        "St. James Place",
        "Tennessee Avenue",
        "New York Avenue",
        "Kentucky Avenue",
        "Indiana Avenue",
        "Illinois Avenue",
        "B&O Railroad",
        "Atlantic Avenue",
        "Ventnor Avenue",
        "Marvin Gardens",
        "Pacific Avenue",
        "North Carolina Avenue",
        "Pennsylvania Avenue",
        "Short Line",
        "Park Place",
        "Boardwalk",

        )
    val itemColors = mapOf(
        "Mediterranean Avenue" to Color(0XFF84553e),
        "Baltic Avenue" to Color(0xFF84553e),
        "Oriental Avenue" to Color(0xFFbae2f9),
        "Vermont Avenue" to Color(0xFFbae2f9),
        "Connecticut Avenue" to Color(0xFFbae2f9),
        "St. Charles Place" to Color(0xFFe03c94),
        "States Avenue" to Color(0xFFe03c94),
        "Virginia Avenue" to Color(0xFFe03c94),
        "St. James Place" to Color(0xFFe1932b),
        "Tennessee Avenue" to Color(0xFFe1932b),
        "New York Avenue" to Color(0xFFe1932b),
        "Kentucky Avenue" to Color(0xFFcc232a),
        "Indiana Avenue" to Color(0xFFcc232a),
        "Illinois Avenue" to Color(0xFFcc232a),
        "Atlantic Avenue" to Color(0xFFfff22c),
        "Ventnor Avenue" to Color(0xFFfff22c),
        "Marvin Gardens" to Color(0xFFfff22c),
        "Pacific Avenue" to Color(0xFF64b160),
        "North Carolina Avenue" to Color(0xFF64b160),
        "Pennsylvania Avenue" to Color(0xFF64b160),
        "Park Place" to Color(0xFF1e72b5),
        "Boardwalk" to Color(0xFF1e72b5),
        "Reading Railroad" to Color(0xFFd3e7ce),
        "Pennsylvania Railroad" to Color(0XFFd3e7ce),
        "B&O Railroad" to Color(0xFFd3e7ce),
        "Short Line" to Color(0xFFd3e7ce),
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(items[0]) }
    val selectedItems=registerViewModel.properties8


    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.weight(1f)) {
                Text(
                    text = selectedItem,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true }
                        .padding(12.dp)
                        .border(1.dp, MaterialTheme.colorScheme.onSurfaceVariant)
                )
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    items.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                selectedItem = item
                                expanded = false
                            },
                            modifier = Modifier
                                .background(itemColors[item] ?: Color.White)
                                .fillMaxWidth()
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (selectedItems.any { it.name == selectedItem }) {
                        Toast.makeText(context, "$selectedItem already exists!", Toast.LENGTH_SHORT).show()
                    } else {
                        selectedItems.add(ItemWithCounters(name = selectedItem))
                    }


                },
                modifier = Modifier.size(80.dp, 40.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("Add",
                    fontSize = 20.sp,
                    color = Color.White)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    val index = selectedItems.indexOfFirst { it.name == selectedItem }

                    if (index != -1)  {
                        selectedItems.removeAt(index)
                    } else {
                        Toast.makeText(context, "$selectedItem not in list!", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.size(80.dp, 40.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("Delete",
                    fontSize = 20.sp,
                    color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Selected Items:", style = MaterialTheme.typography.titleMedium)

        LazyColumn {
            items(selectedItems) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(itemColors[item.name] ?: Color.White)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        item.name,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(1f)
                    )

                    Counter8("House", item.houses)
                    Spacer(Modifier.width(8.dp))
                    Counter8("Hotel", item.hotels)
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }


        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.weight(1f))
            val currentPlayer  = registerViewModel.shuffledList.getOrNull(7)

            if (currentPlayer != null) {
                print("Hello world")
                CurrencyInputField8 (
                    value = currentPlayer.Money.value.toString(),
                    onValueChange = { newValue ->
                        val parsedValue = newValue.toIntOrNull()
                        if (parsedValue != null) {
                            registerViewModel.updateMoney(currentPlayer.Name, parsedValue)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Counter8(label: String, value: MutableState<Int>) {
    Column {
        Text("$label: ${value.value}")
        Spacer(modifier = Modifier.width(4.dp))
        Row {
            Button(
                onClick = { if (value.value > 0) value.value-- },
                modifier = Modifier.size(40.dp, 30.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("-",
                    fontSize = 20.sp,
                    color = Color.White)
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                onClick = { if (value.value < 10)  value.value++ },
                modifier = Modifier.size(40.dp, 30.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("+",
                    fontSize = 20.sp,
                    color = Color.White)
            }
        }
    }
}

@Composable
fun CurrencyInputField8(
    value: String,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text("€", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.width(4.dp))
        TextField(
            value = value,
            onValueChange = { newValue ->
                if (newValue.matches(Regex("^\\d*(\\.\\d{0,2})?\$"))) {
                    onValueChange(newValue)
                }
            },
            label = { Text("Amount") },
            singleLine = true,
            modifier = Modifier.width(140.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting12Preview() {
    Test2Theme {
        Screen5_8(modifier = Modifier, registerViewModel = RegisterViewModel())
    }
} // @Composable
// fun Greeting4(nameOrder:ArrayList<String>, modifier: Modifier = Modifier) {
// val names = remember { mutableStateListOf<String>().apply { addAll(nameOrder) } }
// Column(
// modifier = Modifier.fillMaxSize().padding(50.dp),
//
// verticalArrangement = Arrangement.Top,
// horizontalAlignment = Alignment.CenterHorizontally
// ) {
// names.take(names.size).forEachIndexed { index, name ->
// Button(
// modifier = Modifier
// .padding(4.dp)
// .height(70.dp)
// .width(200.dp),
// shape = RoundedCornerShape(8.dp),
// colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
// onClick = {
// val rotated = names.drop(index) + names.take(index)
// names.clear()
// names.addAll(rotated)
//
// }
// ) {
// Text(
// text ="${index + 1}.  $name",
// modifier = Modifier.padding(15.dp),
// fontSize = 17.sp
// )
// }
//
// }
//
// }
// Box(modifier = Modifier.fillMaxSize()) {
// Button(
// modifier = Modifier
// .align(Alignment.BottomCenter)
// .padding(4.dp)
// .height(90.dp)
// .width(140.dp)
// .offset(y = -70.dp),
//
// colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
// onClick = {}
// ) {
// Text(
// text = "SELECT TURN",
// textAlign = TextAlign.Center,
// modifier = Modifier.padding(15.dp),
// fontSize = 17.sp
// )
// }
// }
//
// }
//
//
// @Preview(showBackground = true)
// @Composable
// fun GreetingPreview5() {
// Test2Theme {
// Greeting5(nameOrder = ArrayList())
// }
// }
// /*
// @Composable
// fun Greeting4(nameOrder:ArrayList<String>, modifier: Modifier = Modifier) {
// val names = remember { mutableStateListOf<String>().apply { addAll(nameOrder) } }
// Column(
// modifier = Modifier.fillMaxSize().padding(50.dp),
//
// verticalArrangement = Arrangement.Top,
// horizontalAlignment = Alignment.CenterHorizontally
// ) {
// names.take(names.size).forEachIndexed { index, name ->
// Button(
// modifier = Modifier
// .padding(4.dp)
// .height(70.dp)
// .width(200.dp),
// shape = RoundedCornerShape(8.dp),
// colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
// onClick = {
// val rotated = names.drop(index) + names.take(index)
// names.clear()
// names.addAll(rotated)
//
// }
// ) {
// Text(
// text ="${index + 1}.  $name",
// modifier = Modifier.padding(15.dp),
// fontSize = 17.sp
// )
// }
//
// }
//
// }
// Box(modifier = Modifier.fillMaxSize()) {
// Button(
// modifier = Modifier
// .align(Alignment.BottomCenter)
// .padding(4.dp)
// .height(90.dp)
// .width(140.dp)
// .offset(y = -70.dp),
//
// colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
// onClick = {}
// ) {
// Text(
// text = "SELECT TURN",
// textAlign = TextAlign.Center,
// modifier = Modifier.padding(15.dp),
// fontSize = 17.sp
// )
// }
// }
//
// }
//
//
// @Preview(showBackground = true)
// @Composable
// fun GreetingPreview5() {
// Test2Theme {
// Greeting5(nameOrder = ArrayList())
// }
// }
//
// */
// /*
// @Composable
// fun Greeting4(nameOrder:ArrayList<String>, modifier: Modifier = Modifier) {
// val names = remember { mutableStateListOf<String>().apply { addAll(nameOrder) } }
// Column(
// modifier = Modifier.fillMaxSize().padding(50.dp),
//
// verticalArrangement = Arrangement.Top,
// horizontalAlignment = Alignment.CenterHorizontally
// ) {
// names.take(names.size).forEachIndexed { index, name ->
// Button(
// modifier = Modifier
// .padding(4.dp)
// .height(70.dp)
// .width(200.dp),
// shape = RoundedCornerShape(8.dp),
// colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
// onClick = {
// val rotated = names.drop(index) + names.take(index)
// names.clear()
// names.addAll(rotated)
//
// }
// ) {
// Text(
// text ="${index + 1}.  $name",
// modifier = Modifier.padding(15.dp),
// fontSize = 17.sp
// )
// }
//
// }
//
// }
// Box(modifier = Modifier.fillMaxSize()) {
// Button(
// modifier = Modifier
// .align(Alignment.BottomCenter)
// .padding(4.dp)
// .height(90.dp)
// .width(140.dp)
// .offset(y = -70.dp),
//
// colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
// onClick = {}
// ) {
// Text(
// text = "SELECT TURN",
// textAlign = TextAlign.Center,
// modifier = Modifier.padding(15.dp),
// fontSize = 17.sp
// )
// }
// }
//
// }
//
//
// @Preview(showBackground = true)
// @Composable
// fun GreetingPreview5() {
// Test2Theme {
// Greeting5(nameOrder = ArrayList())
// }
// }
//
// *