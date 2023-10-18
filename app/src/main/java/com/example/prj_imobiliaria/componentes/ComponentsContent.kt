package com.example.prj_imobiliaria.componentes

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prj_imobiliaria.View.Alugar.CasaAluguel
import com.example.prj_imobiliaria.View.CasaNaPlanta
import com.example.prj_imobiliaria.View.Comprar.Casa
import com.example.prj_imobiliaria.View.Comprar.CasaAp
import com.example.prj_imobiliaria.View.Comprar.CasaTerreno

@Composable
fun CardClicavel(texto: String, iconId: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(100.dp) // Ajuste o tamanho do card aqui
                .clickable { onClick() },
            backgroundColor = Color(0xFFD8B188),
            shape = RoundedCornerShape(16.dp),
            elevation = 4.dp
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = texto,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun CardCasa(casa: Casa) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
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

@Composable
fun CardCasaAp(casa: CasaAp) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
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

@Composable
fun CardCasaTerreno(casa: CasaTerreno) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
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

@Composable
fun CardAluguel(casa: CasaAluguel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
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
                text = casa.localizacao, style = MaterialTheme.typography.body1, color = Color.Gray
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


@Composable
fun CardCasaNaPlanta(casa: CasaNaPlanta) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
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
                text = casa.localizacao, style = MaterialTheme.typography.body1, color = Color.Gray
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


@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIconResId: Int,

    ) {
    val leadingIcon = painterResource(leadingIconResId)

    TextField(
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label, color = Color(0xFF383B38)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textStyle = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color.Black
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            cursorColor = Color.DarkGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        leadingIcon = {
            Icon(
                painter = leadingIcon, contentDescription = "Ícone", tint = Color(0xFF2F5663)
            )
        },

        )
}


@Composable
fun CustomTextFieldDone(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIconResId: Int,

    ) {
    val leadingIcon = painterResource(leadingIconResId)

    TextField(
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label, color = Color(0xFF383B38)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textStyle = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color.Black
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            cursorColor = Color.DarkGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        leadingIcon = {
            Icon(
                painter = leadingIcon, contentDescription = "Ícone"
            )
        },

        )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun Demo_ExposedDropdownMenuBox(
    items: Array<String>,
    title: String,
) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(title) }

    ExposedDropdownMenuBox(
        expanded = expanded, onExpandedChange = {
            expanded = !expanded
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp) // Ajuste a margem aqui
    ) {
        TextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color(0xFF383B38)
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = Color.DarkGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Ajuste a margem aqui
        ) {
            items.forEach { item ->
                DropdownMenuItem(text = { Text(text = item, color = Color(0xFF383B38)) },
                    onClick = {
                        selectedText = item
                        expanded = false
                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                    })
            }
        }
    }
}


@Composable
fun CustomButton(
    onClick: () -> Unit,
    buttonText: String,
) {
    Button(

        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(45.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF2F5663), contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ) {

        Text(text = buttonText)
    }
}

@Composable
fun CardWithTopAppBar(
    title: String,
    content: String,
    backgroundColor: Color,
    contentBlock: @Composable () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            TopAppBar(
                title = { Text(text = title, color = Color.White) },
                backgroundColor = backgroundColor
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.body1,
                color = Color.Gray


            )
            contentBlock()
        }
    }
}

@Composable
fun CardIcon(iconList: List<Painter>, onIconClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            TopAppBar(
                title = { Text(text = "Contatos", color = Color.White) },
                backgroundColor = Color(0xFF2F5663) // Cor de plano de fundo do TopAppBar
            )
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (index in iconList.indices) {
                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.White, shape = CircleShape)
                            .clickable {
                                onIconClick(index)
                            }) {
                        Image(
                            painter = iconList[index],
                            contentDescription = null,
                            modifier = Modifier.size(28.dp),
                            colorFilter = ColorFilter.tint(Color.Black)
                        )
                    }
                }
            }
        }
    }
}

