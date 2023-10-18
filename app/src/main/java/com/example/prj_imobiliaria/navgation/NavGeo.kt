package com.example.prj_imobiliaria.navgation

import AnuncioScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.prj_imobiliaria.Splash.SplashScreen
import com.example.prj_imobiliaria.View.AlugarScreen
import com.example.prj_imobiliaria.View.ComprarScreen
import com.example.prj_imobiliaria.View.HomeScreen
import com.example.prj_imobiliaria.View.NovosScreen
import com.example.prj_imobiliaria.View.SobreScreen
import kotlinx.coroutines.delay


@Composable
fun NavGeo(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Splash",
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {

        composable("Home") {
            HomeScreen(navController)

        }
        composable("Comprar") {
            ComprarScreen()
        }
        composable("Anuncio") {
            AnuncioScreen()
        }
        composable("Alugar") {
            AlugarScreen()
        }
        composable("Novos") {
            NovosScreen()
        }
        composable("Sobre") {
            SobreScreen()
        }
        composable("Splash") {
            SplashScreen(navController)
            LaunchedEffect(Unit) {
                delay(15000) // Exemplo: atraso de 2 segundos para simular a exibição do splash
                navController.navigate("Home") {
                    // Configurar a ação de navegação para a home
                    popUpTo("Splash") {
                        inclusive = false // Não incluir o destino "Splash" na pilha de volta
                    }
                }
            }
        }
    }
}


fun getTopBarTitle(route: String?): String {
    return when (route) {
        NavigationItem.Home.route -> "Home"
        NavigationItem.Comprar.route -> "Comprar"
        NavigationItem.Anuncio.route -> "Anunciar"
        NavigationItem.Alugar.route -> "Alugar"
        NavigationItem.Novos.route -> "Novos"
        NavigationItem.Sobre.route -> "Sobre"
        NavigationItem.Imobiliaria.route -> "Imobiliária"

        else -> "Imobiliária"
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    Scaffold(topBar = {
        val currentRoute = currentRoute(navController)
        TopBar(title = getTopBarTitle(currentRoute), showButton = currentRoute != "Home") {
            navController.navigateUp()
        }
    }, content = { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavGeo(navController)
        }
    })
}

@Composable
fun TopBar(title: String, showButton: Boolean = true, onBackPressed: () -> Unit = {}) {
    TopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }
    }, backgroundColor = Color(0xFF2F5663), navigationIcon = {
        if (showButton && title != "Home" && title != "Imobiliária") {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.White)
            }
        } else if (title == "Home") {
            // Adicionar o ícone de menu para a página "Home" aqui
            IconButton(onClick = { /* Lidar com o clique no ícone de menu */ }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
            }
        }
    })
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
