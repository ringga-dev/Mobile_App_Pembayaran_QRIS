package com.ngga_ring.mobileapppembayaranqris.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QrisScanModels(
    var bankName: String? = null,
    @PrimaryKey var idTransaksi: String = "",
    var namaMerchant: String? = null,
    var nominalTransaksi: String? = null
)
