package com.example.prj_imobiliaria.View.Alugar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.prj_imobiliaria.R
import com.example.prj_imobiliaria.componentes.CardAluguel


@Composable
fun CasasScreen() {
    val casas = listOf(
        CasaAluguel(
            imagemResId = R.drawable.aluguel,
            titulo = "Casa",
            localizacao = "Av. Lino Jardim - São Paulo",
            preco = "R$ 3.800 - mês",
            descricao = "Aluga-se excelente ponto comercial próximo a Av. Lino Jardim, 3 salas com uma copa."
        ),
        CasaAluguel(
            imagemResId = R.drawable.aluguel2,
            titulo = "Casa",
            localizacao = "Brooklin - São Paulo",
            preco = "R$ 15.000 - mês",
            descricao = "Casa localizada na melhor rua do Brooklin, próxima à Hípica Paulista. Conta com 280 m² de área construída."
        ),
        CasaAluguel(
            imagemResId = R.drawable.aluguel3,
            titulo = "Casa",
            localizacao = "Guarulhos - São Paulo",
            preco = "R$ 35.815 - mês",
            descricao = "Casa ampla, bastante ventilada, clara, piscina com jardim, churrasqueira, 6 quartos sendo ótimas suítes."
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFF6E0C8)),
    ) {
        items(casas) { casa ->
            CardAluguel(casa)
        }
    }
}

data class CasaAluguel(
    val imagemResId: Int,
    val titulo: String,
    val localizacao: String,
    val preco: String,
    val descricao: String,
)