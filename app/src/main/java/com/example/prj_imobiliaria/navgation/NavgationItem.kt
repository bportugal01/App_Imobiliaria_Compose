package com.example.prj_imobiliaria.navgation

import com.example.prj_imobiliaria.R

sealed class NavigationItem(val route: String, val icon: Int, val title: String) {
    object Home : NavigationItem("Home", R.drawable.alugar, "Home")
    object Comprar : NavigationItem("Comprar", R.drawable.alugar, "Comprar")
    object Anuncio : NavigationItem("Anuncio", R.drawable.alugar, "Anunciar")
    object Novos : NavigationItem("Novos", R.drawable.alugar, "Novos")
    object Sobre : NavigationItem("Sobre", R.drawable.alugar, "Sobre")
    object Alugar : NavigationItem("Alugar", R.drawable.alugar, "Alugar")
    object Imobiliaria : NavigationItem("Imobiliaria", R.drawable.alugar, "Imobiliaria")
}
