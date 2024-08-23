package com.medicare.myapplication

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController : NavController, musicViewModel: MusicViewModel = viewModel(),gameStatsViewModel: GameStatsViewModel = viewModel()){
    val isMusicPlaying by musicViewModel.isMusicPlaying.collectAsState()

    Scaffold(
        topBar = {
//            IconButton(
//                onClick = { musicViewModel.toggleMusic() }
//            ) {
//                val icon = if (isMusicPlaying) {
//                     painterResource(id = R.drawable.baseline_music_note_24)
//                } else {
//                     painterResource(id = R.drawable.baseline_music_off_24)
//                }
//                Image(
//                    painter = icon,
//                    contentDescription = stringResource(
//                        if (isMusicPlaying)
//                            R.string.music_on
//                        else
//                            R.string.music_off
//                    ),
//                    Modifier.size(50.dp),
//                )
            /*TODO*/
            }
    , modifier = Modifier
            .padding(0.dp, 40.dp, 0.dp, 0.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
            .size(60.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ){
            Image(
                painter = painterResource(id = R.drawable.home_bg), // Replace with your image resource ID
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop, // Adjust the image to fill the entire screen
                modifier = Modifier
                    .fillMaxSize()
                    .blur(5.dp)
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ) {
                Text(text = "Select Game Mode",
                    fontWeight = FontWeight.W900,
                    fontSize = 36.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White.copy(0.95f)
                )
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    ElevatedButton(
                        onClick = { /*Navigate to Classic Mode*/
                            navController.navigate("classic")
                        },
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 150.dp
                        ),
                        colors = ButtonColors(
                            Color(0XFF00CCCC).copy(0.98f),
                            Color.Black,
                            Color.Blue,
                            Color.Red,
                        ),

                        ) {
                        Text(text = "Classic",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.size(120.dp,40.dp),
                            fontWeight = FontWeight.W900,
                            fontSize = 28.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Blue.copy(0.9f),
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Blue.copy(alpha = 0.25f),
                                    offset = Offset(4f, 6f),
                                    blurRadius = 4f
                                )
                            )
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    ElevatedButton(
                        onClick = { /*Navigate to Expert Mode*/
                            navController.navigate("expert")
                        },
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 150.dp
                        ),
                        colors = ButtonColors(
                            Color(0XFFBB2266).copy(0.98f),
                            Color.Black,
                            Color.Blue,
                            Color.Red,
                        ),) {
                        Text(text = "Expert",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.size(120.dp,40.dp),
                            fontWeight = FontWeight.W900,
                            fontSize = 28.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Yellow.copy(0.85f),
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Red.copy(alpha = 0.4f),
                                    offset = Offset(4f, 6f),
                                    blurRadius = 40f
                                )
                            ))
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    ElevatedButton(onClick = { /*Navigate to Custom Game Mode*/
                        navController.navigate("custom")
                    }) {
                        Text(text = "Custom",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.size(120.dp,40.dp),
                            fontWeight = FontWeight.W900,
                            fontSize = 28.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Green.copy(0.9f),
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Black.copy(alpha = 0.25f),
                                    offset = Offset(2f, 2f),
                                    blurRadius = 4f
                                )
                            )
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    ElevatedButton(onClick = { /*Navigate to Custom Game Mode*/
                        navController.navigate("history")
                    }) {
                        Text(text = "History",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.size(120.dp,40.dp),
                            fontWeight = FontWeight.W900,
                            fontSize = 28.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black.copy(0.9f),
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.White.copy(alpha = 0.25f),
                                    offset = Offset(2f, 2f),
                                    blurRadius = 4f
                                )
                            )
                        )
                    }
                }
            }
        }
    }

}
//@Preview(showBackground = true)
//@Composable
//fun HomePreview(){
//    Home(navController = NavController())
//}