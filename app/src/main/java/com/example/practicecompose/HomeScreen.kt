package com.example.practicecompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CircleNotifications
import androidx.compose.material.icons.filled.Draw
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Pages
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.SwitchLeft
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material.icons.filled.VerticalAlignBottom
import androidx.compose.material.icons.filled.VolumeDown
import androidx.compose.material.icons.filled.WifiProtectedSetup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = (Icons.Default.Home),
                            contentDescription = "home"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Box(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxSize()
            )
            {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.text.route)
                        },
                        title = "Text",
                        icon = Icons.Default.TextFields
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.buttons.route)
                        },
                        title = "Buttons",
                        icon = Icons.Default.AddCircle
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.textField.route)
                        },
                        title = "Text Field",
                        icon = Icons.Default.Textsms
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.sendingParameters1.route)
                        },
                        title = "Sending parameters to URL",
                        icon = Icons.AutoMirrored.Default.Send
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.checkbox.route)
                        },
                        title = "Checkbox",
                        icon = Icons.Default.CheckBox
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.switch.route)
                        },
                        title = "Switch",
                        icon = Icons.Default.SwitchLeft
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.radios.route)
                        },
                        title = "Radios",
                        icon = Icons.Default.RadioButtonChecked
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.image.route)
                        },
                        title = "Images",
                        icon = Icons.Default.Image
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.indicators.route)
                        },
                        title = "Indicators",
                        icon = Icons.Default.WifiProtectedSetup
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.badges.route)
                        },
                        title = "Badges",
                        icon = Icons.Default.Notifications
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.slider.route)
                        },
                        title = "Slider",
                        icon = Icons.Default.VolumeDown
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.dropdown.route)
                        },
                        title = "Dropdown",
                        icon = Icons.Default.ArrowDropDown
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.cards.route)
                        },
                        title = "Cards",
                        icon = Icons.Default.Inbox
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.pager.route)
                        },
                        title = "Pager",
                        icon = Icons.Default.Pages
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.bottomAppBar.route)
                        },
                        title = "BottomNavigationBar",
                        icon = Icons.Default.VerticalAlignBottom
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.modalNavigationDrawer.route)
                        },
                        title = "Modal Navigation Drawer",
                        icon = Icons.Default.Draw
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.circularImage.route)
                        },
                        title = "Circular Image",
                        icon = Icons.Default.AccountCircle
                    )

                    HorizontalDivider()
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.remember.route)
                        },
                        title = "Recordatorios",
                        icon = Icons.Default.Info
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.practice.route)
                        },
                        title = "Practice",
                        icon = Icons.Default.Person
                    )
                }
            }
        }
    }
}

@Composable
fun CardContent(modifier: Modifier, title: String, icon: ImageVector) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title
                    )
                    Spacer(
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Text(
                        text = title,
                        fontSize = 21.sp,
                    )
                }
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                    contentDescription = "go"
                )
            }
        }

    }
    //HorizontalDivider()
}