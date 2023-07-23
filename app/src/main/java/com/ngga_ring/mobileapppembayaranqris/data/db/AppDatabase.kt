package com.ngga_ring.mobileapppembayaranqris.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ngga_ring.mobileapppembayaranqris.data.db.dao.UserDao
import com.ngga_ring.mobileapppembayaranqris.data.models.QrisScanModels

@Database(entities = [QrisScanModels::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}