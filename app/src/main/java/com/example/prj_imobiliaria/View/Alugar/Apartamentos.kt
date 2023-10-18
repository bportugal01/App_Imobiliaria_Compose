package com.example.prj_imobiliaria.View.Alugar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.prj_imobiliaria.R


@Composable
fun ApartamentoScreen() {
    val casas = listOf(
        CasaAluguelap(
            imagemResId = R.drawable.ap,
            titulo = "Apartamento  ",
            localizacao = "Vila Olímpia - São Paulo ",
            preco = "R$ 2.800 - mês",
            descricao = "Apartamento para aluguel com 45 metros quadrados com 1 quarto "
        ),
        CasaAluguelap(
            imagemResId = R.drawable.ap2,
            titulo = "Apartamento",
            localizacao =  "Suzano - São Paulo",
            preco = "R$ 1.390 - mês" ,
            descricao = "Apartamento com 2 dormitórios, 40 m²"
        ),
        CasaAluguelap(
            imagemResId = R.drawable.ap3,
            titulo = "Apartamento",
            localizacao = "Av Paulista - São Paulo",
            preco = "R$ 5.300 - mês",
            descricao = "Apartamento para alugar em Vila Olímpia de 72.00 m² "
        )
    )

    LazyColumn {
        items(casas) { casa ->
            CardAluguelAp(casa)
        }
    }
}

@Composable
fun CardAluguelAp(casa: CasaAluguelap) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF6E0C8))
            .padding(8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = casa.imagemResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = casa.titulo,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = casa.localizacao,
                style = MaterialTheme.typography.body1,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = casa.preco,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = casa.descricao,
                style = MaterialTheme.typography.body1,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

data class CasaAluguelap(
    val imagemResId: Int,
    val titulo: String,
    val localizacao: String,
    val preco: String,
    val descricao: String,
)
