package com.example.prj_imobiliaria.View.Comprar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.prj_imobiliaria.R
import com.example.prj_imobiliaria.componentes.CardCasaTerreno

@Composable
fun TerrenosScreen() {
    val casas = listOf(
        CasaTerreno(
            imagemResId = R.drawable.terreno1,
            preco = "R$ 310.000",
            descricao = "Terreno com 411m², pronto para construir."
        ),
        CasaTerreno(
            imagemResId = R.drawable.terreno2,
            preco = "R$ 750.000",
            descricao = "Construa a chácara dos seus sonhos em uma área de 36.000m."
        ),
        CasaTerreno(
            imagemResId = R.drawable.terreno3,
            preco = "R$ 160.000",
            descricao = "Terreno plaino c/268m no JD das Palmeiras em Limeira SP."
        )
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFF6E0C8)),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(casas) { casa ->
            CardCasaTerreno(casa = casa)
        }
    }
}


data class CasaTerreno(
    val imagemResId: Int,
    val preco: String,
    val descricao: String
)
