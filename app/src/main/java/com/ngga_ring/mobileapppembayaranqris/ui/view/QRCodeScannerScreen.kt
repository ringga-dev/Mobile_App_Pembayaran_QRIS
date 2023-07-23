package com.ngga_ring.mobileapppembayaranqris.ui.view

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun MyScreen() {
    val context = LocalContext.current
    var hasCameraPermission by remember { mutableStateOf(false) }

    // Fungsi untuk menghandle hasil permintaan izin kamera
    val onCameraPermissionResult: (Boolean) -> Unit = { isGranted ->
        hasCameraPermission = isGranted
    }

    // Memanggil fungsi PermissionRequestDialog untuk meminta izin kamera
    PermissionRequestDialog(
        permission = Manifest.permission.CAMERA, // Menggunakan konstanta dari Android Manifest
        onResult = onCameraPermissionResult
    )

    // Tampilkan UI berdasarkan izin kamera yang diizinkan atau tidak
    if (hasCameraPermission) {
        // Tampilkan komponen yang memerlukan izin kamera di sini
        Text(text = "Izin kamera diberikan!")
    } else {
        Text(text = "Tidak diizinkan untuk mengakses kamera.")
    }
}

@Preview
@Composable
fun PreviewMyScreen() {
    MyScreen()
}