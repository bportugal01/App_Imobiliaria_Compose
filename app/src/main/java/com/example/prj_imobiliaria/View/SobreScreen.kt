package com.example.prj_imobiliaria.View

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.prj_imobiliaria.R
import com.example.prj_imobiliaria.View.Map.Map
import com.example.prj_imobiliaria.componentes.CardIcon
import com.example.prj_imobiliaria.componentes.CardWithTopAppBar

@Composable
fun SobreScreen() {
    val iconList = listOf(
        painterResource(R.drawable.facebook),
        painterResource(R.drawable.instagram),
        painterResource(R.drawable.chamada_telefonica),
        painterResource(R.drawable.internet),
        painterResource(R.drawable.o_email),
        painterResource(R.drawable.whatsapp)
    )
    val context = LocalContext.current
    val webLauncher: ActivityResultLauncher<Intent> =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            // Lidar com o resultado, se necessário
        }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6E0C8))

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6E0C8))
                .padding(14.dp)

        ) {


            item {
                CardIcon(iconList) { clickedIconIndex ->
                    // Lidar com a ação quando um ícone é clicado
                    val websiteUrl = when (clickedIconIndex) {
                        0 -> "https://www.facebook.com"
                        1 -> "https://www.instagram.com"
                        2 -> "tel:+123456789" // Número de telefone fictício, ajuste para o seu
                        3 -> "https://www.google.com" // Exemplo de site
                        4 -> "mailto:contato@example.com" // Endereço de e-mail fictício, ajuste para o seu
                        5 -> "https://api.whatsapp.com/send?phone=123456789" // Número de telefone fictício, ajuste para o seu
                        else -> null
                    }

                    websiteUrl?.let {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))
                        webLauncher.launch(intent)
                    }
                }
            }

            item {
                CardWithTopAppBar(
                    "Quem Somos",
                    "Somos uma imobiliária dedicada a ajudar você a encontrar a casa dos seus sonhos. Com uma equipe de profissionais experientes, estamos comprometidos em tornar o processo de compra, venda ou aluguel de imóveis o mais simples e tranquilo possível. Nossa missão é proporcionar a você a melhor experiência imobiliária. Entre em contato conosco para saber como podemos ajudar.",
                    Color(0xFF2F5663)
                ) {
                    // Coloque o conteúdo da seção "Quem Somos" aqui
                }
            }

            item {
                CardWithTopAppBar(
                    "Horário de Funcionamento",
                    "Segunda a Sexta das 09:00h às 18:00h\n" + "Sábado das 09:00h às 20:00h\n" + "Estamos disponíveis para ajudá-lo a encontrar a propriedade perfeita durante esses horários.",
                    Color(0xFF2F5663)
                ) {
                    // Coloque o conteúdo da seção "Horário de Funcionamento" aqui
                }
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column {
                        Map()
                    }
                }
            }
        }
    }
}