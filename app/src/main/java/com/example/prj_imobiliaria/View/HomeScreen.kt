package com.example.prj_imobiliaria.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prj_imobiliaria.R
import com.example.prj_imobiliaria.componentes.CardClicavel

@Composable

fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6E0C8))
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color(0xFFF6E0C8)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardClicavel(texto = "Comprar", iconId = R.drawable.comprar) {
                navController.navigate("Comprar")
            }

            CardClicavel(texto = "Alugar", iconId = R.drawable.alugar) {
                navController.navigate("Alugar")
            }

            CardClicavel(texto = "Novos", iconId = R.drawable.novo) {
                navController.navigate("Novos")
            }

            CardClicavel(texto = "Anuncie no app", iconId = R.drawable.anuncio) {
                navController.navigate("Anuncio")
            }

            CardClicavel(texto = "Sobre nós", iconId = R.drawable.info) {
                navController.navigate("Sobre")
            }
        }

        Text(
            text = "Desenvolvido por Bruno Portugal",
            color = Color(0xFF2F5663),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}
