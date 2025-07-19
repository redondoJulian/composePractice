package com.example.practicecompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.practicecompose.CodeBlock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cards") },
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

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                CodeBlock("""
                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(245.dp)
                            .padding(8.dp),
                        shape = ShapeDefaults.Small
                    ){
                        AsyncImage( model = "", contentDescription = "" )
                        Text( "Test" )
                    }
                """.trimIndent())

                Row(Modifier.horizontalScroll(rememberScrollState())){
                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(245.dp)
                            .padding(8.dp),
                        shape = ShapeDefaults.Small,
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        )
                    ) {
                        AsyncImage(
                            model = "https://es.web.img3.acsta.net/pictures/24/03/08/09/51/3086368.jpg",
                            contentDescription = "Intensamente 2"
                        )
                        Text(
                            text = "Intensamente 2",
                            modifier = Modifier.padding(8.dp).fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(245.dp)
                            .padding(8.dp)
                    ) {
                        AsyncImage(
                            model = "https://lumiere-a.akamaihd.net/v1/images/image002_0ebab968.png",
                            contentDescription = "Elio"
                        )
                        Text(
                            text = "Elio",
                            modifier = Modifier.padding(8.dp).fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(245.dp)
                            .padding(8.dp)
                    ) {
                        AsyncImage(
                            model = "https://turismo.benicassim.es/wp-content/uploads/2022/04/sonic2.jpg",
                            contentDescription = "Sonic la pelicula"
                        )
                        Text(
                            text = "Sonic la pelicula",
                            modifier = Modifier.padding(8.dp).fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(245.dp)
                            .padding(8.dp)
                    ) {
                        AsyncImage(
                            model = "https://www.televisa.com/_next/image?url=https%3A%2F%2Fst1.uvnimg.com%2F79%2F31%2F623659400533a75cfe139fa18859%2Fsonic-2-nuevo-poster-tales.jpg&w=1280&q=75",
                            contentDescription = "Sonic la pelicula 2"
                        )
                        Text(
                            text = "Sonic la pelicula 2",
                            modifier = Modifier.padding(8.dp).fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }
        }
    }
}