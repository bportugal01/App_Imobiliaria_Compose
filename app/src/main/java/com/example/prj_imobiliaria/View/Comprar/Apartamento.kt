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
import com.example.prj_imobiliaria.componentes.CardCasaAp


@Composable
fun ApartamentosScreen() {
    val casas = listOf(
        CasaAp(
            imagemResId = R.drawable.apartamento,
            preco = "R$ 4.800.000",
            descricao = "Apartamento para venda em Jardim São Caetano de 459.00m² com 4 Quartos."
        ),
        CasaAp(
            imagemResId = R.drawable.apartamento2,
            preco = "R$ 385.000",
            descricao = "Apartamento 2 dormitórios 1 vaga - 52m² Macedo Guarulhos - SP."
        ),
        CasaAp(
            imagemResId = R.drawable.apartamento3,
            preco = "R$ 3.970.000",
            descricao = "Apartamento Campo Belo 4 Quartos 219 Metros Quadrados."
        )
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFF6E0C8)),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(casas) { casa ->
            CardCasaAp(casa = casa)
        }
    }
}


data class CasaAp(
    val imagemResId: Int,
    val preco: String,
    val descricao: String
)
