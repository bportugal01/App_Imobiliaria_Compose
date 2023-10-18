import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prj_imobiliaria.R
import com.example.prj_imobiliaria.View.ImageUp.ImagePickerScreen
import com.example.prj_imobiliaria.componentes.CustomButton
import com.example.prj_imobiliaria.componentes.CustomTextField
import com.example.prj_imobiliaria.componentes.CustomTextFieldDone
import com.example.prj_imobiliaria.componentes.Demo_ExposedDropdownMenuBox
import kotlinx.coroutines.delay

@Composable
fun AnuncioScreen() {
    var enderecoImovel by remember { mutableStateOf("") }
    var precoVenda by remember { mutableStateOf("") }
    var descricaoImovel by remember { mutableStateOf("") }
    var nomeProprietario by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var isButtonClicked by remember { mutableStateOf(false) }
    val scrollState = rememberLazyListState()

    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6E0C8))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LazyColumn(
                state = scrollState,

                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF6E0C8))
            ) {
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Cadastre seu Imóvel", style = TextStyle(
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2F5663) // Cor desejada, por exemplo, Color.Red
                            ), modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                item {
                    Demo_ExposedDropdownMenuBox(
                        arrayOf("Casa", "Apartamento", "Chácara", "Comercial"), "Tipo de imóvel"
                    )
                }
                item {
                    Demo_ExposedDropdownMenuBox(
                        arrayOf("Locação", "Venda", "Locação e venda"), "Disponível para"
                    )
                }

                item {
                    CustomTextField(
                        value = enderecoImovel,
                        onValueChange = { enderecoImovel = it },
                        label = "Endereço do imóvel",
                        leadingIconResId = R.drawable.baseline_location_on_24
                    )
                }

                item {
                    CustomTextField(
                        value = precoVenda,
                        onValueChange = { precoVenda = it },
                        label = "Preço da venda",
                        leadingIconResId = R.drawable.baseline_attach_money_24
                    )
                }

                item {
                    CustomTextField(
                        value = descricaoImovel,
                        onValueChange = { descricaoImovel = it },
                        label = "Descrição do imóvel",
                        leadingIconResId = R.drawable.baseline_description_24
                    )
                }

                item {
                    CustomTextField(
                        value = nomeProprietario,
                        onValueChange = { nomeProprietario = it },
                        label = "Nome do proprietário",
                        leadingIconResId = R.drawable.baseline_person_2_24
                    )
                }

                item {
                    CustomTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = "Email",
                        leadingIconResId = R.drawable.baseline_alternate_email_24
                    )
                }

                item {
                    CustomTextFieldDone(
                        value = telefone,
                        onValueChange = { telefone = it },
                        label = "Telefone",
                        leadingIconResId = R.drawable.baseline_local_phone_24
                    )
                }

                item {
                    ImagePickerScreen()
                }

                item {
                    CustomButton(
                        onClick = { isButtonClicked = true }, buttonText = "Enviar"
                    )
                }

                item {
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFF6E0C8))
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AnimatedVisibility(
                                visible = isButtonClicked, enter = fadeIn(), exit = fadeOut()
                            ) {
                                Text(
                                    text = "Enviado com Sucesso!",
                                    fontSize = 20.sp,
                                    color = Color(0xFF2F5663),
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                        .wrapContentWidth(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                }
            }

            LaunchedEffect(isButtonClicked) {
                if (isButtonClicked) {
                    delay(1000) // Tempo em milissegundos para a tela de erro ficar visível
                    isButtonClicked =
                        false // Define a variável isButtonClicked como false para esconder a tela de erro
                }
            }
        }
    }
}