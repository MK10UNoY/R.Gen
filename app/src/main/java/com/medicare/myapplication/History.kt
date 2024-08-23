package com.medicare.myapplication

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun History(
    musicViewModel: MusicViewModel = viewModel(),
    gameStatsViewModel: GameStatsViewModel = viewModel()
    ){
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(0.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_bg),
            contentDescription = "CustomBG1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(4.dp)
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
            , horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
                    .size(200.dp)
                ,
                shape = RoundedCornerShape(16.dp),
//                    background = Brush.verticalGradient(
//                    colors = listOf(Color(0xFFE0E0E0), Color(0xFFFFFFFF))
//                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF103D64).copy(alpha = 0.6f)
                ),

            ) {
                Column (Modifier
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,

                ){
                    val totalWins by gameStatsViewModel.totalWins.collectAsState()
                    val totalLosses by gameStatsViewModel.totalLosses.collectAsState()

                    Text(
                        text = "Total Wins: $totalWins",
                        color = Color.Green,
                        fontSize = 28.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.W600
                    )
                    Spacer(Modifier.padding(20.dp))
                    Text(
                        text = "Total Losses: $totalLosses",
                        color = Color.Red,
                        fontSize = 28.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.W600
                    )
                }
            }
            Spacer(Modifier.padding(80.dp))
            Text(
                text = "Designed And Developed by Mrinmoy Koiri",
                color = Color.Black.copy(0.96f),
                fontSize = 32.sp,
                textAlign = TextAlign.End,
                lineHeight = 38.sp,
                softWrap = true,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W600,
                modifier = Modifier.padding(0.dp,0.dp,0.dp,2.dp)
            )
            Button(colors = ButtonDefaults.buttonColors(
                Color.Blue,
                Color.White,
                Color.White,
                Color.White,
            ),onClick = {
                val url = "https://github.com/MK10UNoY"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            }) {
                Text("Learn More...",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.95f),
                            offset = Offset(2f, 3f),
                            blurRadius = 4f
                        )
                    )
                )
            }
        }
    }
}