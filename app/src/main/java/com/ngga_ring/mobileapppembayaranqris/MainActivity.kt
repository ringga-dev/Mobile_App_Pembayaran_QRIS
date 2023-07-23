package com.ngga_ring.mobileapppembayaranqris


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ngga_ring.mobileapppembayaranqris.data.extensi.getTimeDevide
import com.ngga_ring.mobileapppembayaranqris.data.extensi.getUser
import com.ngga_ring.mobileapppembayaranqris.data.extensi.saveUser
import com.ngga_ring.mobileapppembayaranqris.data.extensi.updateUser
import com.ngga_ring.mobileapppembayaranqris.data.models.QrisScanModels
import com.ngga_ring.mobileapppembayaranqris.data.models.UserModels
import com.ngga_ring.mobileapppembayaranqris.data.viewModels.QrisViewModel
import com.ngga_ring.mobileapppembayaranqris.ui.view.HomeScreen
import com.ngga_ring.mobileapppembayaranqris.ui.view.MyScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: QrisViewModel = viewModel()

            MyScreen()
            var userData by remember { mutableStateOf(getUser(this@MainActivity)) }

            val dataList = remember { mutableStateListOf<QrisScanModels>()}
            if (userData?.name == null) {
                saveUser(
                    this@MainActivity,
                    UserModels(
                        1, "Ringga Septia Pribadi",
                        500000,
                        getTimeDevide()
                    )
                )
                userData = getUser(this@MainActivity)
            }

            viewModel.getData().observe(this){
                it.data?.let {
                    dataList.addAll(it)
                    Log.e("Ringga Set data", it.size.toString())
                }
            }


            HomeScreen(
                accountInfo = userData!!, dataList,
                onClick = {
                    startActivity(Intent(this, ScanQRActivity::class.java))
                }) {
                val userupdate = UserModels(
                    userData?.id,
                    userData?.name,
                    500000 + userData?.saldo!!,
                    userData?.date
                )
                updateUser(this@MainActivity, userupdate)
                userData = getUser(this@MainActivity)
            }

        }
    }


}





