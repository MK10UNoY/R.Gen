package com.medicare.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpertGameScreen( musicViewModel: MusicViewModel,gameStatsViewModel: GameStatsViewModel = viewModel()) {
    var answer by rememberSaveable {
        mutableStateOf(generateRandomNumberFrom1to1000().toString() ?: "0")
    }

    var userGuess by rememberSaveable { mutableStateOf("") }
    var attempts by rememberSaveable { mutableIntStateOf(0) }
    var remainingattempts = 12-attempts
    var result by rememberSaveable { mutableStateOf("") }
    var gameOver by rememberSaveable { mutableStateOf(false) }
    var winloose by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(0.dp))
    ){
        Image(
            painter = painterResource(id = R.drawable.home_bg),
            contentDescription = "CustomBG1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(4.dp)
        )
        Text(
            text = "$remainingattempts",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 30.dp, 30.dp, 0.dp),
            color = Color(0xFFE26900),
            textAlign = TextAlign.Right,
            fontSize = 72.sp,
            fontWeight = FontWeight.W600,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 30.dp, 20.dp, 70.dp)
                .clip(RoundedCornerShape(16.dp))
            , contentAlignment = Alignment.Center

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
//                    .height(300.dp)
                ,
                shape = RoundedCornerShape(16.dp),
//                    background = Brush.verticalGradient(
//                    colors = listOf(Color(0xFFE0E0E0), Color(0xFFFFFFFF))
//                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF5C0B0B).copy(alpha = 0.6f)
                ),
            ){
                Column(
                    modifier = Modifier.padding(20.dp,20.dp,20.dp,50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ){
                        Text(
                            text = "Guess a number between 1-1000",
                            fontSize = 36.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 36.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White.copy(alpha = 0.94f)
                        )
                    }
                    Spacer(Modifier.padding(16.dp))
                    Column {
                        OutlinedTextField(
                            value = userGuess,
                            onValueChange = {input:String ->
                                if (!gameOver) {
                                    userGuess = input
                                }
                            },
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
                            placeholder = { Text("Guess a Number",
                                color = Color.White.copy(0.9f)
                            )}
                        )
                    }
                    Spacer(Modifier.padding(16.dp))
                    Button(colors = ButtonDefaults.buttonColors(
                        Color(0xFFE45D28),
                        Color.White,
                        Color.White,
                        Color.White,
                    ),onClick = {if (!gameOver && userGuess.isNotBlank()) {
                        attempts++
                        val guess = userGuess.toIntOrNull()

                        if (guess != null) {
                            when {
                                (guess > 1000) -> {
                                    result = "Out of Bounds! Try Again"
                                    attempts--
                                }
                                (guess < 1) -> {
                                    result = "Out of Bounds! Try Again"
                                    attempts--
                                }
                                (guess < answer.toIntOrNull()!!) -> result = "Too low! Try again."
                                (guess > answer.toIntOrNull()!!)-> result = "Too high! Try again."
                                else -> {
                                    result = "Congratulations! You've guessed it!"
                                    gameOver = true
                                    gameStatsViewModel.incrementWins()
                                }
                            }

                            if (attempts >= 12 && !gameOver) {
                                result = "You've used all attempts! You Lose!"
                                gameOver = true
                                gameStatsViewModel.incrementLosses()
                            }
                        }}}) {
                        Text("Guess",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                shadow = Shadow(
                                    color = Color.Black.copy(alpha = 0.25f),
                                    offset = Offset(2f, 3f),
                                    blurRadius = 4f
                                )
                            ))
                    }
                    Spacer(Modifier.padding(16.dp))
                    Column(Modifier.fillMaxWidth()) {
                        Text(
                            textAlign = TextAlign.Left,
                            text = "Verdict :",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.W600,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White,
                        )
                        Text(
                            textAlign = TextAlign.Left,
                            text = "$result",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.W600,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Green,
                        )
                        if (gameOver) {
                            Spacer(Modifier.padding(16.dp))
                            ElevatedButton(onClick = {
                                answer = generateRandomNumberFrom1to1000().toString()
                                userGuess = ""
                                attempts = 0
                                result = ""
                                gameOver = false
                            },
                                colors = ButtonDefaults.elevatedButtonColors(
                                    Color.Red,
                                    Color.White,
                                    Color.White,
                                    Color.White,
                                )) {
                                Text("Try Again",
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.W600,
                                    fontStyle = FontStyle.Normal,
                                )
                            }
                            Text("Answer is $answer",
                                color = Color.Green,
                                fontSize = 28.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.W600,
                                fontStyle = FontStyle.Normal,
                            )
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ExpertScreenPreview(){
//    ExpertGameScreen()
//}