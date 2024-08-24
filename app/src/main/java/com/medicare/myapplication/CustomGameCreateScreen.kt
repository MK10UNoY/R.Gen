package com.medicare.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomGameCreateScreen(
    musicViewModel : MusicViewModel = viewModel(),
    gameStatsViewModel: GameStatsViewModel = viewModel(),
    navController: NavController
    ){
    var upperLim by remember{
        mutableStateOf("")
    }
    var lowerLim by remember{
        mutableStateOf("")
    }
    var maxtrails by remember{
        mutableStateOf("")
    }
    var answer by remember{
        mutableStateOf("")
    }
    var errorMessage by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Box(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(16.dp))
        .clickable { // Dismiss keyboard on click outside
//                focusManager.clearFocus()
        }){
        Image(
            painter = painterResource(id = R.drawable.home_bg), // Replace with your image resource ID
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop, // Adjust the image to fill the entire screen
            modifier = Modifier
                .fillMaxSize()
                .blur(4.dp)
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 30.dp, 20.dp, 70.dp)
            .clip(RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center,
        ) {

            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 160.dp
                ),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
                    .alpha(1f)
                    .blur(0.dp)
                    .clip(RoundedCornerShape(16.dp))
                ,
                shape = RoundedCornerShape(16.dp),
//                    background = Brush.verticalGradient(
//                    colors = listOf(Color(0xFFE0E0E0), Color(0xFFFFFFFF))
//                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black.copy(alpha = 0.6f)
                ),
            ){
                Column(
                    modifier = Modifier
                        .padding(20.dp,20.dp,20.dp,50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ){
                        Text(
                            text = "Generate Custom Game",
                            fontSize = 38.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 40.sp,
                            color = Color(0xFF0CDA7A).copy(alpha = 0.99f),
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Column{
                        OutlinedTextField(
                            value = lowerLim,
                            onValueChange = {lowerLim=it},
                            placeholder = {Text("Enter Lower Limit", color = Color.White)},
                            modifier = Modifier.border(
                                BorderStroke(
                                    4.dp,
                                    Color.White.copy(alpha = 0.8f)
                                ),
                                shape= RoundedCornerShape(12.dp)
                            ),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number
                            ),
                            shape = RoundedCornerShape(12.dp),
//                            label = { Text("Enter Upper Limit") },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedLabelColor = Color(0xFFE0E0E0), // Off-white color for label when focused
                                focusedTextColor = Color(0xFFE0E0E0), // Off-white color for indicator when focused
                                unfocusedTextColor = Color(0xFFE0E0E0), // Off-white color for indicator when not focused
                                cursorColor = Color(0xFFE0E0E0), // Off-white color for text
                                containerColor = Color.Transparent // Ensure background is transparent
                            ),
                            singleLine = true,
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        OutlinedTextField(
                            value = upperLim,
                            onValueChange = {upperLim=it},
                            placeholder = {Text("Enter Upper Limit",color = Color.White)},
                            modifier = Modifier.border(
                                BorderStroke(
                                    4.dp,
                                    Color.White.copy(alpha = 0.8f),
                                ),
                                shape = RoundedCornerShape(12.dp),
                            ),
                            shape = RoundedCornerShape(12.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedLabelColor = Color(0xFFE0E0E0), // Off-white color for label when focused
                                focusedTextColor = Color(0xFFE0E0E0), // Off-white color for indicator when focused
                                unfocusedTextColor = Color(0xFFE0E0E0), // Off-white color for indicator when not focused
                                cursorColor = Color(0xFFE0E0E0), // Off-white color for text
                                containerColor = Color.Transparent // Ensure background is transparent
                            ),
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        OutlinedTextField(
                            value = maxtrails,
                            onValueChange = {maxtrails=it},
                            placeholder = {Text("Enter Maximum Trials",color = Color.White)},
                            modifier = Modifier.border(
                                BorderStroke(
                                    4.dp,
                                    Color.White.copy(alpha = 0.8f),
                                ),
                                shape = RoundedCornerShape(12.dp),
                            ),
                            shape = RoundedCornerShape(12.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedLabelColor = Color(0xFFE0E0E0), // Off-white color for label when focused
                                focusedTextColor = Color(0xFFE0E0E0), // Off-white color for indicator when focused
                                unfocusedTextColor = Color(0xFFE0E0E0), // Off-white color for indicator when not focused
                                cursorColor = Color(0xFFE0E0E0), // Off-white color for text
                                containerColor = Color.Transparent // Ensure background is transparent
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    ThreeDButton(
                        btn_text = "Start Game",
                        onClick = {
                            focusManager.clearFocus()
                            navController.navigate("customgame/$lowerLim/$upperLim/$maxtrails")
                            }
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}