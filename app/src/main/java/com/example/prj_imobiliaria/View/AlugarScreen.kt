package com.example.prj_imobiliaria.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.prj_imobiliaria.View.Alugar.ApartamentoScreen
import com.example.prj_imobiliaria.View.Alugar.CasasScreen


@Composable
fun AlugarScreen() {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Casas", "Apartamentos")
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color(0xFF4B7D8E),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    color = Color.White, // Defina a cor desejada para o indicador
                    height = 2.dp // Altura do indicador
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            text = title,
                            style = if (tabIndex == index) {
                                TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
                            } else {
                                TextStyle(color = Color.White, fontWeight = FontWeight.Normal)
                            }
                        )
                    },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    icon = {
                        when (index) {
                            0 -> Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color.White
                            )

                            1 -> Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        }
        when (tabIndex) {
            0 -> CasasScreen()
            1 -> ApartamentoScreen()

        }
    }
}
