package com.example.practicecompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.practicecompose.CodeBlock
import com.example.practicecompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Image") },
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
        Box(modifier = Modifier.padding(paddingValues)) {
            Box(
                modifier = Modifier
                    .padding(15.dp, 10.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            ) {
                Column(Modifier.fillMaxWidth()) {

                    CodeBlock("""
                        Image(
                            painter = painterResource( 
                                id = R.drawable.{imagen}
                            ),
                            contentDescription = "test"
                        )
                    """.trimIndent())
                    CodeBlock("""
                        AsyncImage(
                            model = {url},
                            contentDescription = "test"
                        )
                    """.trimIndent())

                    Box(){

                        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "test")
                        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "test")

                    }

                    Image(
                        modifier = Modifier
                            .size(200.dp),
//                            .scale(2f),
                        painter = painterResource(id = R.drawable.jesus),
                        contentDescription = "Jesus"
                    )

                    AsyncImage(
                        model = "https://t3.ftcdn.net/jpg/06/22/22/84/360_F_622228449_Ra0K8hlcWuej1e8hhwGNi5haubVOf7fg.jpg",
                        contentDescription = "Jesus fachero",
                        modifier = Modifier.size(400.dp)
                    )



                }


            }
        }
    }
}