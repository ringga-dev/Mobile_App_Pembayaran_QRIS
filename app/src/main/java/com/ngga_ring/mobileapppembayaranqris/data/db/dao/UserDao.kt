package com.ngga_ring.mobileapppembayaranqris.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ngga_ring.mobileapppembayaranqris.data.models.QrisScanModels

@Dao
interface UserDao {

    @Query("SELECT * FROM qrisscanmodels")
    suspend fun gettras(): List<QrisScanModels>

    @Insert
    suspend fun insert(dataList: QrisScanModels)

    @Query("DELETE FROM QrisScanModels")
    suspend fun deleteAll()


}