package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitconverterTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitconverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    unitconverter()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun unitconverter() {
    var inputvalue by remember{mutableStateOf("") }
    var outputvalue by remember { mutableStateOf("") }
    var inputunit by remember { mutableStateOf("Centimeters") }
    var outputunit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val convfactor=remember{mutableStateOf(0.01)}



    Column (modifier = Modifier.fillMaxSize(),
             verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        
        Text(text = "UNIT CONVERTER")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputvalue, onValueChange = {
            inputvalue=it

        },      label = {"Enter The Value"})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = { iExpanded=true }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)


                }
                DropdownMenu(expanded =iExpanded, onDismissRequest = { iExpanded=false}) {
                    DropdownMenuItem(text = {
                        Text(text = "Centimeter")},
                        onClick = {
                            iExpanded=false
                            inputunit="Centimeters"
                            convfactor.value=0.01
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Meters")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "Feet")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "Millimeters")},
                        onClick = { /*TODO*/ })
                }

            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { oExpanded=true}) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)


                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = {
                        Text(text = "Centimeter")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "Meters")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "Feet")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "Millimeters")},
                        onClick = { /*TODO*/ })
                }

            }




            }
        Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Result")
        }

    }



@Preview(showBackground = true)
@Composable
fun unitconverterPreview(){
    unitconverter()
}