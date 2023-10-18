package com.example.prj_imobiliaria.View.Map

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun Map() {
    val saoPaulo = LatLng(-23.550520, -46.633308) // Coordenadas de São Paulo
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(saoPaulo, 10f)
    }
    Column {
        TopAppBar(
            title = { Text(text = "Localização") },
            backgroundColor = Color(0xFF2F5663), // Cor de plano de fundo do TopAppBar
            modifier = Modifier.fillMaxWidth()
        )
        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp), // Defina a altura desejada
            cameraPositionState = cameraPositionState,
            properties = MapProperties(mapType = MapType.HYBRID)
        ) {
            Marker(
                state = MarkerState(position = saoPaulo),
                title = "São Paulo",
                snippet = "Marker in São Paulo"
            )
        }
    }
}
