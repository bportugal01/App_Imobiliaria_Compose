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
import com.example.prj_imobiliaria.componentes.CardCasa

@Composable
fun CasasScreen() {
    val casas = listOf(
        Casa(
            imagemResId = R.drawable.casa1,
            preco = "R$ 500.000",
            descricao = "Casa com 3 quartos e 2 banheiros"
        ),
        Casa(
            imagemResId = R.drawable.casa2,
            preco = "R$ 750.000",
            descricao = "Casa moderna com piscina e jardim"
        ),
        Casa(
            imagemResId = R.drawable.casa3,
            preco = "R$ 1.200.000",
            descricao = "Casa de luxo com vista para o mar"
        )
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFF6E0C8)),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(casas) { casa ->
            CardCasa(casa = casa)
        }
    }
}


data class Casa(
    val imagemResId: Int,
    val preco: String,
    val descricao: String
)
