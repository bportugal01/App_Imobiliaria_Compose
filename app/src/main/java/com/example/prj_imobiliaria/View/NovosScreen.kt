package com.example.prj_imobiliaria.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.prj_imobiliaria.R
import com.example.prj_imobiliaria.componentes.CardCasaNaPlanta

@Composable
fun NovosScreen() {
    val casas = listOf(
        CasaNaPlanta(
            imagemResId = R.drawable.planta1,
            titulo = "Casa na Planta",
            localizacao = "Vila Mariana - São Paulo",
            preco = "A partir de R$ 450.000",
            descricao = "Planta baixa de casas com 2 quartos e 1 suíte."
        ),
        CasaNaPlanta(
            imagemResId = R.drawable.planta2,
            titulo = "Casa à Venda",
            localizacao = "Torres - Rio Grande do Sul",
            preco = "A partir de R$ 2.000.000",
            descricao = "Casa com 6 dormitórios, 2 suítes e 5 banheiros."
        ),
        CasaNaPlanta(
            imagemResId = R.drawable.planta3,
            titulo = "Terreno à Venda",
            localizacao = "Itapoá - Santa Catarina",
            preco = "A partir de R$ 700.000",
            descricao = "Lote 03 da quadra 01, com área total de 336m² Terreno alto."
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6E0C8)),
    ) {
        items(casas) { casa ->
            CardCasaNaPlanta(casa)
        }
    }
}

data class CasaNaPlanta(
    val imagemResId: Int,
    val titulo: String,
    val localizacao: String,
    val preco: String,
    val descricao: String,
)