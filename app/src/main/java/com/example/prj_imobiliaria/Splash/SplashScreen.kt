package com.example.prj_imobiliaria.Splash

import TailwindCSSColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.prj_imobiliaria.R
import kotlinx.coroutines.delay
import java.lang.Math.min
import kotlin.random.Random

val Colors.dotBackground: Color
    get() = if (isLight) TailwindCSSColor.Gray200 else TailwindCSSColor.Gray800

@Composable
fun SplashScreen(navController: NavHostController) {
    val density = LocalDensity.current
    val dotBackground = MaterialTheme.colors.dotBackground
    LaunchedEffect(Unit) {
        delay(15000) // Exemplo: atraso de 2 segundos para simular a exibição do splash
        navController.navigate("Home") {
            // Configurar a ação de navegação para a home
            popUpTo("Splash") {
                inclusive = false // Não incluir o destino "Splash" na pilha de volta
            }
        }
    }
    Scaffold { innerPadding ->
        BoxWithConstraints(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF6E0C8))
        ) {
            with(density) {
                val maxWidth = maxWidth
                val maxHeight = maxHeight

                for (i in 0..25) {
                    var state by remember { mutableStateOf(false) }

                    LaunchedEffect(Unit) {
                        while (true) {
                            delay(Random.nextLong(300, 1000))
                            state = true
                            delay(2600)
                            state = false
                            delay(2600)
                        }
                    }

                    val animScale by animateFloatAsState(
                        targetValue = if (state) 1f else .75f, animationSpec = tween(
                            durationMillis = 1900, easing = LinearEasing
                        ), label = ""
                    )

                    val animCenterX by animateFloatAsState(
                        targetValue = if (state) .8f else 1f, animationSpec = tween(
                            durationMillis = 1900, easing = FastOutSlowInEasing
                        )
                    )

                    val animCenterY by animateFloatAsState(
                        targetValue = if (state) .8f else 1f, animationSpec = tween(
                            durationMillis = 1900, easing = FastOutSlowInEasing
                        )
                    )

                    val centerX = remember {
                        Random.nextInt(0, maxWidth.toPx().toInt()).toFloat()
                    }
                    val centerY = remember {
                        Random.nextInt(0, maxHeight.toPx().toInt()).toFloat()
                    }
                    val radius = remember {
                        Random.nextInt(16, min(maxWidth.toPx(), minHeight.toPx()).toInt() / 14)
                            .toFloat()
                    }
                    val alpha = remember { (Random.nextInt(10, 50) / 100f) }

                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCircle(
                            color = dotBackground, center = Offset(
                                x = if (i % 2 != 0) centerX * animCenterX else centerX,
                                y = if (i % 2 == 0) centerY * animCenterY else centerY
                            ), radius = radius * animScale, alpha = alpha
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var state by remember { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                while (true) {
                    val startDelay = Random.nextLong(300, 900)
                    delay(startDelay)
                    state = true
                    delay(3000)
                    state = false
                    delay(2000 - startDelay)
                }
            }

            val animAlpha by animateFloatAsState(
                targetValue = if (state) 1f else 0f, animationSpec = tween(
                    durationMillis = 900, easing = FastOutSlowInEasing
                )
            )

            val animRotation by animateFloatAsState(
                targetValue = if (state) 360f else 0f, animationSpec = tween(
                    durationMillis = 900, easing = FastOutSlowInEasing
                )
            )

            val animScale by animateFloatAsState(
                targetValue = if (state) 1f else 0f, animationSpec = tween(
                    durationMillis = 900, easing = FastOutSlowInEasing
                )
            )

            Image(
                modifier = Modifier
                    .size(250.dp)
                    .graphicsLayer {
                        alpha = animAlpha
                        rotationX = animRotation
                        rotationY = animRotation
                        rotationZ = animRotation
                        scaleX = animScale
                        scaleY = animScale
                    },
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Why Not Compose!"
            )

            AnimatedText(
                text = "Imobiliária Compose",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            )
        }
    }
}


@Composable
fun AnimatedText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        text.forEach { char ->

            var state by remember { mutableStateOf(false) }

            LaunchedEffect(char) {
                while (true) {
                    val startDelay = Random.nextLong(300, 900)
                    delay(startDelay)
                    state = true
                    delay(3000)
                    state = false
                    delay(2000 - startDelay)
                }
            }

            val animAlpha by animateFloatAsState(
                targetValue = if (state) 1f else 0f, animationSpec = tween(
                    durationMillis = 900, easing = FastOutSlowInEasing
                )
            )

            Text(
                text = char.toString(),
                color = Color(0xFF2F5663),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.graphicsLayer {
                    alpha = animAlpha
                }
            )
        }
    }
}