package com.ngga_ring.mobileapppembayaranqris.data.repository

import com.ngga_ring.mobileapppembayaranqris.data.db.dao.UserDao
import com.ngga_ring.mobileapppembayaranqris.data.models.QrisScanModels
import javax.inject.Inject

class QrisRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun insertTras(data: QrisScanModels) {
        userDao.insert(data)
    }

    suspend fun getData(): List<QrisScanModels> {
        return userDao.gettras()
    }
}