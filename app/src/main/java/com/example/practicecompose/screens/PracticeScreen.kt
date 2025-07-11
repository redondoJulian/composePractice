package com.example.practicecompose.screens

import com.example.practicecompose.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Practice") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                            contentDescription = "go back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    var checkValue by remember { mutableStateOf(false) }
                    var switchValue by remember { mutableStateOf(false) }
                    val isEnabled = true
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            if (isEnabled) {
                                checkValue = !checkValue
                            }
                        }
                    ) {
                        Checkbox(
                            checked = checkValue,
                            onCheckedChange = { checkValue = it },
                            enabled = isEnabled,
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Black,
                                uncheckedColor = Color.Gray,
                                checkmarkColor = Color.White
                            )
                        )
                        Text("Checkbox")
                    }
                    HorizontalDivider()
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                switchValue = !switchValue
                            }
                    ) {
                        Text("Habilitar seccion")
                        Switch(
                            checked = switchValue,
                            onCheckedChange = { switchValue = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = Color.Black,
                                uncheckedThumbColor = Color.Black,
                                uncheckedTrackColor = Color.White
                            )
                        )
                    }

                    HorizontalDivider()

                    var radioValue by remember { mutableIntStateOf(1) }
                    var isEnabled2 by remember { mutableStateOf(false) }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            if (isEnabled2) {
                                radioValue = 1
                            }
                        }
                    ) {
                        RadioButton(
                            selected = (radioValue == 1),
                            onClick = {
                                if (isEnabled2) {
                                    radioValue = 1
                                }
                            },
                            enabled = isEnabled2,
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text("Opcion 1")
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            if (isEnabled2) {
                                radioValue = 2
                            }
                        }
                    ) {
                        RadioButton(
                            selected = (radioValue == 2),
                            onClick = {
                                if (isEnabled2) {
                                    radioValue = 2
                                }
                            },
                            enabled = isEnabled2,
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text("Opcion 2")
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            if (isEnabled2) {
                                radioValue = 3
                            }
                        }
                    ) {
                        RadioButton(
                            selected = (radioValue == 3),
                            onClick = {
                                if (isEnabled2) {
                                    radioValue = 3
                                }
                            },
                            enabled = isEnabled2,
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text("Opcion 3")
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            if (isEnabled2) {
                                radioValue = 4
                            }
                        }
                    ) {
                        RadioButton(
                            selected = (radioValue == 4),
                            onClick = {
                                if (isEnabled2) {
                                    radioValue = 4
                                }
                            },
                            enabled = isEnabled2,
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text("Opcion 4")
                    }
                    ElevatedButton(
                        onClick = {
                            isEnabled2 = !isEnabled2
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color.Black
                        ),
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 8.dp,
                            hoveredElevation = 10.dp
                        )
                    ) { Text("Habilitar/Deshabilitar") }

                    ///////////////////////////////////////////////////////////////////////////////////////////////
                    ///////////////////////////////////////////////////////////////////////////////////////////////
                    ///////////////////////////////////////////////////////////////////////////////////////////////
                    ///////////////////////////////////////////////////////////////////////////////////////////////
                    ///////////////////////////////////////////////////////////////////////////////////////////////

                    Image(painter = painterResource(id = R.drawable.jesus), contentDescription = "jesus")
                    Box(){
                        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "fondo")
                        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "android")
                    }

                    var checkBoxValue by remember { mutableStateOf(false) }
                    var switchValue2 by remember { mutableStateOf(false) }
                    Checkbox(
                        checked = checkBoxValue,
                        onCheckedChange = { checkBoxValue = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Black,
                            uncheckedColor = Color.Gray,
                            checkmarkColor = Color.White
                        )
                    )

                    var radioButtonValue by remember { mutableIntStateOf(0) }
                    RadioButton(
                        selected = ( radioButtonValue == 1 ),
                        onClick = { radioButtonValue = 1 },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Black,
                            unselectedColor = Color.Gray
                        )
                    )
                    RadioButton(
                        selected = ( radioButtonValue == 2 ),
                        onClick = { radioButtonValue = 2 },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Black,
                            unselectedColor = Color.Gray
                        )
                    )
                    RadioButton(
                        selected = ( radioButtonValue == 3 ),
                        onClick = { radioButtonValue = 3 },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Black,
                            unselectedColor = Color.Gray
                        )
                    )

                    Switch(
                        checked = switchValue2,
                        onCheckedChange = { switchValue2 = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color.Black,
                            checkedBorderColor = Color.DarkGray,
                            uncheckedTrackColor = Color.White,
                            uncheckedThumbColor = Color.Black,
                            uncheckedBorderColor = Color.Black
                        )
                    )
                }
            }
        }
    }
}